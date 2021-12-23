package com.demo.multifragment.someuifragment.springanimation

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.demo.multifragment.R
import kotlinx.android.synthetic.main.fragment_my_some_ui.*

class MySpringRecyclerView: RecyclerView {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        val currentAdapter = MySpringAdapter(mutableListOf("123", "456"))
        layoutManager = object : LinearLayoutManager(context, HORIZONTAL, false) {
            override fun canScrollHorizontally(): Boolean {
                return false
            }

            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        addOnItemTouchListener(object : OnRecyclerItemClickListener(this){
            override fun onDown(vh: RecyclerView.ViewHolder?) {
                (vh as? BaseViewHolder)?.let {
                    Log.d("zyc", "${it.adapterPosition} onDown")
                }
            }

            override fun onMove() {
            }

            override fun onUp(vh: RecyclerView.ViewHolder?) {
                (vh as? BaseViewHolder)?.let {
                    Log.d("zyc", "${it.adapterPosition} onUp")
                }
            }


            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

            }
        })
        adapter = currentAdapter
    }


}