package com.demo.flow.processchain.processor

import com.demo.flow.processchain.api.IBaseFlowProcessor
import com.demo.flow.processchain.bean.ChainState

class StartProcessor: IBaseFlowProcessor() {
    override fun currentState(): ChainState = ChainState.START

    override fun nextState(): ChainState = ChainState.STEP_1

    override suspend fun invoke() {
        proceedNext()
    }
}