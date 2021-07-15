package com.demo.core.factory

abstract class ComponentEvent{

    open fun onCreate() {}

    open fun onLoading() {}

    open fun onPause() {}

    open fun onDispose() {}

}