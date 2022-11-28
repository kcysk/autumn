package com.autumn.context.repository;

import com.autumn.core.AutumnException;

/**
 * @author momo
 * @since 2022/10/4 09:33
 */
public class NoUniqueCoordinateException extends AutumnException {

    public NoUniqueCoordinateException(String message) {
        super(message);
    }
}
