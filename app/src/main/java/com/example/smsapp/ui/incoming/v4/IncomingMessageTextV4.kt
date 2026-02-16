package com.example.smsapp.ui.incoming.v4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smsapp.data.SmsMessage
import com.example.smsapp.ui.common.SmartTimeFormatter

@Composable
fun IncomingMessageTextV4(
    sms: SmsMessage,
    modifier: Modifier = Modifier
) {

    Column(modifier) {

        Text(sms.address, style = MaterialTheme.typography.titleMedium)

        Spacer(Modifier.height(6.dp))

        Text(sms.body, style = MaterialTheme.typography.bodyMedium)

        Spacer(Modifier.height(8.dp))

        Text(
            SmartTimeFormatter.format(sms.date.toLong()),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}