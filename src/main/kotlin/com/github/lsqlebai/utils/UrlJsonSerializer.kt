package com.github.lsqlebai.utils

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.github.lsqlebai.ServerConfig


class UrlJsonSerializer : JsonSerializer<String>() {

    override fun serialize(value: String, gen: JsonGenerator, serializers: SerializerProvider) {
        if (!value.startsWith("http") && value.isNotBlank()) {
            gen.writeString("${ServerConfig.getStaticURL()}/$value")
        } else {
            gen.writeString(value)
        }
    }
}