package com.autumn.core;

import org.jetbrains.annotations.NotNull;

/**
 * scenario interface
 * @author momo
 * @since 2022/9/19 22:11
 */
@FunctionalInterface
public interface Scenario {

    /**
     * scenario code, must be unique
     * @return string
     */
    @NotNull
    String getCode();
}
