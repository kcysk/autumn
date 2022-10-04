package com.autumn.context;

import com.autumn.core.Coordinate;
import com.autumn.core.Plugin;

/**
 * @author momo
 * @since 2022/9/19 22:45
 */
public interface ContextFactory<R extends StandardRequest, C extends Context<R>> extends Plugin {

    /**
     * create context by standard request
     * @param request standard request
     * @param coordinate runtime coordinate
     * @return context
     */
    C createContext(R request, Coordinate coordinate);
}
