package com.demo.nativecrash

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_native_crash.*

class MyCrashActivity: AppCompatActivity() {

    private val myNativeCrash = MyNativeCrash()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_native_crash)
        btn_null_pointer.setOnClickListener {
            myNativeCrash.nullPointer()
        }

    }

}