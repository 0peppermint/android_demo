package com.demo.componentmvp.component

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.demo.componentmvp.lifecycle.IComponentLifeCycleListener


fun Activity.bindLifeCycle(componentLifeCycleListener: IComponentLifeCycleListener) {
    val lifecycle = (this as? LifecycleOwner)?.lifecycle
    lifecycle?:throw IllegalArgumentException("activity must be LifecycleOwner.")
    lifecycle.addObserver(componentLifeCycleListener)
}