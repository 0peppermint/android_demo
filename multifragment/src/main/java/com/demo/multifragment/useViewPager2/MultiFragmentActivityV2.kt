package com.demo.multifragment.useViewPager2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.demo.multifragment.R
import com.demo.multifragment.useViewPager2.adapter.MyFragmentStateAdapter
import kotlinx.android.synthetic.main.activity_multi_fragment_use_viewpager2.*

class MultiFragmentActivityV2 : AppCompatActivity() {

    private var mViewPager : ViewPager2? = null

    private var mPagerAdapter : MyFragmentStateAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_fragment_use_viewpager2)
        mViewPager = vp_content

        // 禁用手势
        mViewPager!!.isUserInputEnabled = true
        mPagerAdapter = MyFragmentStateAdapter(R.id.vp_content, supportFragmentManager, this.lifecycle)
        mViewPager!!.offscreenPageLimit = 3
        mViewPager!!.adapter = mPagerAdapter
    }

    /**
     * 一般肯定不这么写，但demo实验嘛
     */
    fun updateTest() {
        mPagerAdapter?.updateFragments(mutableListOf("1","2","3"))
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}