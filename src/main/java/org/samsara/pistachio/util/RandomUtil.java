package org.samsara.pistachio.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Random generator class
 * @author sczyh30
 * @since 0.3.22
 */
public final class RandomUtil {

    /**
     * Generator an random int by 10^(p-1)
     * Use nextInt(int origin, int bound) in JDK 1.7
     * @param p p
     * @return random int
     */
    public static int getRandom(int p) {
        if(p <= 0 && p > 9)
            return -1;
        return ThreadLocalRandom.current().nextInt((int) Math.pow(10, p - 1),
                (int) Math.pow(10, p) - 1);
    }

    /**
     * Generator an random int in 10^7 ~ 10^8<br>
     * Use nextInt(int origin, int bound) in JDK 1.7
     * @return random int
     */
    public static int getRandom8() {
        return ThreadLocalRandom.current().nextInt(10_000_000, 99_000_000);
    }

}
