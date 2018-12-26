package com.github.lsqlebai.exception;

public class ParameterValidationException extends RuntimeException {
    public ParameterValidationException() {
    }

    public ParameterValidationException(String message) {
        super(message);
    }

    public ParameterValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterValidationException(Throwable cause) {
        super(cause);
    }

    public ParameterValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
//        super(message, cause, enableSuppression, writableStackTrace);
//        super();
    }
}

