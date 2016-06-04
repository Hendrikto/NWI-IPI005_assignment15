package assignment15;

import intersection.Car;
import intersection.Zone;

/**
 * A simulation of cars going through an intersection.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class Assignment15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zone z0 = new Zone(0);
        Zone z1 = new Zone(1);
        Zone z2 = new Zone(2);
        Zone z3 = new Zone(3);
        new Thread(new Car(0, z0, z1, z2)).start();
        new Thread(new Car(1, z1, z2, z3)).start();
        new Thread(new Car(2, z2, z3, z0)).start();
        new Thread(new Car(3, z3, z0, z1)).start();
    }

}
