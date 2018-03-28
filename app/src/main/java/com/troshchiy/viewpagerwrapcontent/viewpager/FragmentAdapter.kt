package com.troshchiy.viewpagerwrapcontent.viewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.troshchiy.viewpagerwrapcontent.R


class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount() = 2

    override fun getItem(position: Int): Fragment =
            PlaceholderFragment.newInstance(position + 1)
}

class PlaceholderFragment : Fragment() {

    companion object {
        private val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            val fragment = PlaceholderFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.viewpager_element, container, false)
        val textView = view.findViewById<View>(R.id.tv_text) as TextView
        textView.text = getString(R.string.section_format, arguments?.getInt(ARG_SECTION_NUMBER))
        return view
    }
}