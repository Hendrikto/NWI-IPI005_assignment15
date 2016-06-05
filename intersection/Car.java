package intersection;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A car that can ride straight, right or left.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class Car implements Runnable {

    private static final int WAIT = 100;

    private final int ID;
    private final Zone[] zones;
    private final Random generator;

    /**
     * @param id the id of the car
     * @param zones the zones this car blocks when crossing the intersection.
     * These must be ordered: When this car turns right it blocks only the first
     * zone when it goes straight of blocks the first two zones and when turning
     * left it block the first three.
     */
    public Car(int id, Zone... zones) {
        ID = id;
        this.zones = zones;
        generator = new Random();
    }

    /**
     * Start the car.
     */
    @Override
    public void run() {
        while (true) {
            Direction d = Direction.getRandom();
            Zone[] blockZones = getBlockZones(d);
            Arrays.stream(blockZones).forEachOrdered(Zone::block);
            System.out.printf("Car %d goes %s.\n", ID, d);
            Arrays.stream(blockZones).forEachOrdered(Zone::release);
            sleepRandom();
        }
    }

    /**
     * @param d the direction the car wants to take
     * @return a sorted array of zones to block before going in the given
     * direction
     */
    private Zone[] getBlockZones(Direction d) {
        Zone[] blockZones = new Zone[d.ordinal()];
        System.arraycopy(zones, 0, blockZones, 0, blockZones.length);
        Arrays.sort(blockZones);
        return blockZones;
    }

    /**
     * Sleep for a random amount of milliseconds up to a maximum of WAIT ms.
     */
    private void sleepRandom() {
        try {
            Thread.sleep(generator.nextInt(WAIT));
        } catch (InterruptedException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
