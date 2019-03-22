package com.fenrir.tans.statusbardemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_status_bar_show.*

class ImageStatusShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(windowFlags)
        window.decorView.systemUiVisibility = systemUiFlags
        window.statusBarColor = statusBarColor
        setContentView(R.layout.activity_status_bar_show)
        if (isRootViewFitSystem) {
            root_layout.fitsSystemWindows = isRootViewFitSystem
        }
    }
}