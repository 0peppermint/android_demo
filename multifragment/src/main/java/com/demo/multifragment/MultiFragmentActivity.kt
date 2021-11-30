package com.demo.multifragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_multi_fragment.*

class MultiFragmentActivity : AppCompatActivity() {

    private var mViewPager : ViewPager? = null

    private var mPagerAdapter : ContentPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_fragment)
        mViewPager = vp_content
        mPagerAdapter = ContentPagerAdapter(this, supportFragmentManager)
        mViewPager!!.offscreenPageLimit = 3
        mViewPager!!.adapter = mPagerAdapter
    }

}