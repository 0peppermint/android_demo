package com.demo.multifragment.useViewPager2.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.demo.core.utils.MainThreadRunner
import com.demo.multifragment.fragment.FragmentChild1
import com.demo.multifragment.fragment.FragmentChild2
import com.demo.multifragment.fragment.FragmentChild3
import com.demo.multifragment.someuifragment.SomeUiFragment
import java.lang.IllegalArgumentException
import java.util.Comparator

class MyFragmentStateAdapter(
    private val viewId : Int,
    private val fm : FragmentManager,
    private val lifecycle: Lifecycle,
): FragmentStateAdapter(fm, lifecycle) {

    private val legalTags = mutableListOf<String>("1", "2", "3")
    private val fragmentTags: MutableList<String> = mutableListOf("1", "2")
    private val compareTo = object : Comparator<String> {
        override fun compare(item1: String, item2: String): Int {
            var index1 = legalTags.indexOf(item1)
            if (index1 < 0) {
                index1 = legalTags.size
            }

            var index2 = legalTags.indexOf(item2)
            if (index2 < 0) {
                index2 = legalTags.size
            }

            (index1 - index2).let {
                return when {
                    it < 0 -> -1
                    it == 0 -> 0
                    it > 0 -> 1
                    else -> 0
                }
            }
        }
    }

    fun updateFragments(currentFragmentTags: MutableList<String>) {
        MainThreadRunner.runInMainThread {
            fragmentTags.clear()
            currentFragmentTags.forEach {
                fragmentTags.add(it)
            }
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return fragmentTags.size
    }

    override fun createFragment(position: Int): Fragment {
        // 根据fragmentTags做映射
        if (position >= fragmentTags.size) {
            throw ArrayIndexOutOfBoundsException("position is out of Bound!")
        }

        if (!legalTags.contains(fragmentTags[position])) {
            throw IllegalArgumentException("currentTags isn't legal")
        }
        return tryToRestoreFragment(fragmentTags[position])
    }

    override fun getItemId(position: Int): Long {
        return fragmentTags[position].toLong()
    }

    override fun containsItem(itemId: Long): Boolean {
        return fragmentTags.contains(itemId.toString())
    }

    private fun tryToRestoreFragment(fragmentTag: String): Fragment {
        return when(fragmentTag) {
            "1" -> SomeUiFragment()
            "2" -> FragmentChild2()
            "3" -> FragmentChild3()
            // 这里应该给一个没有默认实现的东西，但throw了就没必要
            else -> FragmentChild1()
        }
    }


}