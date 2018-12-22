package com.sqluo.common.utils

import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.getOrSet


object DateUtils {
    var shortFormat: ThreadLocal<SimpleDateFormat> = ThreadLocal()
    var normalFormat: ThreadLocal<SimpleDateFormat> = ThreadLocal()
    fun getCurrentZeroDay(): Date {
        val calendar = Calendar.getInstance()
        calendar.time = Date()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.time
    }

    fun getYesterdayZero(): Date {
        val calendar = Calendar.getInstance()
        calendar.time = Date()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        calendar.add(Calendar.DATE, -1)

        return calendar.time
    }

    fun getYesterday(): Date {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -1)
        return calendar.time
    }


    fun getYesterdayStr(): String {
        return shortFormat.getOrSet { SimpleDateFormat("yyyyMMdd") }.format(getYesterday())
    }

    fun getTodayStr(): String {
        return normalFormat.getOrSet { SimpleDateFormat("yyyy-MM-dd") }.format(Date())
    }

    fun getDateStr(date: Date): String {
        return normalFormat.getOrSet { SimpleDateFormat("yyyy-MM-dd") }.format(date)
    }

    fun getSimpleDateStr(date: Date): String {
        return shortFormat.getOrSet { SimpleDateFormat("yyyyMMdd") }.format(date)
    }

    fun createBySimpleDate(date: String): Date {
        return normalFormat.getOrSet { SimpleDateFormat("yyyy-MM-dd") }.parse(date)
    }

    fun createByShortDate(date: String): Date {
        return shortFormat.getOrSet { SimpleDateFormat("yyyyMMdd") }.parse(date)
    }
}

fun main(args: Array<String>) {
    DateUtils.getTodayStr()
}