package com.sqluo.common.utils


import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.sqluo.common.ServerConfig


class UrlJsonDeSerializer : JsonDeserializer<String>() {

    override fun deserialize(parser: JsonParser, context: DeserializationContext): String {
        return parser.getValueAsString(parser.currentName).removePrefix("${ServerConfig.getStaticURL()}/")
    }
}