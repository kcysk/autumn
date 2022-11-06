package com.autumn.boot;

import com.autumn.boot.extension.PluginRegister;
import com.autumn.context.support.repository.ExtensionRepository;
import org.springframework.context.annotation.Bean;

/**
 * @author momo
 * @since 2022/10/4 09:42
 */
public class AutumnBootstrap {

    @Bean
    public ExtensionRepository extensionRepository() {
        return new ExtensionRepository();
    }

    @Bean
    public PluginRegister pluginRegister(ExtensionRepository extensionRepository) {
        return new PluginRegister(extensionRepository);
    }
}
