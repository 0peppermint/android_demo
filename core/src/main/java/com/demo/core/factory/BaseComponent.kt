package com.demo.core.factory

abstract class BaseComponent {

    suspend fun fetchData() {}

    open fun display() {}

}