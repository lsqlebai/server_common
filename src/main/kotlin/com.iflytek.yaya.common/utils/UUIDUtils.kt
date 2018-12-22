package com.iflytek.yaya.common.utils

import java.math.BigInteger
import java.util.*

object UUIDUtils {


    fun uuid(): String {
        val uuid = UUID.randomUUID()
        val str = uuid.toString()
        // 去掉"-"符号
        val temp: String
        temp = str.replace("-".toRegex(), "")
        return temp
    }

    fun sn(): String {
        val uuid = uuid()
        val longSn = BigInteger(uuid, 16).toString()
        return longSn.substring(0, 12)
    }

    fun sn(num: Int): String {
        val uuid = uuid()
        val longSn = BigInteger(uuid, 16).toString()
        return longSn.substring(0, num)
    }
}
