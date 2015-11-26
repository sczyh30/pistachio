package org.samsara.pistachio.security.encrypt.digest;

import org.samsara.pistachio.util.StringUtil;

import java.security.MessageDigest;

/**
 * Samsara Common Library
 * MD5 encrypt class
 * @author sczyh30
 */
public class MD5Util {

    /**
     * The method of MD5 encryption
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
            System.out.println("#E2:Null String at MD5Util.MD5");
            return "";
        }
    }
}
