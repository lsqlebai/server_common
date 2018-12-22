package com.sqluo.common.exception

class DataInvalidException : RuntimeException {
    constructor() {}

    constructor(message: String) : super(message)

    constructor(message: String, cause: Throwable) : super(message, cause)

    constructor(cause: Throwable) : super(cause)
}