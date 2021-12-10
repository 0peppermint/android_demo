package com.demo.multifragment.fragment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.demo.multifragment.R
import com.demo.multifragment.useViewPager2.MultiFragmentActivityV2
import kotlinx.android.synthetic.main.fragment_child_multi_fragment.*
import kotlinx.android.synthetic.main.fragment_multi_fragment.myview
import kotlinx.android.synthetic.main.fragment_multi_fragment.tv_test
import java.lang.ref.WeakReference

class FragmentChild2: Fragment() {

    private var rootView: View? = null

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
        Log.d("zyc", "fragmentChild2 onCreate")
    }

    override fun onResume() {
        super.onResume()
        Log.d("zyc", "fragmentChild2 onResume")
        tv_test.text = "我是fragmentChild2"
        myview.setBackgroundColor(Color.BLUE)
        btn_switch_button.setOnClickListener {
            (parentFragment as? Fragment1)?.dismiss(this)
            (activity as? MultiFragmentActivityV2)?.updateTest()
            (activity as? MultiFragmentActivityV2)?.goToTab(0)
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("zyc", "fragmentChild2 onPause")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("zyc", "fragmentChild2 onDetach")
    }

    override fun onStop() {
        super.onStop()
        Log.d("zyc", "fragmentChild2 onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("zyc", "fragmentChild2 onDestory")
    }
}