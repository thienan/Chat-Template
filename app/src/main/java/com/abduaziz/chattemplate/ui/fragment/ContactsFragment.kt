package com.abduaziz.chattemplate.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abduaziz.chattemplate.R
import com.abduaziz.chattemplate.model.Contact
import com.abduaziz.chattemplate.ui.adapter.ContactsController
import kotlinx.android.synthetic.main.fragment_contacts.*

/**
 * Created by abduaziz on 1/9/18.
 */

class ContactsFragment() : Fragment() {

    internal lateinit var controller: ContactsController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true // retain instance of this fragment
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewContacts.layoutManager = LinearLayoutManager(context)
        controller = ContactsController(listOf(
                Contact(1, "Sherlock", "Holmes", "Criminal mastermind", R.drawable.sherlock),
                Contact(1, "Irene", "Adler", "Have some fun at night", R.drawable.irene),
                Contact(1, "John", "Watson", "Always here to support", R.drawable.john),
                Contact(1, "Mycroft", "Holmes", "Sherlock's brother", R.drawable.mycroft),
                Contact(1, "James", "Moriarty", "Napoleon of crime", R.drawable.moriarty),
                Contact(1, "Cristiano", "Ronaldo", "I am the best", -1),
                Contact(1, "Leonel", "Messi", "No, I am the best", -1),
                Contact(1, "Paul", "Pogba", "Maybe, next time", -1),
                Contact(1, "Jose", "Mourinho", "The special one", -1),
                Contact(1, "Carlos", "Quireoz", "Patriot", -1)
        ))
        recyclerViewContacts.adapter = controller

    }

}