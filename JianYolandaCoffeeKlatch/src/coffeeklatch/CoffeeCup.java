/**
 * A coffee cup
 *
 * @author yolanda.jian
 */
package coffeeklatch;

/**
 * Contains methods regarding information about the coffee cup.
 * ie. cup name, cup size, is the cup full, drinking the cup...
 * @author yolanda.jian
 */
public class CoffeeCup {

    private String n;
    private int s;
    private String sizeString;
    private boolean isFull = false;  // Is this cup full?

    /**
     * Setting the cup name to the name that was stated by the user.
     * @param name that the user has inputted. 
     */
    public void cupName(String name) {
        n = name;
    }

    /**
     * Checks the name of the user.
     * @return a string of the user's name
     */
    public String nameStr() {
        return n;
    }
    
    /**
     * Setting the cup size to the size stated by the user.
     * @param sml an integer representation of the size inputted by the user.
     */
    public void cupSize(int sml) {
        s = sml;

    }

    /**
     * Retrieves the size that the user requested.
     * @return an integer of the size requested by the user.
     */
    public int getSize() {
        return s;
    }

    /**
     * Converts the integer value of the size to a string.
     * @return string of "small," "medium," or "large."
     */
    public String sizeStr() {
        if (s == 2) {
            sizeString = "small";
        } else if (s == 3) {
            sizeString = "medium";
        } else if (s == 4) {
            sizeString = "large";
        }
        return sizeString;
    }

    /**
     * Returns whether this cup is full (true) or empty(false);
     *
     * @return is this cup full?
     */
    public boolean isFull() {
        return isFull;
    }

    /**
     * Fill this cup to the top
     */
    public void fill() {
        isFull = true;
    }

    /**
     * Drink this cup entirely
     */
    public boolean drink() {
        if (isFull) {
            System.out.println(n + ", you glug the coffee down.\n");
            isFull = false;

            return true;
        } else {
            System.out.println(n + ", you sip furiously, but only suck air.\n");
            return false;
        }

    }
}
