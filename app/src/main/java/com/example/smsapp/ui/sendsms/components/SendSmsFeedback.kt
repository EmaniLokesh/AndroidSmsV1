package com.example.smsapp.ui.sendsms.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun SendSmsFeedback(
    status: String?
)
{
    var scatter by remember { mutableStateOf(false) }

    LaunchedEffect(status) {
        if (status?.contains("Success") == true) scatter = true
    }

    LaunchedEffect(scatter) {
        if (scatter) {
            kotlinx.coroutines.delay(1200)
            scatter = false
        }
    }

    if (scatter) {
        androidx.compose.material3.Text(
            text = "🎉 Sent Successfully!",
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
            color = androidx.compose.material3.MaterialTheme.colorScheme.primary
        )
    }
}
