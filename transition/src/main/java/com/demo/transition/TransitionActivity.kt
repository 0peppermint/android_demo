package com.demo.transition

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Looper
import android.transition.ChangeBounds
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import android.transition.ChangeTransform
import android.transition.Fade
import android.transition.TransitionSet
import kotlinx.android.synthetic.main.demo_transition_transition_1.*

class TransitionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demo_transition_transition_1)
        setWindowAnimations()
        tv_return.setOnClickListener {
            ActivityCompat.finishAfterTransition(this)
        }
    }

    fun setWindowAnimations() {
        val transitionSet = TransitionSet()
//        val changeTransform = ChangeTransform()
//        changeTransform.duration = 1000
//        changeTransform.excludeTarget(android.R.id.statusBarBackground, true)
        /**
         * changeBounds实现平移
         */
//        val changeBounds = ChangeBounds()
//        changeBounds.duration = 300
//        changeBounds.excludeTarget(android.R.id.statusBarBackground, true)
        window.allowEnterTransitionOverlap = false
        window.allowReturnTransitionOverlap = false
        window.sharedElementEnterTransition = MyTransitionSet()
        window.sharedElementReturnTransition = MyTransitionSet()
        window.enterTransition = Fade()
        window.exitTransition = Fade()
    }
}