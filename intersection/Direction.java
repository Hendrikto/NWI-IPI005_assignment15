package intersection;

import java.util.Random;

/**
 * Directions a car can take at an intersection.
 *
 * @author Hendrik Werner // s4549775
 */
public enum Direction {
    Straight, Left, Right;

    private static final Random random = new Random();

    public static Direction getRandom() {
        return values()[random.nextInt(values().length)];
    }

}
