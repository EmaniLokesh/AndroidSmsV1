package com.example.smsapp.ui.incoming.v5

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.example.smsapp.data.SmsMessage
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send

@Composable
fun IncomingMessageActionsV5(
    sms: SmsMessage,
    onOpenClick: (SmsMessage) -> Unit
) {
    IconButton(onClick = { onOpenClick(sms) }) {
        Icon(Icons.Default.Send, contentDescription = "Reply")
    }
}