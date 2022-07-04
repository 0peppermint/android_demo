package com.demo.flow.core.api

import android.util.Log
import com.demo.flow.core.bean.ChainState
import kotlinx.coroutines.flow.MutableStateFlow

abstract class IBaseFlowProcessor {

    protected val _TAG = "flow-"

    private var chainStateFlow: MutableStateFlow<ChainState>? = null

    abstract fun currentState(): ChainState
    abstract fun nextState(): ChainState
    abstract suspend fun invoke()

    fun registerStateFlow(chainStateFlow: MutableStateFlow<ChainState>) {
        this.chainStateFlow = chainStateFlow
    }

    protected fun getTAG(): String {
        return _TAG + " " + currentState().name
    }

    protected suspend fun proceedNext() {
        Log.i(getTAG(), "${currentState().name} finished in ${Thread.currentThread().name}, goto ${nextState().name}")
        chainStateFlow?.emit(nextState())
    }
}