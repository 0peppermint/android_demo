package com.demo.multifragment

import android.content.Context
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.demo.multifragment.fragment.Fragment1
import com.demo.multifragment.fragment.Fragment2
import com.demo.multifragment.someuifragment.SomeUiFragment

class ContentPagerAdapter(
    private val context: Context,
    private val fm: FragmentManager)
    : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    private val fragmentMap = HashMap<String, Fragment>()


    override fun getCount(): Int {
        return 1
    }

    override fun getItem(position: Int): Fragment {
        return SomeUiFragment()
    }

//    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {
//        try {
//            super.restoreState(state, loader)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }
//
//    override fun saveState(): Parcelable? {
//        return null
//    }
}