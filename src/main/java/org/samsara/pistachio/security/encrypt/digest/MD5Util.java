package org.samsara.pistachio.security.encrypt.digest;

import org.samsara.pistachio.security.EncryptException;
import org.samsara.pistachio.util.StringUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Samsara Common Library<br>
 * MD5 encrypt class
 * @author sczyh30
 */
public class MD5Util {

    /**
     * <p>Use MD5 algorithm to hash the string.</p>
     * This might not be very safe due to its length.
     * @param str string
     * @return encrypted string
     */
    public static String md5(String str) {
        if(str != null) {
            try {
                byte[] btInput = str.getBytes();
                MessageDigest mdInst = MessageDigest.getInstance("MD5");
                mdInst.update(btInput); // update the digest
                byte[] md = mdInst.digest(); // get the encrypted byte stream

                return StringUtil.bytes2hex(md);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return "";
            }
        }
        else {
            throw new EncryptException("null string parameter is invalid");
        }
    }
}
