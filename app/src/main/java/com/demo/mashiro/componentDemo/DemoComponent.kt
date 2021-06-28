package com.demo.mashiro.componentDemo

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.demo.componentmvp.component.BaseComponent

class DemoComponent : BaseComponent<DemoComponentView, DemoComponentPresenter>, DemoComponentView, View {

    constructor(context: Context) : super(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        presenter.attachView(this)
    }

    override val presenter = DemoComponentPresenter()

    override fun test1() {
        Log.d("DemoComponentTest", "haha")
    }

}