package ressource;


import static java.lang.Math.random;
import static java.lang.Math.round;


public class Randomier {

    public static int getRandomIndex(final int from, final int to) {
        return (int) round(random() * (to - from)) + from;
    }

    public static long getRandomIndex(final long from, final long to) {
        return round(random() * (to - from)) + from;
    }
}
