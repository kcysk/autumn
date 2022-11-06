package com.autumn.context.support.repository;

import com.autumn.core.Coordinate;
import com.autumn.core.Plugin;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author momo
 * @since 2022/10/1 08:43
 */
public class ExtensionRepository {

    private final Map<ExtensionKey<? extends Plugin>, Plugin> extensions = new ConcurrentHashMap<>();

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
    public <P extends Plugin> void addExtension(Coordinate coordinate, P plugin) {
        Assert.notNull(coordinate, "coordinate can't null");
        Assert.notNull(plugin, "pluginClass can't null");
        addExtension(coordinate, plugin.getClass(), plugin);
    }

    @SuppressWarnings("unchecked")
    private void addExtension(Coordinate coordinate, Class<? extends Plugin> actualPluginClass, Plugin plugin) {
        extensions.put(new ExtensionKey<>(coordinate, actualPluginClass), plugin);
        for (Class<?> directInterface : actualPluginClass.getInterfaces()) {
            if (Plugin.class.isAssignableFrom(directInterface) && !Plugin.class.equals(directInterface)) {
                addExtension(coordinate, (Class<? extends Plugin>) directInterface, plugin);
            }
        }
    }
}
