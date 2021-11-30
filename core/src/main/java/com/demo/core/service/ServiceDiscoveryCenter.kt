package com.demo.core.service

import com.demo.core.service.api.IBaseService
import java.util.concurrent.ConcurrentHashMap

object ServiceDiscoveryCenter {

    private val serviceMap = ConcurrentHashMap<Class<out IBaseService>, IBaseService>()

    fun register(service: Class<out IBaseService>) {
        serviceMap[service] = service.newInstance()
    }

    fun <T : IBaseService> proceed(service: Class<out IBaseService>): T? {
        synchronized(serviceMap) {
            return if(serviceMap.contains(service)){
                serviceMap[service] as T
            } else {
                null
            }
        }
    }
}