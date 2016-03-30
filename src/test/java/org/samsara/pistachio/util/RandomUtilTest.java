package org.samsara.pistachio.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test case
 * Created by sczyh30 on 15-12-24.
 */
public class RandomUtilTest {

    @Test
    public void testGetRandom8() throws Exception {
        System.out.println(RandomUtil.getRandom8());
    }

    @Test
    public void testGetRandom() throws Exception {
        System.out.println(RandomUtil.getRandom(9));
    }
}