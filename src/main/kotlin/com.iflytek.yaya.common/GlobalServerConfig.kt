package com.iflytek.yaya.common

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
open class GlobalServerConfig {
    @Value("\${baseStaticResUrl}")
    lateinit var baseStaticResUrl: String
    @Value("\${staticResPath}")
    lateinit var staticResPath: String
    @Value("\${parent.binding.children.size}")
    lateinit var parentBindingSize: Integer
    @Value("\${teacher.binding.class.size}")
    lateinit var teacherBindingSize: Integer


    val tmpPath: String
        get() {
            return "$staticResPath/tmp"
        }
    val soundPath: String = "soundPath"
    val soundSuffix = ".mp3"
}