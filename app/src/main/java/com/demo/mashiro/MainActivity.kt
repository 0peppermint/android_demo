package com.demo.mashiro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.multifragment.useViewPager2.MultiFragmentActivityV2
import com.demo.nativecrash.MyCrashActivity
import com.demo.proxy.sample.ProxyInstance
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_transition_experiment.setOnClickListener {
            val intent = Intent(this, MultiFragmentActivityV2::class.java)
            this.startActivity(intent)
        }

        btn_native_crash.setOnClickListener {
            val intent = Intent(this, MyCrashActivity::class.java)
            this.startActivity(intent)
        }
        btn_proxy.setOnClickListener{
            ProxyInstance.getMyProxy()
        }
    }
}