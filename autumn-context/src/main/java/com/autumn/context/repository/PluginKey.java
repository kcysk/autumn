package com.autumn.context.repository;

import com.autumn.core.Coordinate;
import com.autumn.core.Plugin;

import java.util.Objects;

/**
 * @author momo
 * @since 2022/10/4 09:10
 */
public final class PluginKey<P extends Plugin> {

    private final Coordinate coordinate;

    private final Class<P> pluginClass;

    public PluginKey(Coordinate coordinate, Class<P> pluginClass) {
        this.coordinate = coordinate;
        this.pluginClass = pluginClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PluginKey that = (PluginKey) o;
        return Objects.equals(coordinate, that.coordinate) && Objects.equals(pluginClass, that.pluginClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, pluginClass);
    }
}
