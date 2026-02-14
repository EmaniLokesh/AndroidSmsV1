package com.example.smsapp

sealed class AppScreen(
    val route: String,
    val title: String
) {

    // Send Screens
    object SendV1 : AppScreen("send_v1", "Send V1")
    object SendV2 : AppScreen("send_v2", "Send V2")

    // Inbox Screens
    object InboxV1 : AppScreen("inbox_v1", "Inbox V1")
    object InboxV2 : AppScreen("inbox_v2", "Inbox V2")

    companion object {

        // Grouped drawer structure
        val drawerStructure: List<DrawerSection>
            get() = listOf(

                DrawerSection(
                    title = "Send",
                    children = listOf(SendV1, SendV2)
                ),

                DrawerSection(
                    title = "Inbox",
                    children = listOf(InboxV1, InboxV2)
                )
            )
    }
}

data class DrawerSection(
    val title: String,
    val children: List<AppScreen>
)