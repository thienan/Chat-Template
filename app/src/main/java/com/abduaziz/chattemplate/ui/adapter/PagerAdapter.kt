package com.abduaziz.chattemplate.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by abduaziz on 1/9/18.
 */
class PagerAdapter(fm: FragmentManager, internal var list: List<Fragment>) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

}