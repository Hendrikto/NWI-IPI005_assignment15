package intersection;

/**
 * A car that can ride straight, right or left.
 *
 * @author Hendrik Werner // s4549775
 */
public class Car {

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

}
