package com.example.smsapp.ui.outgoing.v3

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smsapp.ui.common.SmsPermissionLoader
import com.example.smsapp.ui.components.AppTopBar
import com.example.smsapp.ui.outgoing.components.OutgoingMessageList
import com.example.smsapp.ui.outgoing.components.OutgoingTabs
import com.example.smsapp.viewmodel.InboxViewModel
import com.example.smsapp.viewmodel.TimeGroup

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutgoingScreenV3(
    viewModel: InboxViewModel = viewModel(),
    openDrawer: () -> Unit,
    inHeadLabel: String = "Outgoing V3"
) {
    val grouped by viewModel.grouped.collectAsState()
    var tab by remember { mutableStateOf(TimeGroup.TODAY) }

    SmsPermissionLoader(onGranted = { viewModel.loadOutgoingMessages(it) }) {
        // existing Scaffold here

    Scaffold(
        topBar = {
            AppTopBar(
                title = inHeadLabel,
                showBack = false,
                onMenuClick = openDrawer
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            OutgoingTabs(
                selected = tab,
                onSelected = { tab = it }
            )

            OutgoingMessageList(
                messages = grouped[tab] ?: emptyList()
            )
        }
    }
    }
}
