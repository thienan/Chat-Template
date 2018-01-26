package org.pager.messenger.ui.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.RelativeLayout
import android.widget.TextView
import com.abduaziz.chattemplate.R
import com.abduaziz.chattemplate.ui.view.CircleImageView

/**
 * Created by abduaziz on 1/24/18.
 */

class ContactPhotoView(context: Context, attrs: AttributeSet?) : RelativeLayout(context, attrs) {

    val circleImageView: CircleImageView
    val textView: TextView
    var colors: Array<Int>

    init {
        circleImageView = CircleImageView(context, attrs)
        var params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        circleImageView.setImageResource(R.color.colorPrimary)
        circleImageView.layoutParams = params
        addView(circleImageView)

        textView = TextView(context)
        var textParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        textParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
        textView.setTypeface(null, Typeface.BOLD)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.circle_image_view_text_size))
        textView.setTextColor(ContextCompat.getColor(context, R.color.white))
        addView(textView, textParams)

        colors = arrayOf(
                R.color.c1, R.color.c2, R.color.c3, R.color.c4, R.color.c5,
                R.color.c6, R.color.c7, R.color.c8, R.color.c9, R.color.c10,
                R.color.c11, R.color.c12, R.color.c13, R.color.c14, R.color.c15)
    }

    fun image(photo: Int){
        circleImageView.setImageResource(photo)
        textView.setText("")
        invalidate()
        requestLayout()
    }

    fun image(bitmap: Bitmap?) {
        circleImageView.setImageBitmap(bitmap)
        textView.setText("")
        invalidate()
        requestLayout()
    }

    fun abbr(name: String?) {
        circleImageView.setImageResource(color(name))
        textView.text = getAbbr(name)
        invalidate()
        requestLayout()
    }

    fun abbr(name: String?, color: Int) {
        circleImageView.setImageResource(color)
        textView.text = getAbbr(name)
        invalidate()
        requestLayout()
    }

    fun getAbbr(name: String?): String {
        var result = ""
        var afterSpace = true
        if (name != null && !name.isBlank())
            for (i in 0 until name.length) {
                if (name[i].equals(' '))
                    afterSpace = true
                else {
                    if (afterSpace) {
                        result += name[i]
                        afterSpace = false
                    }
                }
                if (result.length >= 2)
                    break
            }
        else {
            return "?"
        }
        return result.toUpperCase()
    }

    fun color(name: String?): Int {
        if (name != null && !name.isBlank())
            return colors[name[0].toInt() % colors.size]
        else
            return R.color.md_blue_grey_200
    }

    fun blur(): String {
        if (textView.text.length > 0)
            return ""
        //var blur = BitmapUtils.drawableToBitmap(circleImageView.drawable)
        return ""//BitmapUtils.bitMapToString(blur)
    }

}