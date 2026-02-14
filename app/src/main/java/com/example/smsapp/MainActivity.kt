package com.example.smsapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController


import androidx.navigation.compose.*
import androidx.compose.material3.*
import com.example.smsapp.ui.InboxScreen
import com.example.smsapp.ui.SmsScreen


class MainActivity : ComponentActivity() {
    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            // Handle permission result if needed
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestSmsPermission()

                setContent {

                    MaterialTheme {

                        val navController = rememberNavController()

                        NavHost(
                            navController = navController,
                            startDestination = "send"
                        ) {

                            composable("send") {
                                SmsScreen(
                                    goToInbox = {
                                        navController.navigate("inbox")
                                    }
                                )
                            }

                            composable("inbox") {
                                InboxScreen(
                                    goBack = {
                                        navController.popBackStack()
                                    }
                                )
                            }
                        }
                    }
                }
    }

    private fun requestSmsPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.SEND_SMS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(Manifest.permission.SEND_SMS)
        }
    }
}
