package com.demo.multifragment.someuifragment.marqutee

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.children
import androidx.viewpager.widget.PagerAdapter

class MarquteePageAdapter(private val dataList: MutableList<String>): PagerAdapter() {


    override fun getCount(): Int {
        return dataList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val textView = TextView(container.context)
        val density = container.context.resources.displayMetrics.density
        textView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        textView.gravity = Gravity.CENTER
        textView.text = dataList[position]
        textView.textSize = density * 20f
        container.addView(textView)
        return textView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.children.forEach {
            if (it is TextView) {
                container.removeView(it)
            }
        }
    }
}