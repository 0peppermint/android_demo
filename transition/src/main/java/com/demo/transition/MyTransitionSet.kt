package com.demo.transition

import android.content.Context
import android.transition.ChangeBounds
import android.transition.ChangeImageTransform
import android.transition.ChangeTransform
import android.transition.TransitionSet
import android.util.AttributeSet

class MyTransitionSet : TransitionSet {
    constructor() {
        init()
    }

    /**
     * This constructor allows us to use this transition in XML
     */
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    private fun init() {
        ordering = ORDERING_TOGETHER
        addTransition(ChangeBounds()).addTransition(ChangeTransform()).addTransition(
            ChangeImageTransform()
        )
    }
}