package com.fenrir.tans.statusbardemo

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.SeekBar
import androidx.annotation.IntRange
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var colorData: ColorData = ColorData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apha_sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                colorData = colorData.copy(a = (progress.toFloat() / 100f * 255f).toInt())
                color_pre_show_fl.setBackgroundColor(Color.argb(colorData.a, colorData.r, colorData.g, colorData.b).apply {
                    statusBarColor = this
                })
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {  }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {  }

        })
        red_sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                colorData = colorData.copy(r = (progress.toFloat() / 100f * 255f).toInt())
                color_pre_show_fl.setBackgroundColor(Color.argb(colorData.a, colorData.r, colorData.g, colorData.b).apply {
                    statusBarColor = this
                })
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {  }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {  }

        })

        green_sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                colorData = colorData.copy(g = (progress.toFloat() / 100f * 255f).toInt())
                color_pre_show_fl.setBackgroundColor(Color.argb(colorData.a, colorData.r, colorData.g, colorData.b).apply {
                    statusBarColor = this
                })
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {  }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {  }

        })

        blue_sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                colorData = colorData.copy(b = (progress.toFloat() / 100f * 255f).toInt())
                color_pre_show_fl.setBackgroundColor(Color.argb(colorData.a, colorData.r, colorData.g, colorData.b).apply {
                    statusBarColor = this
                })
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {  }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {  }

        })

        next_activity_bt.setOnClickListener {
            var windowFlag1: Int = 0
            var systemUiFlags1: Int = 0
            if (translucent_status_cb.isChecked) {
                windowFlag1 = windowFlag1 or WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            }
            if (translucent_navigation_cb.isChecked) {
                windowFlag1 = windowFlag1 or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
            }
            if (low_profile_cb.isChecked) {
                systemUiFlags1 = systemUiFlags1 or View.SYSTEM_UI_FLAG_LOW_PROFILE
            }
            if (hide_navigation_cb.isChecked) {
                systemUiFlags1 = systemUiFlags1 or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            }
            if (fullscreen_cb.isChecked) {
                systemUiFlags1 = systemUiFlags1 or View.SYSTEM_UI_FLAG_FULLSCREEN
            }
            if (layout_stable_cb.isChecked) {
                systemUiFlags1 = systemUiFlags1 or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            }
            if (layout_hide_navigation_cb.isChecked) {
                systemUiFlags1 = systemUiFlags1 or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            }
            if (immersive_cb.isChecked) {
                systemUiFlags1 = systemUiFlags1 or View.SYSTEM_UI_FLAG_IMMERSIVE
            }
            if (immersive_sticky_cb.isChecked) {
                systemUiFlags1 = systemUiFlags1 or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            }
            if (light_status_bar_cb.isChecked) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    systemUiFlags1 = systemUiFlags1 or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }
            }
            if (light_navigation_bar_cb.isChecked) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    systemUiFlags1 = systemUiFlags1 or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
                }
            }
            if (layout_fullscreen_cb.isChecked) {
                systemUiFlags1 = systemUiFlags1 or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            }
            isRootViewFitSystem = fit_system_window_cb.isChecked
            windowFlags = windowFlag1
            systemUiFlags = systemUiFlags1
            startActivity(Intent(this@MainActivity, ImageStatusShowActivity::class.java))
        }
    }

    data class ColorData(
        @IntRange(from = 0, to = 255) val a: Int = 0,
        @IntRange(from = 0, to = 255) val r: Int = 0,
        @IntRange(from = 0, to = 255) val g: Int = 0,
        @IntRange(from = 0, to = 255) val b: Int = 0)

}