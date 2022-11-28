package com.autumn.boot.extension;

import com.autumn.context.repository.PluginRepositories;
import com.autumn.core.Plugin;
import com.autumn.core.PluginRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * @author shenke
 * @since 2022/11/6 16:14
 */
public class PluginRegister implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private final PluginRepository pluginRepository;

    public PluginRegister(PluginRepositories pluginRepository) {
        this.pluginRepository = pluginRepository;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void registerPlugin() {
        for (Map.Entry<String, ? extends Plugin> entry : applicationContext.getBeansOfType(Plugin.class).entrySet()) {
            pluginRepository.addPlugin(entry.getValue());
        }
    }
}
