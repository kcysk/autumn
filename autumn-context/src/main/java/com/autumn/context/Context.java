package com.autumn.context;

import com.autumn.core.Coordinate;
import org.jetbrains.annotations.NotNull;

/**
 * @author momo
 * @since 2022/9/19 22:08
 */
public interface Context<R extends StandardRequest> {


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
    @NotNull
    Coordinate getCoordinate();
}
