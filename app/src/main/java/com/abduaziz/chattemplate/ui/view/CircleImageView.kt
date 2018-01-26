package com.abduaziz.chattemplate.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet

/**
 * Created by abduaziz on 1/24/18.
 */

class CircleImageView(context: Context, attr: AttributeSet?) : AppCompatImageView(context, attr) {

    val ratio: Float = 50f
    var path: Path? = null

    override fun onDraw(canvas: Canvas?) {
        if (path == null) {
            path = Path()
            path?.addRoundRect(RectF(0f, 0f, width.toFloat(), height.toFloat()), ratio * width, ratio * height, Path.Direction.CW)
        }

        canvas?.save()
        canvas?.clipPath(path)
        super.onDraw(canvas)
        canvas?.restore()
    }

}