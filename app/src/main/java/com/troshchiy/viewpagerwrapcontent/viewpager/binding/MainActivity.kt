package com.troshchiy.viewpagerwrapcontent.viewpager.binding

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.troshchiy.viewpagerwrapcontent.Foo
import com.troshchiy.viewpagerwrapcontent.R
import com.troshchiy.viewpagerwrapcontent.dpToPx


@SuppressLint("Registered")
class MainActivity : AppCompatActivity() {

    private var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.container)

        viewPager?.pageMargin = 12.dpToPx

        val adapter = BindingViewPagerAdapter()
        viewPager?.adapter = adapter


        val f1 = Foo("Screen slides are transitions between one entire screen to another and are common with UIs like setup wizards or slideshows. This lesson shows you how to do screen slides with a ViewPager provided by the support library.")
        val f2 = Foo("To begin, create a layout that contains a ViewPager:")
        adapter.data = listOf(f1, f2)
    }
}