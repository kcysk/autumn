package com.autumn.boot;

import com.autumn.core.Plugin;
import com.autumn.core.annotations.Extension;
import com.autumn.core.annotations.Grid;

/**
 * @author shenke
 * @since 2022/11/5 13:06
 */
@Extension(coordinates = {
        @Grid(scenario = "buy", businessIdentity = {"common"})
})
public class AccountValidatePlugin extends GenericAbility {

    public void validatePassword() {

    }
}
