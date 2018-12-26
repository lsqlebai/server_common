package com.github.lsqlebai.exception;

public class TokenValidationException extends RuntimeException {
    public TokenValidationException() {
    }

    public TokenValidationException(String message) {
        super(message);
    }

    public TokenValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenValidationException(Throwable cause) {
        super(cause);
    }

    public TokenValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
//        super(message, cause, enableSuppression, writableStackTrace);
//        super();
    }
}

