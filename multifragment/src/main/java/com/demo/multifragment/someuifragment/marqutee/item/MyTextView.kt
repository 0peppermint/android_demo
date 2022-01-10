package com.demo.multifragment.someuifragment.marqutee.item

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView

class MyTextView: AppCompatTextView {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
//        Log.d("zyc", "${hashCode()} text is ${text}, onAttached")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
//        Log.d("zyc", "${hashCode()} text is ${text},  onDetached")
    }
}