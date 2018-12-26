package com.sqluo.common.exception;

/**
 * 异常信息
 * @author yangyc
 * @since 2018/08/06
 * @see ApplicationException
 */
public class AppExceptionInfo {
    private int errorCode;
    private String message;

    public AppExceptionInfo() {
    }

    public AppExceptionInfo(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "\"errorCode\":" + errorCode +
                ", \"message\":\"" + message +
                "\"}";
    }
}
