package com.example.smsapp.ui.incoming.v5.model

import com.example.smsapp.data.SmsMessage

data class IncomingConversation(
    val address: String,
    val lastMessage: String,
    val lastTimestamp: Long,
    val count: Int,
    val messages: List<SmsMessage>
)