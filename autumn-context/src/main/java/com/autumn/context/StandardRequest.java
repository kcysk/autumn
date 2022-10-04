package com.autumn.context;

import com.autumn.core.Request;

/**
 * @author momo
 * @since 2022/10/1 09:07
 */
public interface StandardRequest extends Request {

    /**
     * get attachments buy key
     * @param key key
     * @return attachments
     * @param <T> generic type
     */
    <T> T getAttachments(String key);
}
