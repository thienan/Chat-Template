package com.abduaziz.chattemplate.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.abduaziz.chattemplate.R
import com.abduaziz.chattemplate.ui.fragment.ChatsFragment
import com.abduaziz.chattemplate.ui.fragment.ContactsFragment
import com.abduaziz.chattemplate.ui.fragment.GroupsFragment
import com.abduaziz.chattemplate.ui.fragment.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var activeFragment = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ChatsFragment(), "ChatsFragment")
                    .commitAllowingStateLoss()
        }

        imageViewContacts.setOnClickListener(View.OnClickListener {
            if (activeFragment != 0) {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ContactsFragment(), "ContactsFragment")
                        .commitNowAllowingStateLoss()
                initBottomTabs(0)
            }
        })

        imageViewChats.setOnClickListener(View.OnClickListener {
            if (activeFragment != 1) {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ChatsFragment(), "ChatsFragment")
                        .commitNowAllowingStateLoss()
                initBottomTabs(1)
            }
        })

        imageViewGroups.setOnClickListener(View.OnClickListener {
            if (activeFragment != 2) {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, GroupsFragment(), "GroupsFragment")
                        .commitNowAllowingStateLoss()
                initBottomTabs(2)
            }
        })

        imageViewSettings.setOnClickListener(View.OnClickListener {
            if (activeFragment != 3) {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, SettingsFragment(), "SettingsFragment")
                        .commitNowAllowingStateLoss()
                initBottomTabs(3)
            }
        })
    }

    fun initBottomTabs(position: Int) {
        imageViewContacts.setImageResource(R.drawable.ic_contacts_24dp)
        imageViewChats.setImageResource(R.drawable.ic_chats_24dp)
        imageViewGroups.setImageResource(R.drawable.ic_group_24dp)
        imageViewSettings.setImageResource(R.drawable.ic_settings_24dp)
        activeFragment = position
        when (position) {
            0 -> {
                imageViewContacts.setImageResource(R.drawable.ic_contacts_color_primary)
                toolBar.title = getString(R.string.contacts)
            }

            1 -> {
                imageViewChats.setImageResource(R.drawable.ic_chats_color_primary)
                toolBar.title = getString(R.string.chats)
            }
            2 -> {
                imageViewGroups.setImageResource(R.drawable.ic_group_color_primary)
                toolBar.title = getString(R.string.groups)
            }
            3 -> {
                imageViewSettings.setImageResource(R.drawable.ic_settings_color_primary)
                toolBar.title = getString(R.string.settings)
            }
        }
    }
}