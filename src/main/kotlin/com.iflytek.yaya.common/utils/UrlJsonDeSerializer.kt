package com.iflytek.yaya.common.utils


import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.iflytek.yaya.common.GlobalServerConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.getBean

class UrlJsonDeSerializer : JsonDeserializer<String>() {

    @Autowired
    lateinit var config:GlobalServerConfig

    init {
        config = SpringContextUtil.getContext().getBean(GlobalServerConfig::class)
    }

    override fun deserialize(parser: JsonParser, context: DeserializationContext): String {
        return parser.getValueAsString(parser.currentName).removePrefix("${config.baseStaticResUrl}/")
    }
}