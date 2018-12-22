package com.sqluo.common.utils

class FormatTime {
    var days: Int = 0
    var hours: Int = 0
    var minutes: Int = 0

    companion object {
        fun formatDuring(second: Int): FormatTime {
            val hours = (second % (60 * 60 * 24)) / (60 * 60)
            val minutes = (second % (60 * 60)) / 60
            val days = second / (60 * 60 * 24)
            return FormatTime().apply {
                this.hours = hours
                this.minutes = minutes
                this.days = days
            }
        }
    }

    fun getMinutesFormat() : String {
        val sb = StringBuilder()
        if (days > 0) {
            sb.append(days).append("天")
        }
        if (hours > 0) {
            sb.append(days).append("小时")
        }
        if (minutes >= 0) {
            sb.append(minutes).append("分钟")
        }
        return sb.toString()
    }


}