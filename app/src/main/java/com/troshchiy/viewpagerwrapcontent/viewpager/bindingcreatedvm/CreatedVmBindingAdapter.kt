package com.troshchiy.viewpagerwrapcontent.viewpager.bindingcreatedvm

import android.databinding.DataBindingUtil
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import com.troshchiy.viewpagerwrapcontent.R
import com.troshchiy.viewpagerwrapcontent.databinding.ViewpagerElementBdCreatedBinding
import com.troshchiy.viewpagerwrapcontent.inflater


class CreatedVmBindingAdapter : PagerAdapter() {

    var viewModels: List<RideViewModel> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getCount() = viewModels.size
    override fun isViewFromObject(view: View, obj: Any): Boolean = (view == obj)
    override fun getPageWidth(position: Int) = 0.95f

    // For test purpose. https://stackoverflow.com/questions/7263291/viewpager-pageradapter-not-updating-the-view
    override fun getItemPosition(obj: Any): Int = POSITION_NONE

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding: ViewpagerElementBdCreatedBinding =
                DataBindingUtil.inflate(container.context.inflater, R.layout.viewpager_element_bd_created, container, false)

        binding.viewModel = viewModels[position]

        val view = binding.root
        container.addView(view)
        return view
    }
}