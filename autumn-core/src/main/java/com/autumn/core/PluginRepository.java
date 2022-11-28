package com.autumn.core;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author momo
 * @since 2022.11.28
 */
public interface PluginRepository {

    /**
     *
     * add plugin to repository with coordinate
     *
     * @param coordinate coordinate's instance can not null
     * @param plugin plugin's instance  can't null
     */
    void addPlugin(@NotNull Coordinate coordinate, @NotNull Plugin plugin);

    /**
     *
     * add plugin to repository <br/>
     * {@link Coordinate} will parsed from plugin instance
     *
     * @param plugin plugin instance can not null
     */
    void addPlugin(@NotNull Plugin plugin);

    /**
     * find plugin from repository <br/>
     * if not found or find more will throw {@link AutumnException}
     *
     *
     * @param coordinate coordinate can't null
     * @param pluginClass plugin type can't null
     * @return plugin
     * @param <P> generic type of plugin
     */
    @NotNull
    <P extends Plugin> P getPlugin(@NotNull Coordinate coordinate, @NotNull Class<P> pluginClass);

    /**
     * find plugin from repository <br/>
     * this method different from {@link this#getPlugin(Coordinate, Class)} this method will return null if not found <br/>
     * but find more than one plugin this method will throw {@link AutumnException}
     *
     * @param coordinate coordinate can't null
     * @param pluginClass plugin type can't null
     * @return plugin
     * @param <P> generic type of plugin
     */
    @Nullable
    <P extends Plugin> P findPlugin(@NotNull Coordinate coordinate, @NotNull Class<P> pluginClass);
}
