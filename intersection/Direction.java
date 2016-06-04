package intersection;

import java.util.Random;

/**
 * Directions a car can take at an intersection.
 *
 * @author Hendrik Werner // s4549775
 */
public enum Direction {
    Right, Straight, Left;

    private static final Random random = new Random();

    /**
     * @return a random direction
     */
    public static Direction getRandom() {
        return values()[random.nextInt(values().length)];
    }

}
