package com.example.smsapp

sealed class AppScreen(
    val route: String,
    val title: String
) {
    // Send Screens
    object SendV1 : AppScreen("send_v1", "Send V1")
    object SendV2 : AppScreen("send_v2", "Send V2")
    object SendV3 : AppScreen("send_v3", "Send V3")
    object SendV4 : AppScreen("send_v4", "Send V4")

    // Inbox Screens
    object InboxV1 : AppScreen("inbox_v1", "Inbox V1")
    object InboxV2 : AppScreen("inbox_v2", "Inbox V2")

    // Inbox Screens for Incoming
    object InboxIncomingV1 : AppScreen("inbox_incoming_v1", "Incoming V1")
    object InboxIncomingV2 : AppScreen("inbox_incoming_v2", "Incoming V2")
    object InboxIncomingV3 : AppScreen("inbox_incoming_v3", "Incoming V3")
    object InboxIncomingV4 : AppScreen("inbox_incoming_v4", "Incoming V4")
    object InboxIncomingV5 : AppScreen("inbox_incoming_v5", "Incoming V5")
    object InboxIncomingV6 : AppScreen("inbox_incoming_v6", "Incoming V6")

    // Inbox Screens for Outgoing
    object OutgoingV1 : AppScreen("outgoing_v1", "Outgoing V1")
    object OutgoingV2 : AppScreen("outgoing_v2", "Outgoing V2")
    object OutgoingV3 : AppScreen("outgoing_v3", "Outgoing V3")
    object OutgoingV4 : AppScreen("outgoing_v4", "Outgoing V4")
    object OutgoingV5 : AppScreen("outgoing_v5", "Outgoing V5")
    object OutgoingV6 : AppScreen("outgoing_v6", "Outgoing V6")

    companion object {

        // Grouped drawer structure
        val drawerStructure: List<DrawerSection>
            get() = listOf(

                DrawerSection(
                    title = "Send",
                    children = listOf(SendV1, SendV2, SendV3, SendV4)
                ),

                DrawerSection(
                    title = "Inbox",
                    children = listOf(InboxV1, InboxV2)
                ),

                DrawerSection(
                    title = "Incoming",
                    children = listOf(InboxIncomingV1, InboxIncomingV2, InboxIncomingV3, InboxIncomingV4,
                        InboxIncomingV5, InboxIncomingV6)
                ),

                DrawerSection(
                    title = "Outgoing",
                    children = listOf(
                        OutgoingV1, OutgoingV2, OutgoingV3, OutgoingV4, OutgoingV5,
                        OutgoingV6
                    )
                )
            )
    }
}

data class DrawerSection(
    val title: String,
    val children: List<AppScreen>
)