package com.demo.multifragment.someuifragment.marqutee.item

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.animation.PathInterpolator
import androidx.recyclerview.widget.RecyclerView

class MyRecycleView: RecyclerView {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {

    }

    private var mFakeDrag : MyFakeDrag? = null

    @Volatile
    private var currentPosition = 1

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mFakeDrag = MyFakeDrag(this, false)
    }

    fun setFakeDrag(
        item: Int,
        duration: Long,
        interpolator: PathInterpolator = PathInterpolator(0.65f,0f,0.35f,1f),
        pageHeight: Int = height/2
    ) {
        if (mFakeDrag == null) {
            scrollToPosition(item)
        }
        val pxToDrag: Int = pageHeight * (item - currentPosition)
        val animator = ValueAnimator.ofInt(0, pxToDrag)
        var previousValue = 0
        animator.addUpdateListener { valueAnimator ->
            val currentValue = valueAnimator.animatedValue as Int
            val currentPxToDrag = (currentValue - previousValue).toFloat()
            mFakeDrag!!.fakeDragBy(-currentPxToDrag)
            previousValue = currentValue
        }
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
                mFakeDrag!!.beginFakeDrag()
            }
            override fun onAnimationEnd(animation: Animator?) {
                mFakeDrag!!.endFakeDrag()
                currentPosition = item
                Log.d("zyc", "$currentPosition")
                if (currentPosition == 5) {
                    currentPosition = 1
                    scrollToPosition(0)
                }
            }
            override fun onAnimationCancel(animation: Animator?) { }
            override fun onAnimationRepeat(animation: Animator?) { }
        })
        animator.interpolator = interpolator
        animator.duration = duration
        animator.start()
    }
}