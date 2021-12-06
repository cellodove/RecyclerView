package com.cellodove.recyclerview.extension

import android.content.Context
import android.os.Build
import java.text.SimpleDateFormat
import java.util.*

fun TimeZone.timeOffset() = (rawOffset + dstSavings) / 1000
fun TimeZone.dstOffset() = dstSavings / 1000

fun Context.appVersionName(): String {
    return try {
        packageManager?.getPackageInfo(packageName, 0)?.versionName ?: ""
    } catch (e: Exception) {
        ""
    }
}

@Suppress("DEPRECATION")
fun Context.currentLocale(): Locale {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        resources.configuration.locales.get(0)
    } else {
        resources.configuration.locale
    }
}

@Suppress("DEPRECATION")
fun Context.currentLanguageCode(): String {
    return when (currentLocale()) {
        Locale.KOREA -> "KO"
        Locale.GERMAN -> "DE"
        else -> "EN"
    }
}

fun String.parseDateFormat(from: String = "yyyyMMddHHmmss", to: String): String {
    return try {
        val date = SimpleDateFormat(from, Locale.getDefault()).parse(this) ?: Date()
        SimpleDateFormat(to, Locale.getDefault()).format(date)
    } catch (e: Exception) {
        this
    }
}

fun Long.parseDateFormat(format: String): String = SimpleDateFormat(format, Locale.getDefault()).format(Date(this))

fun ByteArray.toHexString() = joinToString(" ") { "%02x".format(it).uppercase() }
