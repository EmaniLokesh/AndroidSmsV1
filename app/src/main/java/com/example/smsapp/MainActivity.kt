package com.example.smsapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.*
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController


import androidx.navigation.compose.*
import com.example.smsapp.ui.inbox.v1.InboxScreenV1
import com.example.smsapp.ui.SmsScreen
import com.example.smsapp.ui.inbox.v2.InboxScreenV2


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
                                    },
                                    goToInboxV2 = {
                                        navController.navigate("inbox_v2")
                                    }
                                )
                            }

                            composable("inbox") {
                                InboxScreenV1(
                                    goBack = {
                                        navController.popBackStack()
                                    }
                                )
                            }

                            composable("inbox_v2") {
                                InboxScreenV2(
                                    goBack = { navController.popBackStack() }
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
