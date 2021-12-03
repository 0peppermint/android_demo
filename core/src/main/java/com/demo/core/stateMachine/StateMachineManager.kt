package com.demo.core.stateMachine

import com.demo.core.stateMachine.node.api.IBaseNode
import com.demo.core.stateMachine.service.api.IProceedService
import com.demo.core.stateMachine.service.impl.ProceedServiceImpl
import com.demo.core.stateMachine.state.Event

class StateMachineManager private constructor(
    private val proceedService: IProceedService
) : IProceedService by proceedService {

    companion object {
        @Volatile
        private var instance: StateMachineManager? = null
        fun getInstance(): StateMachineManager {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        val proceedService = ProceedServiceImpl()
                        instance = StateMachineManager(proceedService)
                        instance!!.proceedService.subscribe()
                    }
                    return instance!!
                }
            } else {
                return instance!!
            }

        }
    }

    private val nodeList : MutableList<IBaseNode> = mutableListOf()

    fun release() {
        proceedService.unSubscribe()
    }

    fun registerNode(serviceNode: IBaseNode) {
        nodeList.add(serviceNode)
    }

    fun getRespondService(event: Event) : IBaseNode? {
        return nodeList.firstOrNull {
            it.shouldRespond(event)
        }
    }

}