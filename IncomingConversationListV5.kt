package com.example.smsapp.ui.incoming.v5

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.smsapp.ui.incoming.common.IncomingEmptyState
import com.example.smsapp.ui.incoming.model.IncomingConversation

@Composable
fun IncomingConversationListV5(
    conversations: List<IncomingConversation>,
    modifier: Modifier = Modifier,
    onOpenConversation: (String) -> Unit
) {

    if (conversations.isEmpty()) {
        IncomingEmptyState()
        return
    }

    LazyColumn(modifier = modifier) {
        items(conversations) { convo ->
            IncomingConversationItemV5(convo, onOpenConversation)
        }
    }
}