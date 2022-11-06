package com.autumn.context.support.repository;

import com.autumn.core.BusinessIdentity;
import org.jetbrains.annotations.NotNull;

/**
 * @author shenke
 * @since 2022/11/5 13:52
 */
public enum CommonBusinessIdentity implements BusinessIdentity {

    DIRECT("direct"),


    SECOND("second"),

    MULITI("mulity");

    private final String code;

    CommonBusinessIdentity(String code) {
        this.code = code;
    }

    @Override
    public @NotNull String getIdentity() {
        return code;
    }


}
