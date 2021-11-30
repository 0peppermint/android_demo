package com.demo.core.service

import com.demo.core.service.api.IMyTestService

class TestClass {

    fun test() {
        ServiceDiscoveryCenter.register(IMyTestService::class.java)
        ServiceDiscoveryCenter.proceed<IMyTestService>(IMyTestService::class.java)?.proceed()
    }
}