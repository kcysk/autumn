package com.autumn.core;

/**
 * @author momo
 * @since 2022.11.28
 */
public class AutumnException extends RuntimeException {

    public AutumnException(String message) {
        super(message);
    }

    public AutumnException(String message, Throwable cause) {
        super(message, cause);
    }

    public AutumnException(Throwable cause) {
        super(cause);
    }

    protected AutumnException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
