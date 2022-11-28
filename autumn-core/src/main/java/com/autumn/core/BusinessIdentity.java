package com.autumn.core;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * @author momo
 * @since 2022/9/19 22:14
 */
@FunctionalInterface
public interface BusinessIdentity extends Serializable {

    /**
     * identity must be unique
     * @return string
     */
    @NotNull
    String getIdentity();
}
