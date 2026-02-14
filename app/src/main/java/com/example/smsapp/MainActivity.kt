package com.example.smsapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController


import androidx.navigation.compose.*
import com.example.smsapp.ui.inbox.v1.InboxScreenV1
import com.example.smsapp.ui.SmsScreen
import com.example.smsapp.ui.inbox.v2.InboxScreenV2
import kotlinx.coroutines.launch


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


                        val drawerState = rememberDrawerState(DrawerValue.Closed)
                        val scope = rememberCoroutineScope()

                        ModalNavigationDrawer(
                            drawerState = drawerState,
                            drawerContent = {
                                ModalDrawerSheet {

                                    Text(
                                        text = "Menu",
                                        style = MaterialTheme.typography.titleMedium,
                                        modifier = Modifier.padding(16.dp)
                                    )

                                    NavigationDrawerItem(
                                        label = { Text("Send SMS") },
                                        selected = false,
                                        onClick = {
                                            navController.navigate("send")
                                            scope.launch { drawerState.close() }
                                        }
                                    )

                                    NavigationDrawerItem(
                                        label = { Text("Inbox V1") },
                                        selected = false,
                                        onClick = {
                                            navController.navigate("inbox")
                                            scope.launch { drawerState.close() }
                                        }
                                    )

                                    NavigationDrawerItem(
                                        label = { Text("Inbox V2") },
                                        selected = false,
                                        onClick = {
                                            navController.navigate("inbox_v2")
                                            scope.launch { drawerState.close() }
                                        }
                                    )
                                }
                            }
                        ) {
                            NavHost(
                                navController = navController,
                                startDestination = "send"
                            ) {
                                composable("send") {
                                    SmsScreen(
                                        openDrawer = {
                                            scope.launch { drawerState.open() }
                                        }
                                    )
                                }

                                composable("inbox") {
                                    InboxScreenV1(
                                        openDrawer = {
                                            scope.launch { drawerState.open() }
                                        })
                                }

                                composable("inbox_v2") {
                                    InboxScreenV2(                                        openDrawer = {
                                        scope.launch { drawerState.open() }
                                    })
                                }
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
