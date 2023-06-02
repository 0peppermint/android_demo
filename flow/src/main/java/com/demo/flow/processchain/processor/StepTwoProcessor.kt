package com.demo.flow.processchain.processor

import android.util.Log
import com.demo.flow.processchain.api.IBaseFlowProcessor
import com.demo.flow.processchain.bean.ChainState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach

class StepTwoProcessor: IBaseFlowProcessor() {
    override fun currentState(): ChainState = ChainState.STEP_2

    override fun nextState(): ChainState = ChainState.STEP_3

    private var num = 0
    private var str = ""
    private var test = true

    override suspend fun invoke() {
        if (test){
            test = false
            throw Exception("test gg")
        }
        flowOf(0,1,2,3,4,5).onEach {
            delay(1000)
        }.collect {
            Log.i(getTAG(), "step two 1 in $it")
            num = it
            judge()
        }

        flowOf("a", "b", "c", "d").onEach {
            delay(1000)
        }.collect {
            str = it
            Log.i(getTAG(), "step two 2 in $it")
            judge()
        }
    }

    private suspend fun judge() {
        if (num == 5 && str == "d") {
            proceedNext()
        }
    }
}