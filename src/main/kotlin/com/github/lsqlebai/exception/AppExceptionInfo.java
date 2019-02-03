package com.github.lsqlebai.exception;

import com.github.lsqlebai.GlobalResponseCode;

public class AppExceptionInfo extends RuntimeException {
    private int errorCode;
    private String message;

    public AppExceptionInfo() {
    }

    public AppExceptionInfo(String message) {
        this.errorCode = GlobalResponseCode.Companion.getFAIL_CODE();
        this.message = message;
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
