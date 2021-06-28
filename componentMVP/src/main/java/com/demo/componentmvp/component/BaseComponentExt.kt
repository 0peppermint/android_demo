package com.demo.componentmvp.component

import androidx.appcompat.app.AppCompatActivity
import com.demo.componentmvp.lifecycle.IComponentLifeCycleListener


fun AppCompatActivity.bindLifeCycle(componentLifeCycleListener: IComponentLifeCycleListener) {
    this.lifecycle.addObserver(componentLifeCycleListener)
}