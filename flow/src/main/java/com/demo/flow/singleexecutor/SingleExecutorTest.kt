package com.demo.flow.singleexecutor

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import java.util.concurrent.atomic.AtomicInteger


class SingleExecutorTest {

    private val a = AtomicInteger(0)
    private val b = AtomicInteger(0)
    fun Channel<Any>.go(block: suspend CoroutineScope.() -> Unit) {
        CoroutineScope(Dispatchers.Main).launch {
            Log.d("test-coroutine", "before send " + a.getAndIncrement())
            send(0)
            Log.i("test-coroutine", "after send " + b.getAndIncrement())
            coroutineScope {
                block()
                receive()
            }
        }
    }

    val channel = Channel<Any>(2)

    fun test() {
        // 并发限制为1，串行执行任务

        repeat(10) { x ->
            CoroutineScope(SingletonExecutorCoroutine.dispatchers + SupervisorJob()).launch {
                Log.w("test-coroutine", "send " + a.getAndIncrement())
                Log.w("test-coroutine", "$x going job")
                delay(1000L)
                Log.w("test-coroutine", "$x done job")
            }
        }
    }
}