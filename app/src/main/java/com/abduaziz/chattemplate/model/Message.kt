package com.abduaziz.chattemplate.model

/**
 * Created by abduaziz on 1/26/18.
 */

class Message(val id: Long,
              val message: String,
              val ownerId: Long,
              val ownerName: String,
              val type: String,
              val date: Long) {

    companion object {
        // message types: text, photo, voice etc.
        val TEXT = "text"
        val PHOTO = "photo"
        val VOICE = "voice"
    }

}