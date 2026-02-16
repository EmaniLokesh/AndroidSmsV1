package com.example.smsapp.ui.incoming.v5

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.smsapp.data.SmsMessage
import com.example.smsapp.ui.components.AppTopBar
import com.example.smsapp.ui.incoming.common.loadIncomingSms

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IncomingConversationThreadScreenV5(
    address: String,
    openDrawer: () -> Unit
) {

    val context = LocalContext.current
    var messages by remember { mutableStateOf<List<SmsMessage>>(emptyList()) }

    LaunchedEffect(Unit) {
        messages = loadIncomingSms(context).filter { it.address == address }
    }

    Scaffold(
        topBar = {
            AppTopBar(title = address, showBack = true, onBackClick = openDrawer)
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            items(messages) { sms ->
                Text(
                    text = sms.body,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}