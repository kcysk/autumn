package com.autumn.context.support.repository;

import com.autumn.core.Scenario;
import org.jetbrains.annotations.NotNull;

/**
 * @author shenke
 * @since 2022/11/5 13:50
 */
public enum CommonScenario implements Scenario {

    ONE("one"),
    TWO("two")
    ;

    private final String code;

    CommonScenario(String code) {
        this.code = code;
    }


    @Override
    public @NotNull String getCode() {
        return code;
    }
}
