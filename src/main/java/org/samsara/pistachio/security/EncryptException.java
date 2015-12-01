package org.samsara.pistachio.security;

import org.samsara.pistachio.base.NestedRuntimeException;

/**
 * Encrypt Exception
 * This is the basic exception thrown by encryption process
 */
public class EncryptException extends NestedRuntimeException {

    public EncryptException(String msg) {
        super(msg);
    }

    public EncryptException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
