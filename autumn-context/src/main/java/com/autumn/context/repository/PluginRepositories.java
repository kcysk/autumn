package com.autumn.context.repository;

import com.autumn.context.support.AutumnCoordinate;
import com.autumn.core.Coordinate;
import com.autumn.core.Plugin;
import com.autumn.core.PluginRepository;
import com.autumn.core.annotations.Extension;
import com.autumn.core.annotations.Grid;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author momo
 * @since 2022/10/1 08:43
 */
@SuppressWarnings("unchecked")
public class PluginRepositories implements PluginRepository {

    private final Map<PluginKey<? extends Plugin>, Plugin> extensions = new ConcurrentHashMap<>();


    @Nullable
    @Override
    public <P extends Plugin> P findPlugin(@NotNull Coordinate coordinate, @NotNull Class<P> pluginClass) {
        Assert.notNull(coordinate, "coordinate can't null");
        Assert.notNull(pluginClass, "pluginClass can't null");
        return (P) extensions.get(new PluginKey<>(coordinate, pluginClass));
    }


    @NotNull
    @Override
    public <P extends Plugin> P getPlugin(@NotNull Coordinate coordinate, @NotNull Class<P> pluginClass) {
        Assert.notNull(coordinate, "coordinate can't null");
        Assert.notNull(pluginClass, "pluginClass can't null");
        if (pluginClass.equals(Plugin.class)) {
            throw new IllegalArgumentException("pluginClass can't `com.autumn.core.Plugin`");
        }
        return (P) extensions.get(new PluginKey<>(coordinate, pluginClass));
    }



    @Override
    public void addPlugin(@NotNull Plugin plugin) {
        Extension extension = AnnotationUtils.findAnnotation(plugin.getClass(), Extension.class);
        if (Objects.isNull(extension)) {
            throw new NoCoordinateException(String.format("%s must have @Extension annotation",
                    plugin.getClass().getName()));
        }
        Grid[] coordinates = extension.coordinates();
        if (coordinates == null || coordinates.length == 0) {
            throw new NoCoordinateException(String.format("%s annotation Extension#coordinates is empty",
                    plugin.getClass().getName()));
        }
        for (Grid coordinate : coordinates) {
            for (final String businessIdentity : coordinate.businessIdentity()) {
                // TODO  需要优化
                AutumnCoordinate actualCoordinate = new AutumnCoordinate(
                        coordinate::scenario,
                        () -> businessIdentity
                );
                Plugin alreadyPlugin = findPlugin(actualCoordinate, plugin.getClass());
                if (alreadyPlugin != null) {
                    throw new NoUniqueCoordinateException(String.format("already exists plugin %s with coordinate %s",
                            alreadyPlugin, actualCoordinate));
                }
                addPlugin(actualCoordinate, plugin);
            }
        }
    }

    /**
     * put extension to repository
     * @param coordinate coordinate can't null
     * @param plugin extension can't null
     */
    @Override
    public void addPlugin(@NotNull Coordinate coordinate, @NotNull Plugin plugin) {
        Assert.notNull(coordinate, "coordinate can't null");
        Assert.notNull(plugin, "pluginClass can't null");
        addPlugin(coordinate, plugin.getClass(), plugin);
    }

    private void addPlugin(Coordinate coordinate, Class<? extends Plugin> actualPluginClass, Plugin plugin) {
        extensions.put(new PluginKey<>(coordinate, actualPluginClass), plugin);
        for (Class<?> directInterface : actualPluginClass.getInterfaces()) {
            if (Plugin.class.isAssignableFrom(directInterface) && !Plugin.class.equals(directInterface)) {
                addPlugin(coordinate, (Class<? extends Plugin>) directInterface, plugin);
            }
        }
    }
}
