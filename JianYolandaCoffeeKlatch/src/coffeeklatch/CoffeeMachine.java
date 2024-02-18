/* A fancy coffee maker.  Makes coffee of varying strengths. */
/**
 *
 * @author yolanda.jian
 */
package coffeeklatch;

/**
 * Contains methods regarding the functions of the coffee machine. ie. adding
 * water, adding beans, grinding beans...
 *
 * @author yolanda.jian
 */
public class CoffeeMachine {

    private boolean waterInCup = false;
    private boolean beansInCup = false;
    private boolean beansGrounded = false;
    private boolean coffeeBrewed = false;
    private int curLevel = 0;

    /**
     * Resetting all functions to false.
     */
    public void resetFlags() {
        waterInCup = false;
        beansInCup = false;
        beansGrounded = false;
        coffeeBrewed = false;
        curLevel = 0;
    }

    // The current strength of the coffee.
    private String strength = "none";

    /**
     * Set the strength of the Coffee to s; affects the fineness of the grind.
     * "Weak", "Regular", "Strong" are the usual options for s, but you can try
     * others.
     *
     * @param s Text Description of Strength
     */
    public void setStrength(String s) {
        strength = s;
    }

    /**
     * Checks if the beans have been grounded.
     *
     * @return true/false if the beans have been grounded.
     */
    public boolean beansGrounded() {
        return beansGrounded;
    }

    /**
     * Checks if the coffee has been brewed.
     *
     * @return true/false if the coffee has been brewed.
     */
    public boolean coffeeBrewed() {
        return coffeeBrewed;
    }

    /**
     * Checks the strength status. Options are weak, regular, strong, and killer
     * intense.
     *
     * @return a string of the current strength.
     */
    public String strengthStatus() {
        return strength;
    }

    /**
     * Grind the beans for the coffee
     */
    public void grindBeans() {
        //If there are beans in the cup and they have not been grounded yet
        if (beansInCup() && !beansGrounded()) {
            System.out.println("Grinding beans...");
            System.out.println("Beans ground for "
                    + strength + " coffee.\n");
            beansGrounded = true;
        } else if (!beansInCup()) {//If there are no beans in the cup 
            System.out.println("Add beans before grinding.\n");
        } else if (beansGrounded()) {//If the beans have already been grounded
            System.out.println("Beans have been grounded already.\n");
        }
    }

    /**
     * Brew the coffee into given cup c
     *
     * @param c The cup of coffee to be filled
     */
    public void brew(CoffeeCup c) {
        //If water and ground beans have been added and the coffee has not been brewed already
        if (waterInCup() && beansGrounded() && !coffeeBrewed()) {
            System.out.println("Brewing the coffee...");
            System.out.println("Brewed " + strength + " coffee into coffee cup for " + c.nameStr() + ".\n");
            coffeeBrewed = true;
        } else if (coffeeBrewed()) {//if the coffee has already been brewed
            System.out.println("Coffee has already been brewed.\n");
        } else if (!waterInCup()) {//If there is no water in the cup
            System.out.println("Please add water.\n");
        } else if (!beansGrounded()) {//If the beans have not been grounded yet
            System.out.println("Please grind beans.\n");
        }
    }

    /**
     * Add water to the machine reservoir
     */
    public boolean waterInCup() {
        return waterInCup;
    }

    /**
     * Checks the current level in the reservoir. The level can be between 0 and
     * 10 inclusive.
     *
     * @return an integer number of the current level.
     */
    public int level() {
        return curLevel;
    }

    /**
     * Adding water and updating the level to 10.
     */
    public void addWater() {
        //if water has not been added yet
        if (!waterInCup()) {
            System.out.println("Adding Water...");
            System.out.printf("== Water Added\n");
            curLevel = 10;//setting the water level to 10
            waterInCup = true;
        } else {
            System.out.println("There is sufficient water in the machine.\n");
        }
    }

    /**
     * Checks if there are beans in the cup.
     *
     * @return true/false if beans are in the cup.
     */
    public boolean beansInCup() {
        return beansInCup;
    }

    /**
     * Add Beans to the Machine
     */
    public void addBeans() {
        //if beans have not been added yet
        if (!beansInCup()) {
            System.out.println("Adding Beans...");
            System.out.println("== Beans Added\n");
            beansInCup = true;
        } else {
            System.out.println("There are sufficient beans in the machine.\n");
        }
    }

    /**
     * Pouring the coffee into the given cup c.
     *
     * @param c The cup of coffee to be filled.
     */
    public void pour(CoffeeCup c) {

        /*if the coffee has been brewed, the cup is not full, and the current level
        is greater than the size of the cup (small - 2, medium - 3, large - 4) */
        if (coffeeBrewed() && !c.isFull() && curLevel >= c.getSize()) {
            System.out.println("Pouring a cup of coffee\n");
            curLevel = curLevel - c.getSize();//updating the current level
            c.fill();//setting the cup to full
        } else if (curLevel < c.getSize()) {//if there is not enough water
            System.out.println("You need to make more coffee!\n");
            resetFlags();//resetting flags
        } else if (!coffeeBrewed()) {//if the coffee has not been brewed yet
            System.out.println("Please brew the coffee.\n");
        } else if (c.isFull()) {//if the cup is full 
            System.out.println("The cup is already full.\n");
        }
    }
}
