package com.troshchiy.viewpagerwrapcontent

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


val Int.dpToPx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)