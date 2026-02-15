package com.example.smsapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smsapp.AppScreen
import com.example.smsapp.ui.sendsms.v1.SendSmsScreenV1
import com.example.smsapp.ui.inbox.v1.InboxScreenV1
import com.example.smsapp.ui.inbox.v2.InboxScreenV2
import com.example.smsapp.ui.incoming.v1.IncomingScreenV1
import com.example.smsapp.ui.outgoing.v1.OutgoingScreenV1
import com.example.smsapp.ui.sendsms.v2.SendSmsScreenV2
import com.example.smsapp.ui.sendsms.v3.SendSmsScreenV3

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
            SendSmsScreenV1(openDrawer = openDrawer)
        }

        composable(AppScreen.SendV2.route) {
            SendSmsScreenV2(openDrawer = openDrawer)
        }

        composable(AppScreen.SendV3.route) {
            SendSmsScreenV3(openDrawer = openDrawer)
        }

        composable(AppScreen.InboxV1.route) {
            InboxScreenV1(openDrawer = openDrawer)
        }

        composable(AppScreen.InboxV2.route) {
            InboxScreenV2(openDrawer = openDrawer)
        }

        composable(AppScreen.InboxIncomingV1.route) {
            IncomingScreenV1(openDrawer = openDrawer)
        }

        composable(AppScreen.OutgoingV1.route) {
            OutgoingScreenV1(openDrawer = openDrawer)
        }

    }
}