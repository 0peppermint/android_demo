package com.demo.multifragment.fragment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.demo.multifragment.R
import com.demo.multifragment.useViewPager2.MultiFragmentActivityV2
import com.demo.multifragment.viewmodel.Child1ViewModel
import com.demo.multifragment.viewmodel.Child2ViewModel
import kotlinx.android.synthetic.main.fragment_child_multi_fragment.*
import kotlinx.android.synthetic.main.fragment_multi_fragment.myview
import kotlinx.android.synthetic.main.fragment_multi_fragment.tv_test

class FragmentChild1: Fragment(){

    private var rootView: View? = null

    private val viewModel1 by viewModels<Child1ViewModel>()

    private var viewModel2 : Child2ViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_child_multi_fragment, container, false)
        return rootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            Log.d("zyc", "fragmentChild1 onCreate with recovery")
        } else {
            Log.d("zyc", "fragmentChild1 onCreate with no recovery")
        }
        viewModel2 = ViewModelProvider(requireActivity()).get(Child2ViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        Log.d("zyc", "fragmentChild1 onResume")
        tv_test.text = "我是fragmentChild1"
        myview.setBackgroundColor(Color.GREEN)
        btn_switch_button.setOnClickListener {
            (parentFragment as? Fragment1)?.dismiss(this)
            (activity as? MultiFragmentActivityV2)?.updateTest()
            (activity as? MultiFragmentActivityV2)?.goToTab(1)
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("zyc", "fragmentChild1 onPause")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("zyc", "fragmentChild1 onDetach")
    }

    override fun onStop() {
        super.onStop()
        Log.d("zyc", "fragmentChild1 onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("zyc", "fragmentChild1 onDestory")
    }
}