package ressource;


import static java.lang.Math.random;
import static java.lang.Math.round;


public class Randomier {

    public static int getRandom(final int min, final int max) {
        return (int) round(random() * (max - min)) + min;
    }

    public static long getRandomIndex(final long min, final long max) {
        return round(random() * (max - min)) + min;
    }

    public static int getRandomPourcent(final int pourcent, final int val, final int min, final int max) {
        if (getRandom(0, 100) >= pourcent) {
            return (int) round(random() * (max - min)) + min;
        } else
            return val;
    }

    /**
     * getRandom ( -10 a +10)
     * 
     * @return
     */
    public static int getRandomSC() {
        return (int) (round(random() * 20) - 10);
    }
}
