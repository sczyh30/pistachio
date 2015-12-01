package org.samsara.pistachio.security.encrypt;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test case for bcrypt algorithm
 */
public class BCryptTest {

    @Test
    public void testEncrypt() throws Exception {
        // TODO: this could fail in the initial version
        //System.out.println(BCrypt.encrypt(null, null));
        String p1 = "D5s6!4$3d8*ca-?F5ck0h";
        // Time test
        for(int i = 0; i < 100; i++) {
            String s1 = BCrypt.gensalt(10);
            System.out.println("SALT -> " + s1);
            String target = BCrypt.encrypt(p1, s1);
            System.out.println("PSHASH -> " + target);
            //assertEquals(true, BCrypt.validate(p1, target));
        }
    }
}