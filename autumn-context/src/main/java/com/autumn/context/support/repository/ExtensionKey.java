package com.autumn.context.support.repository;

import com.autumn.core.Coordinate;
import com.autumn.core.Plugin;

import java.util.Objects;

/**
 * @author momo
 * @since 2022/10/4 09:10
 */
public final class ExtensionKey<P extends Plugin> {

    protected final Coordinate coordinate;

    protected final Class<P> pluginClass;

    public ExtensionKey(Coordinate coordinate, Class<P> pluginClass) {
        this.coordinate = coordinate;
        this.pluginClass = pluginClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtensionKey that = (ExtensionKey) o;
        return Objects.equals(coordinate, that.coordinate) && Objects.equals(pluginClass, that.pluginClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, pluginClass);
    }
}
