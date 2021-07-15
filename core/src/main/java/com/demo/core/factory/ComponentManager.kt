package com.demo.core.factory

object ComponentManager {

    val map = mutableMapOf<String, ComponentCreator>()

    fun registerComponent(key: String, componentCreator: ComponentCreator) {
        map[key] = componentCreator
    }

    fun getComponent(key: String) : ComponentCreator? {
        return map[key]
    }
}