package com.demo.flow.core.processor

import com.demo.flow.core.api.IBaseFlowProcessor
import com.demo.flow.core.bean.ChainState

class StartProcessor: IBaseFlowProcessor() {
    override fun currentState(): ChainState = ChainState.START

    override fun nextState(): ChainState = ChainState.STEP_1

    override suspend fun invoke() {
        proceedNext()
    }
}