package com.troshchiy.viewpagerwrapcontent

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.GestureDetector
import android.view.GestureDetector.OnGestureListener
import android.view.MotionEvent
import android.widget.ViewSwitcher


class ViewSwitcherActivity : AppCompatActivity() {
    private val tag = ViewSwitcherActivity::class.java.simpleName

    private lateinit var switcher: ViewSwitcher
    private lateinit var myDetector: GestureDetector

    private val onGestureListener = object : OnGestureListener {

        override fun onShowPress(e: MotionEvent?) {
        }

        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            return false
        }

        override fun onDown(e: MotionEvent?): Boolean {
            return false
        }

        override fun onFling(e1: MotionEvent?,
                             e2: MotionEvent?,
                             velocityX: Float,
                             velocityY: Float): Boolean {

            if (e1!!.rawY > e2!!.rawY) {
                switcher.showNext()
                Log.w(tag, "Show Next")
            } else {
                switcher.showPrevious()
                Log.w(tag, "Show Previous")
            }
            return false
        }

        override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
            return false
        }

        override fun onLongPress(e: MotionEvent?) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_switcher)

        switcher = findViewById(R.id.viewSwitcher)
        switcher.setInAnimation(this, android.R.anim.fade_in)
        switcher.setOutAnimation(this, android.R.anim.fade_out)
        myDetector = GestureDetector(this, onGestureListener)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        myDetector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }
}
