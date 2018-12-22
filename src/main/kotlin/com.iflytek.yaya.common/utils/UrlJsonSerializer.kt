package com.iflytek.yaya.common.utils

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.iflytek.yaya.common.GlobalServerConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.getBean

class UrlJsonSerializer : JsonSerializer<String>() {

    @Autowired
    lateinit var config:GlobalServerConfig

    init {
        config = SpringContextUtil.getContext().getBean(GlobalServerConfig::class)
    }

    override fun serialize(value: String, gen: JsonGenerator, serializers: SerializerProvider) {
        if (!value.startsWith("http") && value.isNotBlank()) {
            gen.writeString("${config.baseStaticResUrl}/$value")
        } else {
            gen.writeString(value)
        }
    }
}