package com.autumn.context;

import com.autumn.core.Plugin;

/**
 * @author momo
 * @since 2022/9/19 22:11
 */
public interface WorkFlow<R extends StandardRequest, C extends Context<R>> extends Plugin {

    /**
     * process
     * @param context context
     */
    void process(C context);
}
