package org.samsara.pistachio.util;

import org.junit.Test;

/**
 * Test case for string util class
 * Created by sczyh30 on 15-12-4.
 */
public class StringUtilTest {

    @Test
    public void testBytes2hex() throws Exception {

    }

    @Test
    public void testHtmlSpecialChars() throws Exception {
        System.out.println(StringUtil.htmlEscape("<script>alert(\"1\");</script>"));
    }
}