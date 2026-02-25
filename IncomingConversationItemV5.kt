package com.example.smsapp.ui.incoming.v5

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smsapp.ui.common.SmartTimeFormatter
import com.example.smsapp.ui.incoming.model.IncomingConversation

@Composable
fun IncomingConversationItemV5(
    convo: IncomingConversation,
    onOpenConversation: (String) -> Unit
) {

    Card(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {

        Row(
            modifier = Modifier
                .padding(14.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(Modifier.weight(1f)) {

                Text(convo.address, style = MaterialTheme.typography.titleMedium)

                Spacer(Modifier.height(6.dp))

                Text(convo.lastMessage, style = MaterialTheme.typography.bodyMedium)

                Spacer(Modifier.height(8.dp))

                Text(
                    SmartTimeFormatter.format(convo.lastTimestamp),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Column(horizontalAlignment = Alignment.End) {

                Text(
                    text = "${convo.count}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                IconButton(onClick = {
                    onOpenConversation(convo.address)
                }) {
                    Icon(Icons.Default.Send, contentDescription = "Open")
                }
            }
        }
    }
}