package com.autumn.context;

import com.autumn.core.Coordinate;
import com.autumn.core.CoordinateHolder;
import org.jetbrains.annotations.NotNull;

/**
 * @author momo
 * @since 2022/9/19 22:08
 */
public interface Context<R extends StandardRequest> extends CoordinateHolder {


    /**
     * get current context's standard request
     *
     * @return request
     */
    @NotNull
    R getRequest();

    /**
     * coordinate for workFlow
     *
     * @return coordinate
     */
    @Override
    @NotNull
    Coordinate getCoordinate();
}
