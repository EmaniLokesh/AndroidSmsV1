package com.example.smsapp.ui.sendsms.v3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smsapp.ui.components.AppTopBar
import com.example.smsapp.ui.sendsms.components.SendSmsButton
import com.example.smsapp.ui.sendsms.components.SendSmsFeedback
import com.example.smsapp.ui.sendsms.components.SendSmsInputForMessage
import com.example.smsapp.ui.sendsms.components.SendSmsInputs
import com.example.smsapp.viewmodel.SmsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendSmsScreenV3(
    viewModel: SmsViewModel = viewModel(),
    openDrawer: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()
    val commonHeadLabel="Send SMS V3"

    Scaffold(
        topBar = {
            AppTopBar(
                title = commonHeadLabel,
                showBack = false,
                onMenuClick = openDrawer
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            SendSmsInputs(
                phone = state.phone,
                onPhoneChange = viewModel::updatePhone
            )

            Spacer(modifier = Modifier.height(16.dp))

            SendSmsInputForMessage(
                message = state.message,
                onMessageChange = viewModel::updateMessage
            )

            Spacer(modifier = Modifier.height(24.dp))

            val sending by remember { derivedStateOf { state.isSending } }

            SendSmsButton(
                sending ,
                onSendClick = viewModel::sendSms
            )

            Spacer(modifier = Modifier.height(16.dp))

            SendSmsFeedback(state.status)
        }
    }
}
