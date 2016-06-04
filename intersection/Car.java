package intersection;

import java.util.Arrays;

/**
 * A car that can ride straight, right or left.
 *
 * @author Hendrik Werner // s4549775
 */
public class Car implements Runnable {

    private final int ID;
    private final Zone[] zones;

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
    }

    @Override
    public void run() {
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

}
