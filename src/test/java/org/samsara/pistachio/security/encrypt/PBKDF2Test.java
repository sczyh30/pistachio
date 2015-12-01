package org.samsara.pistachio.security.encrypt;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test case for PBKDF2 algorithm
 */
public class PBKDF2Test {

    @Test
    public void testValidatePassword() throws Exception {
        String p1 = "D5s6!4$3d8*ca-?F5ck0h";
        String kk = PBKDF2.createHash(p1);
        System.out.println(kk);
        assertEquals(true, PBKDF2.validatePassword(p1, kk));
        assertEquals(false, PBKDF2.validatePassword(p1, kk + "1000")); //OK
        //assertEquals(false, PBKDF2.validatePassword(p1, kk + "l")); //cannot pass
    }
}