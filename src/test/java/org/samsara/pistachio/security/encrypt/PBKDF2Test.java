package org.samsara.pistachio.security.encrypt;

import org.junit.Test;
import org.samsara.pistachio.security.EncryptUtil;
import org.samsara.pistachio.security.encrypt.digest.SHAUtil;

import static org.junit.Assert.*;

/**
 * Test case for PBKDF2 algorithm
 */
public class PBKDF2Test {

    @Test
    public void testValidatePassword() throws Exception {
        String p1 = "D5s6!4$3d8*ca-?F5ck0h";
        String kk = PBKDF2.pbkdf2(p1);
        System.out.println(kk);
        assertEquals(true, PBKDF2.validatePassword(p1, kk));
        assertEquals(false, PBKDF2.validatePassword(p1, kk + "1000")); //OK
        //assertEquals(false, PBKDF2.validatePassword(p1, kk + "l")); //cannot pass
        String ks = PBKDF2.pbkdf2(SHAUtil.sha256("123456da5d8wc"));
        System.out.println(ks);
        assertEquals(false, PBKDF2.validatePassword("dadw!x50$S==+2s", ks));
        assertEquals(true, PBKDF2.validatePassword(SHAUtil.sha256("123456da5d8wc"), ks));
    }

    @Test
    public void test0() throws Exception {
        String cl = "fuck1234";
        String kk = PBKDF2.pbkdf2(cl);
        assertEquals(true, EncryptUtil.validate(cl, kk));
    }

    @Test
    public void test2() throws Exception {
        String cl = "fuck1234";
        String cls = SHAUtil.sha256(cl);
        String kk = PBKDF2.pbkdf2(cls);
        assertEquals(true, EncryptUtil.validate(cls, kk));
    }
}