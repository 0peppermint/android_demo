package com.demo.core.service.impl

import android.util.Log
import com.demo.core.service.api.IMyTestService

class MyTestServiceImpl: IMyTestService {

    override fun myTest() {
        Log.d("zyc", "you found me")
    }

    override fun proceed() {
        Log.d("zyc", "haha")
        myTest()
    }
}