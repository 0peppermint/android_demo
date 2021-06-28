package com.demo.componentmvp.component

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.demo.componentmvp.lifecycle.IComponentLifeCycleListener

interface BaseComponent<V : BaseComponentView, P: BaseComponentPresenter<V>>: IComponentLifeCycleListener, BaseComponentView{

//    constructor(context: Context) : this(context, null)
//    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
//    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
//        init(context, attrs)
//    }

    val presenter: P

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        super.onStateChanged(source, event)
    }
}