package com.autumn.context.support.repository;

import com.autumn.core.Plugin;
import com.autumn.core.annotations.Extension;
import com.autumn.core.annotations.Grid;

/**
 * @author shenke
 * @since 2022/11/5 13:28
 */
@Extension(coordinates = {
        @Grid(scenario = "buy", businessIdentity = {"ylsy", "generial"})
})
public class DirectPluginImpl implements ValidatePasswordPlugin {
}
