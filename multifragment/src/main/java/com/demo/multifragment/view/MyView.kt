package com.demo.multifragment.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageView

class MyView: ImageView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.d("multiFragment", "${this.toString()} on window!!")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.d("multiFragment", "${this.toString()} off window!!")
    }

}