package org.samsara.pistachio.util;

import org.samsara.pistachio.entity.ProcessStatus;
import org.samsara.pistachio.security.encrypt.digest.MD5Util;

import java.time.LocalTime;

/**
 * Samsara Pistachio
 * @author sczyh30
 */
public class ProcessUtil {

    /**
     * Generate process status entity
     * @param type type
     * @param string str
     * @param message msg
     * @return the process status entity
     */
    public static ProcessStatus generate(int type, String string, String message) {
        return new ProcessStatus(type, generateToken(string, type), message);
    }

    /**
     * Generate the token string
     * @param str string
     * @param type type
     * @return the token string
     */
    private static String generateToken(String str, int type) {
        return MD5Util.md5("" + type + str + LocalTime.now().toString());
    }
}
