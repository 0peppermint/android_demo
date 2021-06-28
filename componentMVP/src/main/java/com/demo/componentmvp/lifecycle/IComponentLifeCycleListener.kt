package com.demo.componentmvp.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.demo.componentmvp.ComponentMVPConstants

interface IComponentLifeCycleListener :LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.d(ComponentMVPConstants.TAG, event.name)
    }
}