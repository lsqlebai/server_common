package com.github.lsqlebai.utils

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.IOException

/**
 * 基于jackson的基本json格式化工具
 * FastJsonSerializerFeatureCompatibleForJackson 定义了序列化的处理规则
 */
object JsonUtils {

    private val objectMapper: ObjectMapper = ObjectMapper()

    init {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        //objectMapper.serializerFactory = objectMapper.serializerFactory.withSerializerModifier(UrlSerializerModifier())
    }

    @Throws(JsonProcessingException::class)
    fun obj2Str(o: Any): String {
        return objectMapper.writeValueAsString(o)
    }

    @Throws(IOException::class)
    fun <T> str2Obj(str: String, valueType: Class<T>): T {
        return objectMapper.readValue(str, valueType)
    }

}
