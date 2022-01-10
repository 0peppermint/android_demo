package com.demo.multifragment.someuifragment.marqutee

import android.util.Log
import android.view.View
import androidx.viewpager2.widget.ViewPager2

class MarquteeTransformer: ViewPager2.PageTransformer {
    private val MIN_SCALE = 1f
    override fun transformPage(page: View, position: Float) {
        page.alpha = 1f
//        Log.d("zyc", "page:${page.hashCode()}'s position is $position")
    }

}