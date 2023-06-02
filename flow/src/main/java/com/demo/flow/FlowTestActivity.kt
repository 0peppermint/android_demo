package com.demo.flow

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.demo.flow.processchain.FlowChainClient
import com.demo.flow.singleexecutor.SingleExecutorTest
import kotlinx.android.synthetic.main.flow_test_activity.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

class FlowTestActivity: AppCompatActivity(){

    private val valueFlow = MutableStateFlow("aa")

    private var cnt = 0
    private val hahaStr = "haha"
    private val heheStr = "hehe"
    private val testClient = FlowChainClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flow_test_activity)
        initListener()
    }
    private fun initListener() {
        btn_test_flow_client.setOnClickListener {
            lifecycleScope.launchWhenResumed {
                testClient.start()
            }
        }
        btn_test_add_flow_collect.setOnClickListener {
            lifecycleScope.launch {
                valueFlow.filter {
                    it.contains(hahaStr)
                }.collect{
                    tv_collect_data.text = valueFlow.value
                    Log.i("zyc", "yes i collect it! $cnt")
                }
            }
        }
        btn_test_emit_flow.setOnClickListener {
            lifecycleScope.launch {
                cnt += 1
                valueFlow.emit("$cnt is " + if (cnt % 2 == 0) hahaStr else heheStr)
            }
        }
        btn_test_single_executor.setOnClickListener {
            SingleExecutorTest().test()
        }
    }
}