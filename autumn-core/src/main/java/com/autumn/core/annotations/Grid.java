package com.autumn.core.annotations;

/**
 *
 * @author momo
 * @since 2022/9/19 23:15
 */
public @interface Grid {

    /**
     * scenario
     */
    String scenario();


    /**
     * business identity
     */
    String[] businessIdentity();
}
