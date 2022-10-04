package com.autumn.context.support.repository;

import com.autumn.core.Coordinate;
import com.autumn.core.Plugin;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author momo
 * @since 2022/10/1 08:43
 */
public class ExtensionRepository implements InitializingBean {

    private Map<ExtensionKey<? extends Plugin>, Plugin> extensions;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.extensions = new HashMap<>();
    }

    /**
     * get extension by coordinate and actual plugin type
     * @param coordinate coordinate
     * @return Plugin instance
     * @param <P> plugin generic type
     * @param pluginClass plugin base instance but not {@link Plugin} class
     *
     */
    @SuppressWarnings("unchecked")
    @Nullable
    public <P extends Plugin> P getExtension(Coordinate coordinate, Class<P> pluginClass) {
        Assert.notNull(coordinate, "coordinate can't null");
        Assert.notNull(pluginClass, "pluginClass can't null");
        if (pluginClass.equals(Plugin.class)) {
            throw new IllegalArgumentException("pluginClass can't `com.autumn.core.Plugin`");
        }
        return (P) extensions.get(new ExtensionKey<P>(coordinate, pluginClass));
    }

    /**
     * put extension to repository
     * @param coordinate coordinate can't null
     * @param plugin extension can't null
     * @param <P> generic type of plugin
     */
    public <P extends Plugin> void addExtension(Coordinate coordinate,Class<P> pluginClass, P plugin) {
        Assert.notNull(coordinate, "coordinate can't null");
        Assert.notNull(plugin, "pluginClass can't null");
        extensions.put(new ExtensionKey<>(coordinate, pluginClass), plugin);
    }
}
