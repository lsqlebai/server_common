package com.github.lsqlebai.utils


import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.github.lsqlebai.ServerConfig


class UrlJsonDeSerializer : JsonDeserializer<String>() {

    override fun deserialize(parser: JsonParser, context: DeserializationContext): String {
        return parser.getValueAsString(parser.currentName).removePrefix("${ServerConfig.getStaticURL()}/")
    }
}