package com.beckytech.kitaabagadaakutaatokkoffaa

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.widget.ImageButton
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

open class AppCallOutside : AppCompatActivity() {

    @SuppressLint("UseCompatLoadingForDrawables")
    fun openPopupMenu(context: Context, button: ImageButton) {
        val pop = PopupMenu(context, button)
        pop.menuInflater.inflate(R.menu.menu, pop.menu)
        pop.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.aboutMenu) {
                startActivity(Intent(context, AboutUsActivity::class.java))
            }

            if (menuItem.itemId == R.id.moreAppsMenu) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/developer?id=Beresa+Abebe")
                    )
                )
            }

            if (menuItem.itemId == R.id.rateMenu) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=com.beckytech.kitaabagadaakutaatokkoffaa")
                    )
                )
            }

            if (menuItem.itemId == R.id.updateMenu) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=com.beckytech.kitaabagadaakutaatokkoffaa")
                    )
                )
            }

            if (menuItem.itemId == R.id.shareMenu) {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(
                    Intent.EXTRA_SUBJECT,
                    "https://play.google.com/store/apps/details?id=com.beckytech.kitaabagadaakutaatokkoffaa"
                )
                intent.putExtra(
                    Intent.EXTRA_TEXT,
                    "Download Galata Gooftaa from play store \n https://play.google.com/store/apps/details?id=com.beckytech.kitaabagadaakutaatokkoffaa"
                )
                startActivity(Intent.createChooser(intent, "Share app's link via "))
            }

            if (menuItem.itemId == R.id.exitMenu) {
                val builder = MaterialAlertDialogBuilder(context)
                builder.setMessage("Cufu barbaadu?")
                builder.setIcon(R.mipmap.ic_launcher_round)
                builder.setTitle("Cufi")
                builder.setNegativeButton(
                    "Lakki"
                ) { dialogInterface: DialogInterface, _: Int -> dialogInterface.dismiss() }
                builder.setPositiveButton(
                    "Eeyyeen"
                ) { _: DialogInterface?, _: Int -> finish() }
                builder.background = resources.getDrawable(R.drawable.alert_dialog_bg, null)
                builder.show()
            }

            true
        }
        pop.show()
    }
}