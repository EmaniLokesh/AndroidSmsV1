package com.example.smsapp.ui.incoming.v5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smsapp.data.SmsMessage

@Composable
fun IncomingMessageRowV5(
    sms: SmsMessage,
    onOpenClick: (SmsMessage) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(14.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        IncomingMessageTextV5(
            sms = sms,
            modifier = Modifier.weight(1f)
        )

        IncomingMessageActionsV5(sms, onOpenClick)
    }
}