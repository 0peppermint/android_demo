package com.demo.multifragment.someuifragment.springanimation

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.demo.multifragment.R

@SuppressLint("ClickableViewAccessibility")
class MySpringAdapter(private val dataList: MutableList<String>)
    : BaseQuickAdapter<String, BaseViewHolder>(R.layout.fragment_my_some_ui_spring, dataList) {
    override fun convert(holder: BaseViewHolder, item: String) {
        val iconView = holder.getView<ImageView>(R.id.iv_icon)
        val textView = holder.getView<TextView>(R.id.tv_icon_title)
        textView.text = item
    }
}