package org.samsara.pistachio.base;

/**
 * Samsara Pistachio
 * Basic runtime exception.<br/>
 * Provides the base abstract exception
 */
public abstract class NestedRuntimeException extends RuntimeException {

    /**
     * Constructor with message
     * @param msg exception message
     */
    public NestedRuntimeException(String msg) {
        super(msg);
    }

    /**
     * Constructor with message and Throwable
     * @param msg exception message
     * @param cause Throwable object
     */
    public NestedRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
