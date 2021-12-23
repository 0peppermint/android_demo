package com.demo.multifragment.someuifragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.demo.multifragment.R
import com.demo.multifragment.someuifragment.springanimation.MySpringAdapter
import com.demo.multifragment.someuifragment.springanimation.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.fragment_my_some_ui.*

class SomeUiFragment: Fragment() {

    private var rootView: View? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_my_some_ui, container, false)
        return rootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            Log.d("zyc", "SomeUiFragment onCreate with recovery")
        } else {
            Log.d("zyc", "SomeUiFragment onCreate with no recovery")
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("zyc", "SomeUiFragment onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("zyc", "SomeUiFragment onPause")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("zyc", "SomeUiFragment onDetach")
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