package com.demo.flow.core

import android.util.Log
import com.demo.flow.core.api.IBaseFlowProcessor
import com.demo.flow.core.bean.ChainState
import com.demo.flow.core.processor.StartProcessor
import com.demo.flow.core.processor.StepOneProcessor
import com.demo.flow.core.processor.StepTwoProcessor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentHashMap

class FlowChainClient {
    companion object {
        private const val TAG = "flowChainClient"
    }

    private val implMap: ConcurrentHashMap<ChainState, IBaseFlowProcessor> = ConcurrentHashMap()

    private val privateCurrentStateFlow : MutableStateFlow<ChainState> = MutableStateFlow(ChainState.START)

    init {
        register(StartProcessor())
        register(StepOneProcessor())
        register(StepTwoProcessor())
    }

    private fun register(impl: IBaseFlowProcessor){
        implMap[impl.currentState()] = impl
        implMap[impl.currentState()]?.registerStateFlow(privateCurrentStateFlow)
    }

    fun start() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                implMap[ChainState.START]?.invoke()
                privateCurrentStateFlow.collect {
                    Log.i(TAG, "currentState is ${it.name}")
                    if (it == ChainState.END){
                        Log.i(TAG, "finish")
                    }
                    implMap[it]?.invoke()
                }
            }catch (e: Exception) {
                resolvingError(e)
            }
        }
    }

    private suspend fun resolvingError(e: Exception) {

        Log.e(TAG, "error ${e.message}")
    }
}