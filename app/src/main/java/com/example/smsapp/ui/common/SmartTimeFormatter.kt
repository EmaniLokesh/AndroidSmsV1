package com.example.smsapp.ui.common

import java.text.SimpleDateFormat
import java.util.*

object SmartTimeFormatter {

    fun format(timestamp: Long): String {

        val msg = Calendar.getInstance().apply { timeInMillis = timestamp }
        val now = Calendar.getInstance()

        val yesterday = now.clone() as Calendar
        yesterday.add(Calendar.DAY_OF_YEAR, -1)

        return when {
            sameDay(msg, now) ->
                "Today " + SimpleDateFormat("hh:mm a", Locale.getDefault()).format(msg.time)

            sameDay(msg, yesterday) ->
                "Yesterday " + SimpleDateFormat("hh:mm a", Locale.getDefault()).format(msg.time)

            now.get(Calendar.YEAR) == msg.get(Calendar.YEAR) ->
                SimpleDateFormat("EEE, hh:mm a", Locale.getDefault()).format(msg.time)

            else ->
                SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault()).format(msg.time)
        }
    }

    private fun sameDay(a: Calendar, b: Calendar) =
        a.get(Calendar.YEAR) == b.get(Calendar.YEAR) &&
                a.get(Calendar.DAY_OF_YEAR) == b.get(Calendar.DAY_OF_YEAR)
}