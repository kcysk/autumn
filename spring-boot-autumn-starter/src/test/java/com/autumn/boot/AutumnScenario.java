package com.autumn.boot;

import com.autumn.core.Scenario;

/**
 * @author shenke
 * @since 2022/11/5 13:08
 */
public enum AutumnScenario implements Scenario {

    BUY("buy");

    private final String code;

    AutumnScenario(String code) {
        this.code = code;
    }


    @Override
    public String getCode() {
        return code;
    }
}
