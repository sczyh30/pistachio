package org.samsara.pistachio.util;

import org.springframework.web.util.HtmlUtils;

/**
 * Samsara Common Library<br/>
 * String util class
 * @author sczyh30
 */
public final class StringUtil {

    /**
     * This method converts byte stream to a hex string
     * @param bytes byte stream array
     * @return the hex string
     */
    public static String bytes2hex(byte[] bytes) {
        if(bytes != null) {
            StringBuilder hexString = new StringBuilder();
            // bytes to hex
            for (byte b : bytes) {
                String strHex = Integer.toHexString(b & 0xFF);
                if (strHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(strHex);
            }
            return hexString.toString().toUpperCase();
        }
        else
            throw new NullPointerException("Null bytes"); //TODO: Null Pointer!
    }

    public static String htmlEscape(String str) {
        return HtmlUtils.htmlEscape(str);
    }
}
