package intersection;

import java.util.logging.Level;
import java.util.logging.Logger;

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
     * Aquire a lock on this zone.
     */
    public synchronized void block() {
        while (blocked) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Zone.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        blocked = true;
    }

    /**
     * Release the lock on this zone.
     */
    public synchronized void release() {
        blocked = false;
        notifyAll();
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
