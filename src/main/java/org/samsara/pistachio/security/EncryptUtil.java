package org.samsara.pistachio.security;

import org.samsara.pistachio.security.encrypt.PBKDF2;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Samsara Common Library
 * Security encryption util class
 * @author sczyh30
 * @since 0.0.7
 */
public class EncryptUtil {

    /**
     * Encryption for common password storage.<br>
     * Algorithm: Frontend Initial(<strong>SHA-256</strong>) + Backend(<strong>PBKDF2</strong>)
     *
     * @param password frontend initial encrypted password (SHA-256)
     * @return final encrypted password
     *
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    public static String encrypt(String password)
            throws InvalidKeySpecException, NoSuchAlgorithmException {
        return PBKDF2.pbkdf2(password);
    }

    /**
     * Encryption for common password storage.<br>
     * Algorithm: Frontend Initial(<strong>SHA-256</strong>) + Backend(<strong>PBKDF2</strong>)
     *
     * @param password frontend initial encrypted password (SHA-256)
     * @return final encrypted password
     *
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    public static String encrypt(char[] password)
            throws InvalidKeySpecException, NoSuchAlgorithmException {
        return PBKDF2.pbkdf2(password);
    }
}
