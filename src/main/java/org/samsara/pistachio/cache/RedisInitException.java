package org.samsara.pistachio.cache;

import org.samsara.pistachio.base.NestedRuntimeException;

/**
 * Redis Pool Init Exception
 * throws when init fail
 * @see java.lang.Exception
 */
public class RedisInitException extends NestedRuntimeException {

    public RedisInitException(String msg) {
        super(msg);
    }

}
