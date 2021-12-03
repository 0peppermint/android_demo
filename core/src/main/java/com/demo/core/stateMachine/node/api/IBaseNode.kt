package com.demo.core.stateMachine.node.api

import com.demo.core.stateMachine.state.Event
import com.demo.core.stateMachine.state.State
import io.reactivex.Observable
import io.reactivex.Observer

interface IBaseNode {

    /**
     * 是否异步
     */
    fun isAsync(): Boolean

    /**
     * 是否响应当此事件
     */
    fun shouldRespond(event: Event): Boolean

    /**
     * 是否处理当此事件
     */
    fun shouldDealRespond(event: Event, chain: State) : State?

    /**
     * 同步执行事件
     */
    fun proceedSync(): Event

    /**
     * 异步执行事件
     */
    fun proceedAsync(): Observable<Event>
}