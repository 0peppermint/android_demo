package com.demo.mashiro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.multifragment.MultiFragmentActivity
import com.demo.transition.BaseTransitionActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_transition_experiment.setOnClickListener {
            val intent = Intent(this, MultiFragmentActivity::class.java)
            this.startActivity(intent)
        }
    }
}