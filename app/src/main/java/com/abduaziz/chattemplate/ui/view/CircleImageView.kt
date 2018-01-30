package com.abduaziz.chattemplate.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet

/**
 * Created by abduaziz on 1/24/18.
 */

class CircleImageView(context: Context, attr: AttributeSet?) : AppCompatImageView(context, attr) {

    var path: Path? = null

    override fun onDraw(canvas: Canvas?) {
        if (path == null) {
            path = Path()
            path?.addCircle(width/2f, height/2f, width / 2f, Path.Direction.CW)
        }
        scaleType = ScaleType.CENTER_CROP
        canvas?.save()
        canvas?.clipPath(path)
        super.onDraw(canvas)
        canvas?.restore()
    }

}