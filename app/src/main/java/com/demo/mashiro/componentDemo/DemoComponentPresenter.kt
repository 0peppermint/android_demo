package com.demo.mashiro.componentDemo

import com.demo.componentmvp.component.BaseComponentPresenter

class DemoComponentPresenter : BaseComponentPresenter<DemoComponentView>() {
    fun loadTest1() {
        view.test1()
    }
}