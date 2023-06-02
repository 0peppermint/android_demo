package com.demo.communicate.multithread

class MultiThreadWorker private constructor(){
    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { MultiThreadWorker() }

    }

    // 实现一个事件队列

    /**
     * 实现一个线程或者线程池，这里最好是代理模式
     * ThreadWorker不感知到底是单线程还是多线程
     */



    /**
     * 对事件队列进行循环，处理三种事件，并执行他们的runnable
     */
    private fun loop(){

    }

    /**
     * 负责将事件发送到Queue中，并按优先级执行
     * @param workType: 对应三种事件
     * @param runnable: 事件处理的细节
     * @param needBarrier: 是否需要插队
     */
    fun post(workType: Int, runnable: Runnable, needBarrier: Boolean){

    }

    fun post(workType: Int, runnable: Runnable) {
        post(workType, runnable, false)
    }
}