package org.samsara.pistachio.security;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test case for tkg
 * Created by sczyh30 on 15-12-23.
 */
public class TokenGeneratorTest {

    @Test
    public void testGenerate() throws Exception {
        System.out.println(TokenGenerator.generate(1661, 1246));
    }
}