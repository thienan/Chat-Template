package com.abduaziz.chattemplate.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.abduaziz.chattemplate.R
import com.abduaziz.chattemplate.model.Conversation
import org.pager.messenger.ui.view.ContactPhotoView

/**
 * Created by abduaziz on 1/21/18.
 */

class ConversationController(var conversations: List<Conversation>) : RecyclerView.Adapter<ConversationController.ViewHolder>() {

    override fun getItemCount(): Int {
        return conversations.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(conversations[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_conversation, parent, false))
    }

    // See item_conversation.xml
    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var chatPhotoView: ContactPhotoView // imageView to show chat photo
        internal var tvChatName: TextView // textView for chat chatname
        internal var tvLastMessage: TextView // textView to show last message
        internal var ivMessageStatus: ImageView // imageView to show message status: SENT, WAITING, RECEIVED
        internal var tvMessageDate: TextView // message time

        init {
            chatPhotoView = itemView.findViewById(R.id.contactPhotoView)
            tvChatName = itemView.findViewById(R.id.textViewChatName)
            tvLastMessage = itemView.findViewById(R.id.textViewLastMessage)
            ivMessageStatus = itemView.findViewById(R.id.imageViewLastMessageStatus)
            tvMessageDate = itemView.findViewById(R.id.textViewLastMessageDate)
        }

        fun bind(conversation: Conversation) {
            if (conversation.photo < 0)
                chatPhotoView.abbr(conversation.chatname)
            else
                chatPhotoView.image(conversation.photo)

            tvChatName.text = conversation.chatname
            tvLastMessage.text = conversation.lastMessage
            ivMessageStatus.setImageResource(conversation.lastMessageStatus)
            tvMessageDate.text = conversation.lastMessageDate

        }
    }
}