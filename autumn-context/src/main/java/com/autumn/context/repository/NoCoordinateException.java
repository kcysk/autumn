package com.autumn.context.repository;

import com.autumn.core.AutumnException;

/**
 * @author momo
 * @since 2022/10/4 09:35
 */
public class NoCoordinateException extends AutumnException {

    public NoCoordinateException(String message) {
        super(message);
    }
}
