package com.demo.flow.core.processor

import com.demo.flow.core.api.IBaseFlowProcessor
import com.demo.flow.core.bean.ChainState

class StepOneProcessor: IBaseFlowProcessor() {
    override fun currentState(): ChainState = ChainState.STEP_1

    override fun nextState(): ChainState = ChainState.STEP_2

    override suspend fun invoke() {
        proceedNext()
    }
}