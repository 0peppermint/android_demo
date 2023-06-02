package com.demo.flow.singleexecutor

import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executors

object SingletonExecutorCoroutine {
    val dispatchers = Executors.newSingleThreadExecutor {
        Thread(it).apply {
            name = "my-single-executor"
        }
    }.asCoroutineDispatcher()
}