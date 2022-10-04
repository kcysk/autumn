package com.autumn.boot;

import com.autumn.context.support.repository.ExtensionRepository;
import com.sun.source.util.Plugin;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * @author momo
 * @since 2022/10/4 09:42
 */
public class AutumnBootstrap {

    private ApplicationContext applicationContext;

    private ExtensionRepository extensionRepository;

    public void init() {
        // TODO get all plugin bean and convert to map (coordinate, pluginClass) => plugin instance
        for (Map.Entry<String, Plugin> ent : applicationContext.getBeansOfType(Plugin.class).entrySet()) {

        }
    }
}
