package com.example.smsapp.ui.outgoing.v1

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smsapp.ui.components.AppTopBar
import com.example.smsapp.viewmodel.InboxViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutgoingScreenV1(
    viewModel: InboxViewModel = viewModel(),
    openDrawer: () -> Unit
) {
    val context = LocalContext.current
    val messages by viewModel.messages.collectAsState()
val commonHeadLabel="Outgoing V1"

    val permissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                viewModel.loadOutgoingMessages(context)
            }
        }

    LaunchedEffect(Unit) {
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_SMS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            viewModel.loadOutgoingMessages(context)
        } else {
            permissionLauncher.launch(Manifest.permission.READ_SMS)
        }
    }

    Scaffold(
        topBar = {
            AppTopBar(
                title = commonHeadLabel,
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

            items(messages) { sms ->

                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {

                        Text(
                            text = sms.address,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = sms.body,
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = sms.date,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
            }
        }
    }
}