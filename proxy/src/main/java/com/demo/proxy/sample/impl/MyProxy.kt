package com.demo.proxy.sample.impl

import android.util.Log
import com.demo.proxy.sample.api.IMyProxy

class MyProxy: IMyProxy {

    override fun run() {
        Log.d("zyc", this::class.java.name)
    }
}