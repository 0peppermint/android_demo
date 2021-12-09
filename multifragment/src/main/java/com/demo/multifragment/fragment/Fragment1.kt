package com.demo.multifragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.demo.multifragment.R
import kotlinx.android.synthetic.main.fragment_mix_fragment.*

class Fragment1: Fragment(){

    private var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_mix_fragment, container, false)
        return rootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            activity?.supportFragmentManager?.beginTransaction()?.let {
//                it.add(this, "Fragment1")
//                it.commit()
//            }
//        }
    }

    override fun onResume() {
        super.onResume()
    }

    fun dismiss(fragment: Fragment) {
        when(fragment) {
            is FragmentChild1 -> {
                val transaction = childFragmentManager.beginTransaction()
                showFragment(R.id.fg_2, transaction)
                hideFragment(R.id.fg_1, transaction)
                transaction.commit()
            }
            is FragmentChild2 -> {
                val transaction = childFragmentManager.beginTransaction()
                showFragment(R.id.fg_1, transaction)
                hideFragment(R.id.fg_2, transaction)
                transaction.commit()
            }
        }
    }

    private fun showFragment(id: Int, fragmentTransaction: FragmentTransaction?) {
        childFragmentManager.findFragmentById(id)?.let{
            fragmentTransaction?.show(it)
        }
    }

    private fun hideFragment(id: Int, fragmentTransaction: FragmentTransaction?) {
        childFragmentManager.findFragmentById(id)?.let{
            fragmentTransaction?.hide(it)
        }
    }
}