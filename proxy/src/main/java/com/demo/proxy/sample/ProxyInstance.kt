package com.demo.proxy.sample

import com.demo.proxy.sample.api.IMyProxy
import com.demo.proxy.sample.impl.MyProxy
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

object ProxyInstance {
    fun getMyProxy(){
        val myProxy = MyProxy()

        val currentMyProxy: IMyProxy = Proxy.newProxyInstance(
            IMyProxy::class.java.classLoader,
            IMyProxy::class.java.interfaces,
            object : InvocationHandler{
                override fun invoke(proxy: Any?, method: Method, args: Array<out Any>?): Any? {
                    return if (args == null) {
                        method.invoke(myProxy)
                    } else {
                        method.invoke(myProxy, args)
                    }
                }
            }
        ) as IMyProxy
        currentMyProxy.run()
    }
}