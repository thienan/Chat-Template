package com.abduaziz.chattemplate.ui.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SimpleItemAnimator
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

/**
 * Created by abduaziz on 1/22/18.
 */

class RecyclerListView(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs) {

    fun addOnItemClickListener(context: Context, onItemClickListener: OnItemClickListener) {
        addOnItemTouchListener(RecyclerItemClickListener(context, this, onItemClickListener))
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
        fun onLongItemClick(view: View?, position: Int)
    }

    class NoAnimationItemAnimator : SimpleItemAnimator() {
        override fun animateRemove(holder: RecyclerView.ViewHolder): Boolean {
            dispatchRemoveFinished(holder)

            return false
        }

        override fun animateAdd(holder: RecyclerView.ViewHolder): Boolean {
            dispatchAddFinished(holder)

            return false
        }

        override fun animateMove(holder: RecyclerView.ViewHolder, fromX: Int, fromY: Int, toX: Int, toY: Int): Boolean {
            dispatchMoveFinished(holder)

            return false
        }

        override fun animateChange(oldHolder: RecyclerView.ViewHolder, newHolder: RecyclerView.ViewHolder, fromX: Int, fromY: Int, toX: Int, toY: Int): Boolean {
            dispatchChangeFinished(oldHolder, true)
            dispatchChangeFinished(newHolder, false)

            return false
        }

        override fun runPendingAnimations() {
            // stub
        }

        override fun endAnimation(item: RecyclerView.ViewHolder) {
            // stub
        }

        override fun endAnimations() {
            // stub
        }

        override fun isRunning(): Boolean {
            return false
        }
    }

    inner class RecyclerItemClickListener(context: Context, recyclerView: RecyclerView, private val mListener: OnItemClickListener?) : RecyclerView.OnItemTouchListener {
        internal var mGestureDetector: GestureDetector

        init {
            mGestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(e: MotionEvent): Boolean {
                    return true
                }

                override fun onLongPress(e: MotionEvent) {
                    val child = recyclerView.findChildViewUnder(e.x, e.y)
                    if (child != null && mListener != null) {
                        mListener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child))
                    }
                }
            })
        }

        override fun onInterceptTouchEvent(view: RecyclerView, e: MotionEvent): Boolean {
            val childView = view.findChildViewUnder(e.x, e.y)
            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
                mListener.onItemClick(childView, view.getChildAdapterPosition(childView))
                return true
            }
            return false
        }

        override fun onTouchEvent(view: RecyclerView, motionEvent: MotionEvent) {}

        override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
    }

}
