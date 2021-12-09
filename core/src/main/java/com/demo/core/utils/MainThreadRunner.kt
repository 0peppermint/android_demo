package com.demo.core.utils

import android.os.Handler
import android.os.Looper

/**
 * 主线程Runner
 */
object MainThreadRunner {

    private val mainHandler = Handler(Looper.getMainLooper())

    /**
     * 保证[block]运行在主线程
     */
    fun runInMainThread(block: () -> Unit) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            block.invoke()
        } else {
            mainHandler.post {
                block.invoke()
            }
        }
    }
}