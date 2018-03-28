package com.troshchiy.viewpagerwrapcontent.viewpager.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.troshchiy.viewpagerwrapcontent.R
import com.troshchiy.viewpagerwrapcontent.dpToPx


@SuppressLint("Registered")
class MainActivity : AppCompatActivity() {

    private var viewPager: ViewPager? = null
    private var sectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        setupViewPager()
    }

    private fun setupViewPager() {
        viewPager = findViewById(R.id.viewPager)
        viewPager?.pageMargin = 12.dpToPx
        viewPager?.adapter = sectionsPagerAdapter
    }
}