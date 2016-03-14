package org.samsara.pistachio.cache;

/**
 * Redis Pool Init Exception
 * throws when init fail
 * @see java.lang.Exception
 */
public class RedisPoolInitException extends Exception {

    public RedisPoolInitException(String msg) {
        super(msg);
    }

}
