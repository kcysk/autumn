package com.autumn.boot;

import com.autumn.boot.extension.PluginRegister;
import com.autumn.context.repository.PluginRepositories;
import org.springframework.context.annotation.Bean;

/**
 * @author momo
 * @since 2022/10/4 09:42
 */
public class AutumnBootstrap {

    @Bean
    public PluginRepositories extensionRepository() {
        return new PluginRepositories();
    }

    @Bean
    public PluginRegister pluginRegister(PluginRepositories pluginRepositories) {
        return new PluginRegister(pluginRepositories);
    }
}
