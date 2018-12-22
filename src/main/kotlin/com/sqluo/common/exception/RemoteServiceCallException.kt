package com.sqluo.common.exception

/**
 * 远程调用异常类
 * @author yangyc
 * @since 2018/08/05
 */
class RemoteServiceCallException : RuntimeException {
    // 远程调用的路径
    var host_path: String? = null
    // 远程调用的响应码
    var status_code: Int? = null
    // 远程调用的响应消息
    var error_msg: String? = null

    constructor(host_path: String, error_msg: String, status_code: Int) : super("host_path=$host_path;error_msg=$error_msg") {
        this.status_code = status_code
        this.host_path = host_path
        this.error_msg = error_msg
    }

    constructor(host_path: String, error_msg: String, status_code: Int, cause: Throwable) : super("host_path=$host_path;error_msg=$error_msg", cause) {
        this.status_code = status_code
        this.host_path = host_path
        this.error_msg = error_msg
    }
}