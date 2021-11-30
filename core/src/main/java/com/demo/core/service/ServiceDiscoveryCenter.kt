package com.demo.core.service

import com.demo.core.service.api.IBaseService
import java.util.concurrent.ConcurrentHashMap

object ServiceDiscoveryCenter {

    private val serviceMap = ConcurrentHashMap<Class<out IBaseService>, IBaseService>()

    fun register(service: Class<out IBaseService>, impl: IBaseService) {
        serviceMap[service] = impl
    }

    fun <T : IBaseService> proceed(service: Class<out IBaseService>): T? {
        return if(serviceMap.containsKey(service)){
            serviceMap[service] as T
        } else {
            null
        }
    }
}