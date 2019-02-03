package com.github.lsqlebai.base

import com.github.lsqlebai.utils.Des3Utils
import com.github.lsqlebai.utils.DigestUtils
import com.github.lsqlebai.utils.JsonUtils
import org.omg.CORBA.Object


open class BaseRequest {

    /**服务版本 */
    var version: String? = null
    /**时间 ms */
    var time: String? = null
    /**加密请求数据 */
    var data: String? = null
    /**登录用户token */

    var accessToken: String? = null
    /**盐值 */
    var salt: String? = null
    /**测试开关 */
    var test: Boolean = false

    var raw: String? = null
    var channel: String? =null
    var method: String = "GET"
    override fun toString(): String {
        return "BaseRequest(version=$version, time=$time, data=$data, accessToken=$accessToken, salt=$salt, test=$test, method=$method)"
    }

    companion object {
        @Throws(Exception::class)
        fun decodeData(body: String, eKey: String, isTest: Boolean): BaseRequest {
            val baseRequest = JsonUtils.str2Obj(body, BaseRequest::class.java)
            if (baseRequest.data != null) {
                var decodeData = baseRequest.data!!.toByteArray(Charsets.UTF_8)
                if (!baseRequest.test || !isTest) {
                    decodeData = DigestUtils.decodeBase64(decodeData)
                    decodeData = Des3Utils.des3DecodeECB(DigestUtils.getMD5(baseRequest.salt + eKey), decodeData)
                    baseRequest.raw = String(decodeData, Charsets.UTF_8)
                }
            }
            return baseRequest
        }
    }

}