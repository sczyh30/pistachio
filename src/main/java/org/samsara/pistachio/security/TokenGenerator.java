package org.samsara.pistachio.security;

import org.samsara.pistachio.security.encrypt.digest.MD5Util;

import java.time.LocalTime;
import java.util.UUID;

/**
 * Samsara Pistachio
 * Token Generator
 */
public class TokenGenerator {

    public static String generate(int bid, int code) {
        return MD5Util.md5(bid + LocalTime.now().toString() + code + UUID.randomUUID().toString());
    }
}
