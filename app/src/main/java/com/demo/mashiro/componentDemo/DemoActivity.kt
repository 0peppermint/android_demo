package com.demo.mashiro.componentDemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.componentmvp.component.bindLifeCycle
import com.demo.mashiro.R
import kotlinx.android.synthetic.main.activity_main.*

class DemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun initComponents() {
        val demo1 = DemoComponent(baseContext)
        this.bindLifeCycle(demo1)
    }

    private fun initView() {
        cl_main.addView(DemoComponent(baseContext))
    }
}