package com.abduaziz.chattemplate.ui.view

import android.content.Context
import android.support.design.widget.TabLayout
import android.util.AttributeSet
import android.util.Log

/**
 * Created by abduaziz on 9/01/18.
 */

class PagerTabLayout(context: Context, atts: AttributeSet) : TabLayout(context, atts) {

    fun setIcons(vararg icons: Int) {
        //check if there are enough icons to all tabs
        if (icons.size >= tabCount)
            for (i in 0 until tabCount) {
                getTabAt(i)!!.setIcon(icons[i])
            }
        else {
            //otherwise, print some error message
            Log.d("PagerTabLayout", "setIcons: There are not enough icons to set to TabLayout")
        }
    }
}
