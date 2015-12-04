package org.samsara.pistachio.security.encrypt.digest;

import org.samsara.pistachio.security.EncryptException;
import org.samsara.pistachio.util.StringUtil;

import java.security.MessageDigest;

/**
 * Samsara Common Library<br/>
 * MD5 encrypt class
 * @author sczyh30
 */
public class MD5Util {

    /**
     * Use MD5 algorithm to hash the string.
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
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        else {
            throw new EncryptException("null string parameter is invalid");
        }
    }
}
