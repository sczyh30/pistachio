package org.samsara.pistachio.security.encrypt.digest;

import org.samsara.pistachio.security.EncryptException;
import org.samsara.pistachio.util.StringUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Samsara Common Library
 * SHA encrypt util class
 * @author sczyh30
 */
public class SHAUtil {

    /**
     * The method of SHA1 encryption
     * @param str string
     * @return encrypted string
     */
    public static String sha1(String str) {
        if(str != null) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-1");
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
}