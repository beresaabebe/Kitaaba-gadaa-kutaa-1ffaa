package com.beckytech.kitaabagadaakutaatokkoffaa

import android.app.Activity
import android.app.Application
import android.app.Application.ActivityLifecycleCallbacks
import android.content.Context
import android.os.Bundle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import com.google.android.gms.ads.*
import com.google.android.gms.ads.appopen.AppOpenAd
import com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback
import com.google.android.gms.ads.initialization.InitializationStatus
import java.util.*

open class MyApplication : Application(), ActivityLifecycleCallbacks,
    LifecycleObserver {
    private var appOpenAdManager: AppOpenAdManager? = null
    private var currentActivity: Activity? = null
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
        MobileAds.initialize(
            this
        ) { initializationStatus: InitializationStatus? -> }
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        appOpenAdManager = AppOpenAdManager()
    }

    protected fun onMoveToForeground() {
        // Show the ad (if available) when the app moves to foreground.
        appOpenAdManager!!.showAdIfAvailable(currentActivity!!)
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
    override fun onActivityStarted(activity: Activity) {
        if (!appOpenAdManager!!.isShowingAd) {
            currentActivity = activity
        }
    }

    override fun onActivityResumed(activity: Activity) {}
    override fun onActivityPaused(activity: Activity) {}
    override fun onActivityStopped(activity: Activity) {}
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
    override fun onActivityDestroyed(activity: Activity) {}
    fun showAdIfAvailable(
        activity: Activity,
        onShowAdCompleteListener: OnShowAdCompleteListener
    ) {
        appOpenAdManager!!.showAdIfAvailable(activity, onShowAdCompleteListener)
    }

    interface OnShowAdCompleteListener {
        fun onShowAdComplete()
    }

    private class AppOpenAdManager {
        private var appOpenAd: AppOpenAd? = null
        private var isLoadingAd = false
        var isShowingAd = false
        private var loadTime: Long = 0
        private fun loadAd(context: Context) {
            if (isLoadingAd || isAdAvailable) {
                return
            }
            isLoadingAd = true
            val request = AdRequest.Builder().build()
            AppOpenAd.load(
                context,
                AD_UNIT_ID,
                request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
                object : AppOpenAdLoadCallback() {
                    override fun onAdLoaded(ad: AppOpenAd) {
                        appOpenAd = ad
                        isLoadingAd = false
                        loadTime = Date().time
                    }

                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                        isLoadingAd = false
                    }
                })
        }

        private fun wasLoadTimeLessThanNHoursAgo(): Boolean {
            val dateDifference = Date().time - loadTime
            val numMilliSecondsPerHour: Long = 3600000
            return dateDifference < numMilliSecondsPerHour * 4L
        }

        private val isAdAvailable: Boolean
            get() = appOpenAd != null && wasLoadTimeLessThanNHoursAgo()

        fun showAdIfAvailable(
            activity: Activity,
            onShowAdCompleteListener: OnShowAdCompleteListener =
                object : OnShowAdCompleteListener {
                    override fun onShowAdComplete() {}
                }
        ) {
            if (isShowingAd) {
                return
            }
            if (!isAdAvailable) {
                onShowAdCompleteListener.onShowAdComplete()
                loadAd(activity)
                return
            }
            appOpenAd!!.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    appOpenAd = null
                    isShowingAd = false
                    onShowAdCompleteListener.onShowAdComplete()
                    loadAd(activity)
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    appOpenAd = null
                    isShowingAd = false
                    onShowAdCompleteListener.onShowAdComplete()
                    loadAd(activity)
                }

                override fun onAdShowedFullScreenContent() {}
            }
            isShowingAd = true
            appOpenAd!!.show(activity)
        }

        companion object {
            //        test ca-app-pub-3940256099942544/3419835294
            private const val AD_UNIT_ID = "ca-app-pub-8504401574247581/3694821285"
        }
    }
}