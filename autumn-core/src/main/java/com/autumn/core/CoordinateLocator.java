package com.autumn.core;

/**
 * locate coordinate plugin
 * @author momo
 * @since 2022/9/19 22:09
 */
public interface CoordinateLocator<R extends Request> {

    /**
     * locate coordinate
     * @see Coordinate
     * @param request standard request can't null
     * @return coordinate
     *
     */
    Coordinate locateCoordinate(R request);
}
