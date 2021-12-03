package com.demo.core.stateMachine.service.api

import com.demo.core.stateMachine.state.Event

interface IProceedService {

    fun subscribe()

    fun unSubscribe()

    fun proceed(event: Event)
}