package com.demo.flow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.demo.flow.core.FlowChainClient
import kotlinx.android.synthetic.main.flow_test_activity.*
import kotlinx.coroutines.launch

class FlowTestActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flow_test_activity)
        initListener()
    }


    private fun initListener() {
        btn_test_flow_client.setOnClickListener {
            lifecycleScope.launch {
                val testClient = FlowChainClient()
                testClient.start()
            }
        }
    }
}