package com.troshchiy.viewpagerwrapcontent.viewpager.general

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.troshchiy.viewpagerwrapcontent.R
import com.troshchiy.viewpagerwrapcontent.Ride
import com.troshchiy.viewpagerwrapcontent.dpToPx
import com.troshchiy.viewpagerwrapcontent.getLogTag


@SuppressLint("Registered")
class MainActivity : AppCompatActivity() {
    private val tag = getLogTag<MainActivity>()

    private lateinit var viewPager: ViewPager
    private val adapter = ViewPagerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager()

        Handler().postDelayed({ setDataToAdapter() }, 2000)
        Handler().postDelayed({ setDataToAdapter2() }, 4000)
        Handler().postDelayed({ setDataToAdapter() }, 7000)
    }

    private fun setupViewPager() {
        viewPager = findViewById(R.id.viewPager)
        viewPager.pageMargin = 12.dpToPx
        viewPager.adapter = adapter
    }

    private fun setDataToAdapter() {
        Log.w(tag, "setDataToAdapter")
        val r1 = Ride("Screen slides are transitions between one entire screen to another and are common with UIs like setup wizards or slideshows. This lesson shows you how to do screen slides with a ViewPager provided by the support library.")
        val r2 = Ride("To begin, create a layout that contains a ViewPager:")
        adapter.data = listOf(r1, r2)
    }

    private fun setDataToAdapter2() {
        Log.w(tag, "setDataToAdapter2")
        val r1 = Ride("Tra ta ta ta")
        val r2 = Ride("Param pam pam pam")
        adapter.data = listOf(r1, r2)
    }
}