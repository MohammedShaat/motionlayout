package com.google.samples.motionlayoutcodelab

import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnScrollChangeListener
import android.widget.ImageView
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.graphics.toColor
import kotlin.math.abs

class Step9Activity : AppCompatActivity() {

    private lateinit var motionLayout: MotionLayout
    private lateinit var blueStar: ImageView
    private lateinit var scrollView: ScrollView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step9)

        motionLayout = findViewById(R.id.motion_layout)
        blueStar = findViewById(R.id.blue_star)
        scrollView = findViewById(R.id.scrollview)

        addListenerToScrollView()
    }

    private fun addListenerToScrollView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            scrollView.setOnScrollChangeListener(
                object : View.OnScrollChangeListener {
                    override fun onScrollChange(
                        v: View?,
                        scrollX: Int,
                        scrollY: Int,
                        oldScrollX: Int,
                        oldScrollY: Int
                    ) {
//                        Log.i(
//                            "OnScrollChangeListener",
//                            "$scrollX, $scrollY, $oldScrollX, $oldScrollY"
//                        )
//                        Log.i(
//                            "addListenerToScrollView",
//                            "${scrollView.getChildAt(0).height - scrollView.height}"
//                        )
                        val maxScrollY = abs(scrollView.height - scrollView.getChildAt(0).height)
                        val seek = scrollY / maxScrollY.toFloat()
                        motionLayout.progress = seek
                    }

                }
            )
        }
    }


}