package org.samsara.pistachio.security.encrypt.digest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test case for SHA class
 */
public class SHAUtilTest {

    @Test
    public void testSha1() throws Exception {
        assertEquals("7C4A8D09CA3762AF61E59520943DC26494F8941B", SHAUtil.sha1("123456"));
        assertEquals("20EABE5D64B0E216796E834F52D61FD0B70332FC", SHAUtil.sha1("1234567"));
        assertEquals("86F29A9232FD669AEF6D3027616ACB9EBE74F24D", SHAUtil.sha1("1x5aS%D!K-s5A"));
        //SHAUtil.sha1(null); // EncryptException
    }

    @Test
    public void testSha256() throws Exception {
        assertEquals("15E2B0D3C33891EBB0F1EF609EC419420C20E320CE94C65FBC8C3312448EB225",
                SHAUtil.sha256("123456789"));
    }

    @Test
    public void testSha512() throws Exception {
        assertEquals("E737ABEBB798D51826FE97243D8C9A651BC4467D0193C825AABDDB4D16DF05B305DBF52D0FF07E6218F723B42E6472FD584D3819057ACE3AAEED321550E3C928",
                SHAUtil.sha512("1234s678q"));
    }

    @Test
    public void testSha2561() throws Exception {

    }

    @Test
    public void testSha5121() throws Exception {

    }
}