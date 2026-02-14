package com.example.smsapp.ui.inbox.v2

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smsapp.data.SmsMessage
import com.example.smsapp.ui.components.AppTopBar
import com.example.smsapp.viewmodel.InboxViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InboxScreenV2(
    viewModel: InboxViewModel = viewModel(),
    openDrawer: () -> Unit
) {
    val context = LocalContext.current

    var groupedMessages by remember { mutableStateOf<Map<String, List<SmsMessage>>>(emptyMap()) }

    val permissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                groupedMessages = viewModel.getGroupedMessages()
            }
        }

    LaunchedEffect(Unit) {
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_SMS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            groupedMessages = viewModel.getGroupedMessages()
        } else {
            permissionLauncher.launch(Manifest.permission.READ_SMS)
        }
    }

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Inbox V2",
                showBack = false,
                onMenuClick = openDrawer
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            items(groupedMessages.entries.toList()) { entry  ->
                val address = entry.key
                val messages = entry.value
                val latestMessage = messages.first()

                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {

                        Text(
                            text = address,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "${messages.size} messages",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = latestMessage.body,
                            style = MaterialTheme.typography.labelSmall,
                            maxLines = 1
                        )
                    }
                }

            }
        }
    }
}