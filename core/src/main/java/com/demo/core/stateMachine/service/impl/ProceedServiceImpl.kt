package com.demo.core.stateMachine.service.impl

import com.demo.core.stateMachine.StateMachineManager
import com.demo.core.stateMachine.node.api.IBaseNode
import com.demo.core.stateMachine.service.api.IProceedService
import com.demo.core.stateMachine.state.Event
import com.demo.core.stateMachine.state.State
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

internal class ProceedServiceImpl: IProceedService {

    private val subject : BehaviorSubject<Event> = BehaviorSubject.create()
    private var chain : State = State.END

    private val observer = object : Observer<Event> {
        override fun onNext(event: Event) {
            StateMachineManager.getInstance().getRespondService(event)?.let {
                dealWithEvent(event, it)
            }
        }

        override fun onSubscribe(d: Disposable) {

        }

        override fun onComplete() {

        }

        override fun onError(e: Throwable) {

        }
    }

    private fun dealWithEvent(event: Event, nodeService: IBaseNode) {
        val currentState = nodeService.shouldDealRespond(event, chain)
        if (currentState != null) {
            if (nodeService.isAsync()) {
                proceed(nodeService.proceedSync())
            } else {
                nodeService.proceedAsync()
                    .subscribe(object : Observer<Event>{
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(event: Event) {
                        proceed(event)
                    }

                    override fun onError(e: Throwable) {
                    }

                    override fun onComplete() {
                    }

                })
            }
        } else {
            chain = State.END
        }
    }

    override fun subscribe() {
        subject
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    override fun unSubscribe() {
        subject.onComplete()
    }

    override fun proceed(event: Event) {
        subject.onNext(event)
    }
}