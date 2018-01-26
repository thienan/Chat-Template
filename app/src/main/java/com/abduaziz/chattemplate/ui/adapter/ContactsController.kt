package com.abduaziz.chattemplate.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.abduaziz.chattemplate.R
import com.abduaziz.chattemplate.model.Contact
import org.pager.messenger.ui.view.ContactPhotoView

/**
 * Created by abduaziz on 1/26/18.
 */

class ContactsController(val contactsList: List<Contact>) : RecyclerView.Adapter<ContactsController.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ContactViewHolder {
        return ContactViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_contacts, parent, false))
    }

    override fun onBindViewHolder(holder: ContactViewHolder?, position: Int) {
        holder?.bind(contactsList[position])
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal val contactPhotoView: ContactPhotoView
        internal val textViewContactName: TextView
        internal val textViewContactStatus: TextView

        init {
            contactPhotoView = itemView.findViewById(R.id.contactPhotoView)
            textViewContactName = itemView.findViewById(R.id.textViewContactName)
            textViewContactStatus = itemView.findViewById(R.id.textViewContactStatus)
        }

        fun bind(contact: Contact) {
            if (contact.photo < 0)
                contactPhotoView.abbr(contact.firstname + " " + contact.lastname)
            else
                contactPhotoView.image(contact.photo)
            textViewContactName.text = contact.firstname + " " + contact.lastname
            textViewContactStatus.text = contact.status
        }

    }

}