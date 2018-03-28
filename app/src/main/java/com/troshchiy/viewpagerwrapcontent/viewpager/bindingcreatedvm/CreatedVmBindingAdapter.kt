package com.troshchiy.viewpagerwrapcontent.viewpager.bindingcreatedvm

import android.databinding.DataBindingUtil
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import com.troshchiy.viewpagerwrapcontent.Foo
import com.troshchiy.viewpagerwrapcontent.R
import com.troshchiy.viewpagerwrapcontent.databinding.ViewpagerElementBdBinding
import com.troshchiy.viewpagerwrapcontent.inflater


class CreatedVmBindingAdapter : PagerAdapter() {

    var data: List<Foo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getCount() = data.size
    override fun isViewFromObject(view: View, obj: Any): Boolean = (view == obj)
    override fun getPageWidth(position: Int) = 0.95f

    // For test purpose. https://stackoverflow.com/questions/7263291/viewpager-pageradapter-not-updating-the-view
    override fun getItemPosition(obj: Any): Int = POSITION_NONE

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding: ViewpagerElementBdBinding =
                DataBindingUtil.inflate(container.context.inflater, R.layout.viewpager_element_bd, container, false)

        binding.foo = data[position]

        val view = binding.root
        container.addView(view)
        return view
    }
}