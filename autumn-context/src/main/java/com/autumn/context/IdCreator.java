package com.autumn.context;

import com.autumn.core.Coordinate;
import com.autumn.core.Plugin;

/**
 * @author momo
 * @since 2022/9/19 22:10
 */
public interface IdCreator<I extends Id, R extends StandardRequest> extends Plugin {

    /**
     * create or restore 'ID'
     *
     * @param request standard request
     * @param coordinate runtime coordinate
     * @return Id
     */
    I createId(R request, Coordinate coordinate);

}
