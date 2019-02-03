package com.github.lsqlebai

import java.io.Serializable

interface GlobalResponseCode : Serializable {
    companion object {
        //响应码
        val FAIL_CODE = 800
        val NO_RESPONSE = 805
        val SERVER_ERROR = 500
        val SUCCESS_CODE = 200
        val PAYMENT_FAIL = 205
        val PK_END_CODE = 201
        val NO_DATA_CODE = 404
        val NO_SERVICES_CODE = -404
        val REPEAT_COMMIT = -510
        val INVALID_REQUEST = -100
        val INVALID_TOKEN = -105
        val VALIDATE_LENGTH_CODE = -101
        val VALIDATE_NOT_NULL_CODE = -102
        val VALIDATE_PATTERN_CODE = -103
        val HEATS_NOT_ENOUGH = -201
        val GOLD_NOT_ENOUGH = -202
        val USER_NOT_EXIST = -203
        val PRODUCTID_NOT_FOUND = -204
        val UNICOM_VAS_ERROR = -205
        val PAYORDER_NOT_FOUND = -206
        val REPEAT_CONSUME = -207
        val CANNOT_CONSUME = -208
        val USER_NOT_LOGIN = -209
        val SERVER_MAINTAIN = -300
        val USER_TOKEN_OVERDUE = -301
        val PRODUCT_OVERDUE = -302
        val INVALID_PARAM = -1
        val TOAST_CODE = 1001

        /**
         * 错误消息
         */
        val NO_DATA_MESSAGE = "result is empty"
        val CODE_KEY = "status"
        val MESSAGE_KEY = "message"
        val SALT_KEY = "salt"
        val BODY_KEY = "body"
        val TEST_BODY_KEY = "_body"
        val SERVICE_KEY = "handler"
        val VERSION_KEY = "version"
        val DATA_KEY = "data"
        val TOKEN_KEY = "token"
        val TIME_KEY = "time"
        val TEST_KEY = "test"
        val FORBIDDEN_DEFAULT_MESSAGE = "token_forbidden"
        val TIMEOUT_DEFAULT_MESSAGE = "timeout"
        val SUCCESS_DEFAULT_MESSAGE = "success"
        val FAIL_DEFAULT_MESSAGE = "fail"
        val SERVER_ERROR_MESSAGE = "server internal error"
        val INVALID_REQUEST_MESSAGE = "invalid request"
        val NO_SERVICES_MESSAGE = "can't find handler"
        val USER_NOT_LOGIN_MESSAGE = "用户登录状态异常，请尝试重新打开应用"

        val E_KEY = "75HVYG0VQVDEYPLLODZUX99ZCV333EKY"
    }

}