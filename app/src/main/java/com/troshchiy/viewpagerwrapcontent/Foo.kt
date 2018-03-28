package com.troshchiy.viewpagerwrapcontent

import android.support.annotation.ColorInt
import android.support.annotation.DimenRes

class Foo(
        val text: String,
        @DimenRes val imageHeight: Int? = null,
        @ColorInt val imageColor: Int? = null)