package com.troshchiy.viewpagerwrapcontent.viewpager

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet


class WrapContentViewPager @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : ViewPager(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        if (childCount > 0) {
            var maxHeight = 0

            for (i in 0 until childCount) {
                val child = getChildAt(i)
                child.measuredWidth
                measureChild(child, widthMeasureSpec, heightMeasureSpec)

                //TODO: For debug
                val g = 0
                val f = 0

                val height = child.measuredHeight
                if (height > maxHeight) maxHeight = height
            }

            setMeasuredDimension(widthMeasureSpec, maxHeight)
        }
    }
}