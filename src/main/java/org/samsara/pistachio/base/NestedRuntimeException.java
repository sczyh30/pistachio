package org.samsara.pistachio.base;

/**
 * Samsara Pistachio
 * Basic runtime exception
 * provides the base abstract exception
 */
public abstract class NestedRuntimeException extends RuntimeException {

    /**
     * @param msg exception message
     */
    public NestedRuntimeException(String msg) {
        super(msg);
    }

    /**
     *
     * @param msg exception message
     * @param cause Throwable object
     */
    public NestedRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
