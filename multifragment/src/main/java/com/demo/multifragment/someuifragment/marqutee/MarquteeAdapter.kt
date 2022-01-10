package com.demo.multifragment.someuifragment.marqutee

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.demo.multifragment.R

class MarquteeAdapter(private val dataList: MutableList<String>
) : BaseQuickAdapter<String, BaseViewHolder>(R.layout.fragment_my_some_ui_marqutee_item, dataList) {
    override fun convert(holder: BaseViewHolder, item: String) {
        val textView = holder.getView<TextView>(R.id.tv_marqutee_item_title)
        textView.text = item
    }
}