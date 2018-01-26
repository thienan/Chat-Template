package com.abduaziz.chattemplate.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abduaziz.chattemplate.R
import com.abduaziz.chattemplate.model.Conversation
import com.abduaziz.chattemplate.ui.adapter.ConversationController
import kotlinx.android.synthetic.main.fragment_chats.*

/**
 * Created by abduaziz on 1/9/18.
 */

class GroupsFragment : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_groups, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        rvChats.layoutManager = LinearLayoutManager(context)
        var adapter = ConversationController(listOf(
                Conversation(0, "Saved Messages", -1, "Some awesome messages", R.drawable.ic_message_sent, "8:32"),
                Conversation(0, "John Watson", -1, "Hey, did you find that criminal?", R.drawable.ic_message_received, "17:02"),
                Conversation(0, "Mycroft Holmes", -1, "Be careful, bro!", R.drawable.ic_message_sent, "10:12"),
                Conversation(0, "John Best Friend", -1, "You have my financial support ;-)", R.drawable.ic_message_not_send, "8:59"),
                Conversation(0, "Irene Adler", -1, "How was your last night?", R.drawable.ic_message_received, "15:27"),
                Conversation(0, "Moriarty", -1, "Heyy, another problem for you", R.drawable.ic_message_received, "18:45"),
                Conversation(0, "Alex Criminal", -1, "I am the criminal", R.drawable.ic_message_not_send, "18:32"),
                Conversation(0, "Miss Hart", -1, "Would you like some coffee?", R.drawable.ic_message_sent, "23:32")
        ).shuffled())
        rvChats.adapter = adapter
    }
}