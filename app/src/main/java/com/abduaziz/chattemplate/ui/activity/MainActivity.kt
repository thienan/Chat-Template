package com.abduaziz.chattemplate.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.widget.Toolbar
import com.abduaziz.chattemplate.R
import android.support.v7.widget.*
import com.abduaziz.chattemplate.ui.adapter.PagerAdapter
import com.abduaziz.chattemplate.ui.fragment.ContactsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titles = listOf(getString(R.string.contacts), getString(R.string.chats),
                getString(R.string.groups),getString(R.string.settings))

        val fragments = listOf(ContactsFragment(),ContactsFragment(),ContactsFragment(),ContactsFragment())
        val pagerAdapter = PagerAdapter(supportFragmentManager, fragments)
        pager.adapter = pagerAdapter
        pager.offscreenPageLimit = 1

        tabs.setupWithViewPager(pager)
        tabs.setIcons(R.drawable.ic_contacts_24dp, R.drawable.ic_chats_24dp,
                R.drawable.ic_group_24dp, R.drawable.ic_settings_24dp)
        tabs.setSelectedTabIndicatorColor(ContextCompat.getColor(this,R.color.white))

        pager.currentItem = 1
        pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{

            override fun onPageSelected(position: Int) {
                toolBar.setTitle(titles[position].toString())
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

        })
    }
}
