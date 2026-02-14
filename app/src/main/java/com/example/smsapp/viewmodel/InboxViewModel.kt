package com.example.smsapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.smsapp.data.SmsMessage
import com.example.smsapp.data.SmsReaderRepository

class InboxViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = SmsReaderRepository(application)

    private val _messages = MutableStateFlow<List<SmsMessage>>(emptyList())
    val messages: StateFlow<List<SmsMessage>> = _messages

    fun loadMessages() {
        _messages.value = repository.getInboxMessages()
    }

    fun getGroupedMessages(): Map<String, List<SmsMessage>> {
        return repository.getGroupedMessages()
    }
}