package com.example.smsapp.data

import android.content.Context
import android.provider.Telephony
import java.text.SimpleDateFormat
import java.util.*

class SmsReaderRepository(private val context: Context) {

    fun getInboxMessages(): List<SmsMessage> {

        val smsList = mutableListOf<SmsMessage>()

        val cursor = context.contentResolver.query(
            Telephony.Sms.Inbox.CONTENT_URI,
            null,
            null,
            null,
            Telephony.Sms.DEFAULT_SORT_ORDER
        )

        cursor?.use {

            val addressIndex = it.getColumnIndex(Telephony.Sms.ADDRESS)
            val bodyIndex = it.getColumnIndex(Telephony.Sms.BODY)
            val dateIndex = it.getColumnIndex(Telephony.Sms.DATE)

            while (it.moveToNext()) {

                val address = it.getString(addressIndex)
                val body = it.getString(bodyIndex)
                val dateMillis = it.getLong(dateIndex)

                val formattedDate = SimpleDateFormat(
                    "dd MMM yyyy, hh:mm a",
                    Locale.getDefault()
                ).format(Date(dateMillis))

                smsList.add(
                    SmsMessage(
                        address = address,
                        body = body,
                        date = formattedDate
                    )
                )
            }
        }

        return smsList
    }
}