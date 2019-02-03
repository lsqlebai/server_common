package com.github.lsqlebai.base

import com.github.lsqlebai.GlobalResponseCode
import com.github.lsqlebai.GlobalResponseCode.Companion.SUCCESS_CODE
import com.github.lsqlebai.GlobalResponseCode.Companion.SUCCESS_DEFAULT_MESSAGE
import com.github.lsqlebai.utils.Des3Utils
import com.github.lsqlebai.utils.DigestUtils
import com.github.lsqlebai.utils.JsonUtils
import com.github.lsqlebai.utils.UUIDUtils
import java.util.*


open class BaseResponse : GlobalResponseCode {
    var status: Int? = null
    var message: String? = null
    var token: String? = null
    var salt: String? = null
    var data: String? = null
    var data_test: Any? = null
    val timestamp = Date()
    companion object {

        private val serialVersionUID = -1964760354861862181L
        fun success(): BaseResponse {
            return BaseResponse().apply {
                status = SUCCESS_CODE
                message = SUCCESS_DEFAULT_MESSAGE
            }
        }

        fun <T> success(data: String): BaseResponse {
            return BaseResponse().apply {
                status = SUCCESS_CODE
                message = SUCCESS_DEFAULT_MESSAGE
                this.data = data
            }
        }

        fun fail(returnCode: Int?, returnMsg: String): BaseResponse {
            return BaseResponse().apply {
                status = returnCode
                message = returnMsg
            }
        }

        fun encode(eKey: String, isTest: Boolean, raw: Any): BaseResponse {
            //1.对返回数据 body部分进行加密

            val baseResponse = BaseResponse()
            val salt = UUIDUtils.sn(6)
            baseResponse.salt = salt
            baseResponse.data = DigestUtils.encodeBase64(Des3Utils.des3EncodeECB(DigestUtils.getMD5(salt + eKey), JsonUtils.obj2Str(raw)))
            if (isTest) {
                baseResponse.data_test = raw
            }
            baseResponse.status = SUCCESS_CODE
            baseResponse.message = SUCCESS_DEFAULT_MESSAGE
            return baseResponse
        }
    }

}