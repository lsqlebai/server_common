package com.github.lsqlebai.base

import com.github.lsqlebai.GlobalResponseCode
import com.github.lsqlebai.GlobalResponseCode.Companion.SUCCESS_CODE
import com.github.lsqlebai.GlobalResponseCode.Companion.SUCCESS_DEFAULT_MESSAGE


open class BaseResponse : GlobalResponseCode {
    var code: Int? = null
    var message: String? = null
    var token: String? = null
    var salt: String? = null
    var data: String? = null
    var data_test: String? = null

    companion object {

        private val serialVersionUID = -1964760354861862181L
        fun success(): BaseResponse {
            return BaseResponse().apply {
                code = SUCCESS_CODE
                message = SUCCESS_DEFAULT_MESSAGE
            }
        }

        fun <T> success(data: String): BaseResponse {
            return BaseResponse().apply {
                code = SUCCESS_CODE
                message = SUCCESS_DEFAULT_MESSAGE
                this.data = data
            }
        }

        fun fail(returnCode: Int?, returnMsg: String): BaseResponse {
            return BaseResponse().apply {
                code = returnCode
                message = returnMsg
            }
        }
    }

}