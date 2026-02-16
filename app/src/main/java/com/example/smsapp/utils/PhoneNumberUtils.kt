package com.example.smsapp.utils

fun normalizeAddress(address: String?): String {

    if (address.isNullOrBlank())
        return "Unknown"

    var num = address.replace("\\s|-".toRegex(), "")

    if (num.startsWith("+91")) num = num.substring(3)
    if (num.startsWith("0091")) num = num.substring(4)

    if (num.length > 10)
        num = num.takeLast(10)

    return num
}