package com.troshchiy.viewpagerwrapcontent.viewpager

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.View


class WrapContentViewPager @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : ViewPager(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var maxHeight = 0

        for (i in 0 until childCount) {
            val child = getChildAt(i)
            child.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))

            with(child.measuredHeight) {
                if (this > maxHeight) maxHeight = this
            }
        }

        val resultHeightMeasureSpec =
                if (maxHeight != 0) View.MeasureSpec.makeMeasureSpec(maxHeight, View.MeasureSpec.EXACTLY) else 0

        super.onMeasure(widthMeasureSpec, resultHeightMeasureSpec)
    }
}