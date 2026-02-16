package com.example.smsapp.ui.incoming.v6

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.smsapp.ui.incoming.common.IncomingEmptyState
import com.example.smsapp.ui.incoming.v5.model.IncomingConversation

@Composable
fun IncomingConversationListV6(
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
            IncomingConversationItemV6(convo, onOpenConversation)
        }
    }
}