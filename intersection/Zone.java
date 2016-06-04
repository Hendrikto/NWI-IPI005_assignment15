package intersection;

/**
 * A zone on an intersection.
 *
 * @author Hendrik Werner // s4549775
 */
public class Zone implements Comparable<Zone> {

    private final int ID;
    private boolean blocked;

    public Zone(int id) {
        ID = id;
    }

    /**
     * @return whether blocking was successful
     */
    public synchronized boolean block() {
        if (blocked) {
            return false;
        }
        blocked = true;
        return true;
    }

    /**
     * @return whether releasing was successful
     */
    public synchronized boolean release() {
        if (!blocked) {
            return false;
        }
        blocked = false;
        return true;
    }

    /**
     * @param z the zone to compare to
     * @return the result of the comparison
     */
    @Override
    public int compareTo(Zone z) {
        return this.ID - z.ID;
    }

}
