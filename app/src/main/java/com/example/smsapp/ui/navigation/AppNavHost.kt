package com.example.smsapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smsapp.AppScreen
import com.example.smsapp.ui.SmsScreen
import com.example.smsapp.ui.inbox.v1.InboxScreenV1
import com.example.smsapp.ui.inbox.v2.InboxScreenV2

@Composable
fun AppNavHost(
    navController: NavHostController,
    openDrawer: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.SendV1.route
    ) {

        composable(AppScreen.SendV1.route) {
            SmsScreen(openDrawer = openDrawer)
        }

        composable(AppScreen.InboxV1.route) {
            InboxScreenV1(openDrawer = openDrawer)
        }

        composable(AppScreen.InboxV2.route) {
            InboxScreenV2(openDrawer = openDrawer)
        }
    }
}