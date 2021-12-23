package com.demo.multifragment.someuifragment.springanimation

import androidx.recyclerview.widget.RecyclerView
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.demo.multifragment.R


abstract class OnRecyclerItemClickListener(private val recyclerView: RecyclerView) : OnItemTouchListener {

    private var position = -1

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        return true
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        // 在down的时候记录一下当前的vh
        // 一旦move了，特效直接寄
        // 一旦up和down的时候不一致，直接寄
        when(e.action) {
            MotionEvent.ACTION_DOWN -> {
                val childView = recyclerView.findChildViewUnder(e.x, e.y)
                if (childView != null) {
                    val vh = recyclerView.getChildViewHolder(childView)
                    position = vh.adapterPosition
                    (vh as? BaseViewHolder)?.getView<ImageView>(R.id.iv_icon)?.let {
                        testAnimation(it, 0.9f)
                    }
                }
            }
            MotionEvent.ACTION_MOVE -> {
                cancelAnimation(e,null)
                onMove()
            }
            MotionEvent.ACTION_UP -> {
                cancelAnimation(e){viewHolder ->
                    ( viewHolder  as? BaseViewHolder)?.getView<ImageView>(R.id.iv_icon)?.let {
                        testAnimation(it, 1f)
                    }
                    onUp(viewHolder)
                    position = -1
                }
            }
        }
    }

    private fun cancelAnimation(e: MotionEvent, block:((vh: RecyclerView.ViewHolder?) -> Unit)?) {
        position.takeIf { it != -1 }?.let {
            val childView = recyclerView.findChildViewUnder(e.x, e.y)
            if (childView != null) {
                val vh = recyclerView.getChildViewHolder(childView)
                if (position != vh.adapterPosition) {
                    (recyclerView.findViewHolderForAdapterPosition(position) as? BaseViewHolder)?.getView<ImageView>(R.id.iv_icon)?.let {
                        testAnimation(it, 1f)
                    }
                    position = -1
                } else {
                    block?.invoke(vh)
                }
            } else {
                position = -1
            }
        }
    }

    private fun testAnimation(view: View, scale: Float) {
        val springAnimationX = SpringAnimation(view, DynamicAnimation.SCALE_X, scale)
        val springAnimationY = SpringAnimation(view, DynamicAnimation.SCALE_Y, scale)
        springAnimationX.spring.stiffness = 350f;
        springAnimationX.spring.dampingRatio = 0.53f;
        springAnimationX.setStartVelocity(0f);

        springAnimationY.spring.stiffness = 350f;
        springAnimationY.spring.dampingRatio = 0.53f;
        springAnimationY.setStartVelocity(0f);

        springAnimationX.addEndListener { animation, canceled, value, velocity ->
            view.matrix.setScale(scale, scale)
        }
        springAnimationX.start()
        springAnimationY.start()
    }

    abstract fun onDown(vh: RecyclerView.ViewHolder?)
    abstract fun onMove()
    abstract fun onUp(vh: RecyclerView.ViewHolder?)
}