package com.demo.componentmvp.component

import androidx.lifecycle.Lifecycle

abstract class BaseComponentPresenter<V : BaseComponentView> {
    protected lateinit var view: V

    fun attachView(view: V) {
        this.view = view
    }

    open fun detachView() {
    }
}