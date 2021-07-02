package com.demo.transition

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.Explode
import android.transition.Fade
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import kotlinx.android.synthetic.main.demo_transition_basetransition.*


class BaseTransitionActivity : AppCompatActivity() {

    companion object {
        fun startUI(context: Context) {
            val starter = Intent(context, BaseTransitionActivity::class.java)
            context.startActivity(starter)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demo_transition_basetransition)
        setupWindowAnimations()
        iv_share_element.setOnClickListener {
            val activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this, it,
                "shareElement"
            )
            ActivityCompat.startActivity(
                this,
                Intent(this, TransitionActivity::class.java),
                activityOptionsCompat.toBundle()
            )
        }
        tv_return.setOnClickListener {
            finish()
        }
    }


    private fun setupWindowAnimations() {
        val explodeTransition = Explode()
        window.allowEnterTransitionOverlap = false
        window.allowReturnTransitionOverlap = false
    }
}