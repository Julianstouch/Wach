package ressource;


import static java.lang.Math.random;
import static java.lang.Math.round;


public class RandomUtil {

    public static double getRandom(final double variation) {
        return (random() * variation * 2 + 1 - variation);
    }

    public static int getRandomIndex(final int from, final int to) {
        return (int) round(random() * (to - from)) + from;
    }
}
