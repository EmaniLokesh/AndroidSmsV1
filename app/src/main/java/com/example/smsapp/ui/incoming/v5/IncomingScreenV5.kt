package com.example.smsapp.ui.incoming.v5

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.smsapp.data.SmsMessage
import com.example.smsapp.ui.components.AppTopBar
import com.example.smsapp.ui.incoming.common.IncomingPermission
import com.example.smsapp.ui.incoming.common.loadIncomingSms

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IncomingScreenV5(
    openDrawer: () -> Unit,
    navigateToThread: (String) -> Unit,
    inHeadLabel: String = "Incoming V5"
)
{
    val context = LocalContext.current
    var messages by remember { mutableStateOf<List<SmsMessage>>(emptyList()) }

    val conversations = remember(messages) { groupBySender(messages) }

    IncomingPermission(context) {
        messages = loadIncomingSms(context)
    }

    Scaffold(
        topBar = {
            AppTopBar(title = inHeadLabel, showBack = false, onMenuClick = openDrawer)
        }
    )
    { padding ->
        Column(Modifier.padding(padding).fillMaxSize()) {

            IncomingConversationListV5(
                conversations = conversations,
                modifier = Modifier.fillMaxSize(),
                onOpenConversation = { address->
                    navigateToThread(address)
                }
            )
        }
    }
}