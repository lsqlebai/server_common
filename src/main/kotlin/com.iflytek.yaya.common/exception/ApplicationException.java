package com.iflytek.yaya.common.exception;

/**
 * 定义应用异常
 *
 * @author yangyc
 * @see AppExceptionInfo
 * @since 2018/08/06
 */
public class ApplicationException extends RuntimeException {

    public ApplicationException(String message) {
        super(new AppExceptionInfo(500, message).toString());
    }

    public ApplicationException(String message, Throwable cause) {
        super(new AppExceptionInfo(500, message).toString(), cause);
    }

    public ApplicationException(int errorCode, String message) {
        super(new AppExceptionInfo(errorCode, message).toString());
    }

    public ApplicationException(int errorCode, String message, Throwable cause) {
        super(new AppExceptionInfo(errorCode, message).toString(), cause);
    }

    public ApplicationException(Exception e) {
        super(new AppExceptionInfo(500, e.getMessage()).toString(), e.getCause());
    }

    public ApplicationException(int errorCode, Exception e) {
        super(new AppExceptionInfo(errorCode, e.getMessage()).toString(), e.getCause());
    }
}
