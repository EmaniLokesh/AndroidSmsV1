package com.example.smsapp.ui.incoming.v5

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.smsapp.ui.incoming.common.IncomingTimeGroup

@Composable
fun IncomingTabsV5(
    selected: IncomingTimeGroup,
    counts: Map<IncomingTimeGroup, Int>,
    onSelected: (IncomingTimeGroup) -> Unit
) {

    val tabs = listOf(
        IncomingTimeGroup.TODAY to "Today",
        IncomingTimeGroup.YESTERDAY to "Yesterday",
        IncomingTimeGroup.THIS_WEEK to "This Week",
        IncomingTimeGroup.OLDER to "Older"
    )

    TabRow(selectedTabIndex = tabs.indexOfFirst { it.first == selected }) {

        tabs.forEachIndexed { index, pair ->
            val group = pair.first
            val title = "${pair.second} (${counts[group] ?: 0})"

            Tab(
                selected = selected == group,
                onClick = { onSelected(group) },
                text = { Text(title) }
            )
        }
    }
}