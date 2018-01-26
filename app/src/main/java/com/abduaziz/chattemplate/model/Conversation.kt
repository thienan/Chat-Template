package com.abduaziz.chattemplate.model

/**
 * Created by abduaziz on 1/21/18.
 */

open class Conversation(val id: Long,
                        val chatname: String, val photo: Int,
                        val lastMessage: String, val lastMessageStatus: Int,
                        val lastMessageDate: String)