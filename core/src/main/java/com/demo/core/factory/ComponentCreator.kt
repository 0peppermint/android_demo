package com.demo.core.factory

abstract class ComponentCreator {
    fun create() : List<BaseComponent> {
        return emptyList()
    }
}