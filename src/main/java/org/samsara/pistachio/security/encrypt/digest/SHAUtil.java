package org.samsara.pistachio.security.encrypt.digest;

import org.samsara.pistachio.security.EncryptException;
import org.samsara.pistachio.util.StringUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Samsara Common Library<br/>
 * SHA encrypt util class
 * @author sczyh30
 */
public class SHAUtil {

    private static final String SHA1 = "SHA-1";
    private static final String SHA256 = "SHA-256";
    private static final String SHA512 = "SHA-512";

    /**
     * Use digest hash algorithm to encrypt the string.
     * @param str string
     * @param type could be SHA-1, SHA-256, SHA-512
     * @return encrypted string
     */
    private static String hash(String str, String type) {
        if(str != null) {
            try {
                MessageDigest digest = MessageDigest.getInstance(type);
                digest.update(str.getBytes());
                byte messageDigest[] = digest.digest();

                return StringUtil.bytes2hex(messageDigest);
            }
            catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }
        else {
            throw new EncryptException("null string parameter is invalid");
        }
    }
    /**
     * Use SHA-1 algorithm to hash the string.
     * @param str string
     * @return encrypted string
     */
    public static String sha1(String str) {
        return hash(str, SHA1);
    }

    /**
     * Use SHA-256 algorithm to hash the string.
     * @param str string
     * @return encrypted string
     */
    public static String sha256(String str) {
        return hash(str, SHA256);
    }

    /**
     * Use SHA-512 algorithm to hash the string.
     * @param str string
     * @return encrypted string
     */
    public static String sha512(String str) {
        return hash(str, SHA512);
    }

    /**
     * Use SHA-256 algorithm (with salt) to hash the string.
     * @param str string
     * @param salt the salt string
     * @return encrypted string
     */
    public static String sha256(String str, String salt) {
        return hash(str, SHA256); //TODO:accomplish this algorithm
    }

    /**
     * Use SHA-512 algorithm (with salt) to hash the string.
     * @param str string
     * @param salt the salt string
     * @return encrypted string
     */
    public static String sha512(String str, String salt) {
        return hash(str, SHA512); //TODO:accomplish this algorithm
    }
}