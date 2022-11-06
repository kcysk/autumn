package com.autumn.core;

import org.jetbrains.annotations.NotNull;

/**
 * @author momo
 * @since 2022/9/19 22:14
 */
@FunctionalInterface
public interface BusinessIdentity {

    /**
     * identity must be unique
     * @return string
     */
    @NotNull
    String getIdentity();
}
