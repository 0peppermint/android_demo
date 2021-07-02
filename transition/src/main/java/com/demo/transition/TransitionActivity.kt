package com.demo.transition

import android.os.Bundle
import android.transition.ChangeBounds
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.demo_transition_transition_1.*

class TransitionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demo_transition_transition_1)

        tv_return.setOnClickListener {
            ActivityCompat.finishAfterTransition(this)
        }
    }

    fun setWindowAnimations() {
        val changeBounds = ChangeBounds()
        changeBounds.duration = 300
        changeBounds.excludeTarget(android.R.id.statusBarBackground, true)
        window.allowEnterTransitionOverlap = false
        window.allowReturnTransitionOverlap = false
        window.enterTransition = changeBounds
    }
}