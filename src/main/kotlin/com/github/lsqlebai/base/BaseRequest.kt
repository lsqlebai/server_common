package com.github.lsqlebai.base

import javax.validation.constraints.NotBlank


open class BaseRequest {

    /**服务版本 */
    var version: String? = null
    /**时间 ms */
    @NotBlank(message = "不能为空")
    var time: String? = null
    /**加密请求数据 */
    @NotBlank(message = "不能为空")
    var data: String? = null
    /**登录用户token */

    var accessToken: String? = null
    /**盐值 */
    @NotBlank(message = "不能为空")
    var salt: String? = null
    /**测试开关 */
    var test: Boolean = false

    var data_test: String? = null
    override fun toString(): String {
        return "BaseRequest(version=$version, time=$time, data=$data, accessToken=$accessToken, salt=$salt, test=$test)"
    }
}