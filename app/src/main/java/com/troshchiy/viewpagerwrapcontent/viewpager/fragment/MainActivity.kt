package com.troshchiy.viewpagerwrapcontent.viewpager.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.troshchiy.viewpagerwrapcontent.R
import com.troshchiy.viewpagerwrapcontent.dpToPx


@SuppressLint("Registered")
class MainActivity : AppCompatActivity() {

    private var sectionsPagerAdapter: SectionsPagerAdapter? = null

    private var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        viewPager = findViewById(R.id.container)

        viewPager?.pageMargin = 12.dpToPx

        viewPager?.adapter = sectionsPagerAdapter
    }
}