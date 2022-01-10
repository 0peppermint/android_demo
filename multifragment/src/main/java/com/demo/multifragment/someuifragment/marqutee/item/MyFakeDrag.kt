package com.demo.multifragment.someuifragment.marqutee.item

import android.os.SystemClock
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.ViewConfiguration
import androidx.annotation.UiThread
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2


/**
 * Provides fake dragging functionality to [ViewPager2].
 */
internal class MyFakeDrag(
    private val mRecyclerView: RecyclerView,
    private val isHorizontal: Boolean,
) {
    private var mVelocityTracker: VelocityTracker? = null
    private var mMaximumVelocity = 0
    private var mRequestedDragDistance = 0f
    private var mActualDraggedDistance = 0
    private var mFakeDragBeginTime: Long = 0

    @UiThread
    fun beginFakeDrag(): Boolean {
        mActualDraggedDistance = 0
        mRequestedDragDistance = mActualDraggedDistance.toFloat()
        mFakeDragBeginTime = SystemClock.uptimeMillis()
        beginFakeVelocityTracker()
        addFakeMotionEvent(mFakeDragBeginTime, MotionEvent.ACTION_DOWN, 0f, 0f)
        return true
    }

    @UiThread
    fun fakeDragBy(offsetPxFloat: Float): Boolean {
        // Subtract the offset, because content scrolls in the opposite direction of finger motion
        mRequestedDragDistance -= offsetPxFloat
        // Calculate amount of pixels to scroll ...
        val offsetPx = Math.round(mRequestedDragDistance - mActualDraggedDistance)
        // ... and keep track of pixels scrolled so we don't get rounding errors
        mActualDraggedDistance += offsetPx
        val time = SystemClock.uptimeMillis()
        // Scroll deltas use pixels:
        val offsetX = if (isHorizontal) offsetPx else 0
        val offsetY = if (isHorizontal) 0 else offsetPx
        // Motion events get the raw float distance:
        val x: Float = if (isHorizontal) mRequestedDragDistance else 0f
        val y: Float = if (isHorizontal) 0f else mRequestedDragDistance
        mRecyclerView.scrollBy(offsetX, offsetY)
        addFakeMotionEvent(time, MotionEvent.ACTION_MOVE, x, y)
        return true
    }

    @UiThread
    fun endFakeDrag(): Boolean {

        // Compute the velocity of the fake drag
        val pixelsPerSecond = 1000
        val velocityTracker = mVelocityTracker
        velocityTracker!!.computeCurrentVelocity(pixelsPerSecond, mMaximumVelocity.toFloat())
        val xVelocity = velocityTracker.xVelocity.toInt()
        val yVelocity = velocityTracker.yVelocity.toInt()
        // And fling or snap the ViewPager2 to its destination
        if (!mRecyclerView.fling(xVelocity, yVelocity)) {
            // Velocity too low, trigger snap to page manually
        }
        return true
    }

    private fun beginFakeVelocityTracker() {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain()
            val configuration = ViewConfiguration.get(mRecyclerView.context)
            mMaximumVelocity = configuration.scaledMaximumFlingVelocity
        } else {
            mVelocityTracker!!.clear()
        }
    }

    private fun addFakeMotionEvent(time: Long, action: Int, x: Float, y: Float) {
        val ev = MotionEvent.obtain(mFakeDragBeginTime, time, action, x, y, 0)
        mVelocityTracker!!.addMovement(ev)
        ev.recycle()
    }
}
