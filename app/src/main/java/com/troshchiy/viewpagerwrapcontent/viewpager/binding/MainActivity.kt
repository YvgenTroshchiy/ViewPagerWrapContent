package com.troshchiy.viewpagerwrapcontent.viewpager.binding

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.troshchiy.viewpagerwrapcontent.Foo
import com.troshchiy.viewpagerwrapcontent.R
import com.troshchiy.viewpagerwrapcontent.dpToPx


@SuppressLint("Registered")
class MainActivity : AppCompatActivity() {

    private var viewPager: ViewPager? = null
    private val adapter = BindingViewPagerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager()

        Handler().postDelayed({ setDataToAdapter() }, 2000)
    }

    private fun setupViewPager() {
        viewPager = findViewById(R.id.viewPager)
        viewPager?.pageMargin = 12.dpToPx
        viewPager?.adapter = adapter
    }

    private fun setDataToAdapter() {
        val f1 = Foo("Screen slides are transitions between one entire screen to another and are common with UIs like setup wizards or slideshows. This lesson shows you how to do screen slides with a ViewPager provided by the support library.")
        val f2 = Foo("To begin, create a layout that contains a ViewPager:")
        adapter.data = listOf(f1, f2)
    }
}