package com.demo.communicate.multithread

import android.util.Log
import java.util.concurrent.PriorityBlockingQueue
import java.util.concurrent.SynchronousQueue

/**
 * 不包含线程概念的ThreadWorker
 */
class SimpleThreadWorker private constructor(): IThreadWorker{

    companion object {
        private val instance: SimpleThreadWorker by lazy(LazyThreadSafetyMode.SYNCHRONIZED){ SimpleThreadWorker() }
    }

    private val executorQueue: PriorityBlockingQueue<ThreadItem> = PriorityBlockingQueue(10) { item1, item2 ->
        item2.workType.compareTo(item1.workType)
    }

    private var thread = Thread(Runnable {
        while (true){
            if (executorQueue.isNotEmpty()) {
                Log.i(MultiThreadTest.TAG, "queue has nothing to do!!!")
            }
            while (executorQueue.isNotEmpty()) {
                val threadItem = executorQueue.poll()
                Log.i(MultiThreadTest.TAG, "queue executing work of ${threadItem.workType}")
                threadItem.action.run()
            }
        }
    })

    override fun post(workType: Int, runnable: Runnable) {
        TODO("Not yet implemented")
    }

    override fun post(workType: Int, runnable: Runnable, needBarrier: Boolean) {
        TODO("Not yet implemented")
    }

    override fun work() {
        thread.start()
    }

    override fun release() {
        thread.interrupt()
    }
}