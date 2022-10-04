package com.autumn.context.support.exception;

/**
 * @author momo
 * @since 2022/10/4 09:35
 */
public class AutumnException extends RuntimeException {

    public AutumnException() {
    }

    public AutumnException(String message) {
        super(message);
    }

    public AutumnException(String message, Throwable cause) {
        super(message, cause);
    }

    public AutumnException(Throwable cause) {
        super(cause);
    }

    public AutumnException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
