package com.example.smsapp.ui.incoming.v5

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.smsapp.data.SmsMessage
import com.example.smsapp.ui.incoming.common.IncomingEmptyState

@Composable
fun IncomingListUIForV5(
    messages: List<SmsMessage>,
    modifier: Modifier = Modifier,
    onOpenClick: (SmsMessage) -> Unit
) {

    if (messages.isEmpty()) {
        IncomingEmptyState()
        return
    }

    LazyColumn(modifier = modifier) {
        items(messages) { sms ->
            IncomingMessageCardV5(sms, onOpenClick)
        }
    }
}