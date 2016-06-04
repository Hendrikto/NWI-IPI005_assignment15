package intersection;

/**
 * A zone on an intersection.
 *
 * @author Hendrik Werner // s4549775
 */
public class Zone {

    private final int ID;
    private boolean blocked;

    public Zone(int id) {
        ID = id;
    }

    /**
     * @return whether blocking was successful
     */
    public boolean block() {
        if (blocked) {
            return false;
        }
        blocked = true;
        return true;
    }

    /**
     * @return whether releasing was successful
     */
    public boolean release() {
        if (!blocked) {
            return false;
        }
        blocked = false;
        return true;
    }

}
