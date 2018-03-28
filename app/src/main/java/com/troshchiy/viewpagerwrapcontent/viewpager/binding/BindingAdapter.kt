package com.troshchiy.viewpagerwrapcontent.viewpager.binding

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.troshchiy.viewpagerwrapcontent.Foo
import com.troshchiy.viewpagerwrapcontent.R
import com.troshchiy.viewpagerwrapcontent.dpToPx
import com.troshchiy.viewpagerwrapcontent.inflate


class BindingViewPagerAdapter : PagerAdapter() {

    var data: List<Foo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getCount() = data.size
    override fun isViewFromObject(view: View, obj: Any): Boolean = (view == obj)
    override fun getPageWidth(position: Int) = 0.95f

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = container.inflate(R.layout.viewpager_element)
        val textView = view.findViewById<TextView>(R.id.tv_text)
        val imageView = view.findViewById<ImageView>(R.id.img_image)

        textView.text = data[position].text
        if (position == 1) imageView.layoutParams.height = 40.dpToPx

        container.addView(view)
        return view
    }
}