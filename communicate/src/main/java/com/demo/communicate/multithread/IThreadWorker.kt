package com.demo.communicate.multithread

interface IThreadWorker {
    fun post(workType: Int, runnable: Runnable)

    fun post(workType: Int, runnable: Runnable, needBarrier: Boolean)

    fun work()

    fun release()
}