package com.demo.flow.processchain.processor

import com.demo.flow.processchain.api.IBaseFlowProcessor
import com.demo.flow.processchain.bean.ChainState

class StepOneProcessor: IBaseFlowProcessor() {
    override fun currentState(): ChainState = ChainState.STEP_1

    override fun nextState(): ChainState = ChainState.STEP_2

    override suspend fun invoke() {
        proceedNext()
    }
}