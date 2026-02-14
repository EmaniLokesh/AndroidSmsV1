package com.example.smsapp


import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.smsapp.ui.SmsScreen
import com.example.smsapp.ui.inbox.v1.InboxScreenV1
import com.example.smsapp.ui.inbox.v2.InboxScreenV2
import kotlinx.coroutines.launch
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp

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
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(MaterialTheme.colorScheme.primary)
                                            .padding(24.dp)
                                    ) {
                                        Text(
                                            text = "SMS App",
                                            style = MaterialTheme.typography.titleLarge,
                                            color = MaterialTheme.colorScheme.onPrimary
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(8.dp))

                                    val currentBackStackEntry by navController.currentBackStackEntryAsState()
                                    val currentRoute = currentBackStackEntry?.destination?.route ?: ""

                                    AppScreen.drawerItems.forEach { screen ->
                                        NavigationDrawerItem(
                                            label = { Text(screen.title) },
                                            selected = currentRoute == screen.route,
                                            onClick = {
                                                navController.navigate(screen.route)
                                                scope.launch { drawerState.close() }
                                            },
                                            colors = NavigationDrawerItemDefaults.colors(
                                                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                                selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                                selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer
                                            )
                                        )
                                    }
                                }
                            }
                        ) {
                            NavHost(
                                navController = navController,
                                startDestination = AppScreen.Send.route
                            ) {
                                composable(AppScreen.Send.route){
                                    SmsScreen(
                                        openDrawer = {
                                            scope.launch { drawerState.open() }
                                        }
                                    )
                                }

                                composable(AppScreen.InboxV1.route) {
                                    InboxScreenV1(
                                        openDrawer = {
                                            scope.launch { drawerState.open() }
                                        })
                                }

                                composable(AppScreen.InboxV2.route) {
                                    InboxScreenV2(
                                        openDrawer = {
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
