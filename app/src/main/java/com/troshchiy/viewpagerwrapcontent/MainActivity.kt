package com.troshchiy.viewpagerwrapcontent

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


val Int.dpToPx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

class MainActivity : AppCompatActivity() {

    private var sectionsPagerAdapter: SectionsPagerAdapter? = null

    private var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create the adapter that will return a fragment for each of the three primary sections of the activity.
        sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        viewPager = findViewById(R.id.container)

        viewPager?.pageMargin = 10.dpToPx

//        viewPager?.adapter = sectionsPagerAdapter
        viewPager?.adapter = ViewPagerAdapter()

    }
}

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount() = 2

    override fun getItem(position: Int): Fragment {
        return PlaceholderFragment.newInstance(position + 1)
    }

//        override fun getPageWidth(position: Int) = 1f
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
        val textView = view.findViewById<View>(R.id.section_label) as TextView
        textView.text = getString(R.string.section_format, arguments?.getInt(ARG_SECTION_NUMBER))
        return view
    }
}

class ViewPagerAdapter : PagerAdapter() {
    override fun getCount() = 2
    override fun isViewFromObject(view: View, `object`: Any): Boolean = (view == `object`)

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view = if (position == 0)
            container.inflate(R.layout.viewpager_element)
        else
            container.inflate(R.layout.viewpager_element_2)

        container.addView(view)
        return view
    }
}

class DetailViewPager @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : ViewPager(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        if (childCount > 0) {
            var maxHeight = 0

            for (i in 0 until childCount) {
                val child = getChildAt(i)
                child.measuredWidth
                measureChild(child, widthMeasureSpec, heightMeasureSpec)

                val height = child.measuredHeight
                if (height > maxHeight) maxHeight = height
            }

            setMeasuredDimension(widthMeasureSpec, maxHeight)
        }
    }
}