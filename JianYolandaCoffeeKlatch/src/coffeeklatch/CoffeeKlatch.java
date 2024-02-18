package coffeeklatch;

import java.util.Scanner;

/**
 * Yolanda Jian 
 * Due: 04/06/23 An interactive coffee machine created with object
 * oriented programming.
 */
public class CoffeeKlatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        // Declare a reference to a CoffeeMachine.
        // Create a new CoffeeMachine and make the variable refer to it.
        CoffeeMachine option = new CoffeeMachine();
        // Declare a reference to a CoffeeCup.
        CoffeeCup cup = new CoffeeCup();
        String name = "none";
        String cupSize = "none";
        char typeArr[] = {'i', 's'};
        boolean validOption = false;
        boolean exit = false;
        char choice = 'a';
        boolean customer = false;

        //Continue to loop until the exit function is executed by the user
        while (!exit) {
            //Printing the menu with the status of all functions
            System.out.printf("\t\t\t\tMACHINE\t\t\tUSER: " + name + "\tCup Size: " + cupSize + "\n\t\t"
                    + "Water \t Level \t Beans \t BeansGround \t CofffeeBrewed \t Cup Full \t Strength \n\t\t"
                    + option.waterInCup() + "\t " + option.level() + "\t " + option.beansInCup() + "\t " + option.beansGrounded()
                    + "\t\t " + option.coffeeBrewed() + "\t\t " + cup.isFull() + "\t\t " + option.strengthStatus() + "\n");

            do {//Loop until the user's option is valid 
                //Printing options
                System.out.printf("OPTION: n - New Customer\n\tw - Add Water\n\tb - Add Coffee Beans\n\t"
                        + "g - Grind Beans\n\tr - Brew Coffee\n\tp - Pour a Cup\n\td - Drink a Cup\n\tx - Exit"
                        + "\n\t\tYour Choice? ");
                String input = keyboard.nextLine();
                if (input.length() == 1) {
                    choice = input.charAt(0);
                    if (choice == 'n' || choice == 'w' || choice == 'b' || choice == 'g' || choice == 'r' || choice == 'p' || choice == 'd' || choice == 'x') {
                        validOption = true;//if the option is valid, break out of the loop.
                    } else {//if the option was not valid
                        validOption = false;
                        System.out.println("Please enter one of the options above.");
                    }
                } else {//if the string was longer than one character
                    validOption = false;
                    System.out.println("Please enter one of the options above.");
                }
            } while (!validOption);

            if (validOption) {
                switch (choice) {
                    case 'n':
                        boolean goodName = false;
                        boolean goodSize = false;
                        boolean goodStrength = false;

                        //asking for name
                        do {
                            System.out.print("What is your name? ");

                            try {
                                name = keyboard.nextLine();
                                goodName = typeVerify(name, typeArr[1]);//checking user entry
                            } catch (Exception e) {
                                goodName = false;
                                System.out.println("Can not be empty.");
                            }
                        } while (!goodName);

                        if (goodName) {
                            cup.cupName(name);//setting the name in the CoffeeCup class
                        }
                        //asking for size
                        String sizeInput = "";
                        int customerCup = 0;
                        char size = 'a';
                        do {
                            System.out.print("What size would you like? (s)mall, (m)edium, (l)arge: ");

                            try {
                                sizeInput = keyboard.nextLine();
                                if (sizeInput.length() == 1) {
                                    size = sizeInput.charAt(0);
                                    if (size == 's' || size == 'm' || size == 'l') {
                                        goodSize = true;
                                        switch (size) {//assigning the character to its respective string of the size
                                            case 's':
                                                customerCup = 2;
                                                cupSize = "small";
                                                break;
                                            case 'm':
                                                customerCup = 3;
                                                cupSize = "medium";
                                                break;
                                            case 'l':
                                                customerCup = 4;
                                                cupSize = "large";
                                                break;
                                        }
                                    } else {//sml was not inputted 
                                        goodSize = false;
                                        System.out.println("Please enter s, m, or l");
                                    }
                                } else {//the string was longer than 1 character 
                                    goodSize = false;
                                    System.out.println("Please enter s, m, or l");
                                }
                            } catch (Exception e) {//the string was empty
                                goodSize = false;
                                System.out.println("Can not be empty.");
                            }

                            if (goodSize) {
                                cup.cupSize(customerCup);//setting the size in the CoffeeCup class
                            }

                        } while (!goodSize);

                        char strength = 'a';
                        //asking for strength
                        do {
                            System.out.print("How do you like your coffee? (w)eak, (r)egular, (s)trong, (k)iller intense: ");
                            String strengthInput = "";
                            try {
                                strengthInput = keyboard.nextLine();

                                if (strengthInput.length() == 1) {
                                    strength = strengthInput.charAt(0);
                                    if (strength == 'w' || strength == 'r' || strength == 's' || strength == 'k') {
                                        goodStrength = true;
                                    } else {//option was not valid
                                        goodStrength = false;
                                        System.out.println("Please enter w, r, s, or k.");
                                    }
                                } else {//longer than 1 character 
                                    goodStrength = false;
                                    System.out.println("Please enter w, r, s, or k.");
                                }
                            } catch (Exception e) {//empty
                                goodStrength = false;
                                System.out.println("Can not be empty.");
                            }
                        } while (!goodStrength);

                        if (goodStrength) {
                            //setting the character to its respective string of the strength.
                            switch (strength) {
                                case 'w':
                                    option.setStrength("Weak");
                                    break;
                                case 'r':
                                    option.setStrength("Regular");
                                    break;
                                case 's':
                                    option.setStrength("Strong");
                                    break;
                                case 'k':
                                    option.setStrength("Killer Intense");
                                    break;
                            }
                        }
                        //if the name, size, and strength are valid, a customer is created
                        if (goodName && goodSize && goodStrength) {
                            customer = true;
                            //resetting flags
                            option.resetFlags();
                        }
                        break;

                    //add water selection
                    case 'w':
                        if (customer) {//if a customer has been created 
                            option.addWater();
                            if (option.waterInCup()) {

                            }
                        } else {
                            System.out.println("Please enter a customer.");
                        }
                        break;

                    //add beans selection 
                    case 'b':
                        if (customer) {
                            option.addBeans();
                        } else {
                            System.out.println("Please enter a customer.");
                        }
                        break;

                    //grind beans selection
                    case 'g':
                        if (customer) {
                            option.grindBeans();
                        } else {
                            System.out.println("Please enter a customer.");
                        }
                        break;

                    //brew coffee selection
                    case 'r':
                        if (customer) {
                            option.brew(cup);
                        } else {
                            System.out.println("Please enter a customer.");
                        }
                        break;

                    //pour coffee selection
                    case 'p':
                        if (customer) {
                            option.pour(cup);
                        } else {
                            System.out.println("Please enter a customer.");
                        }
                        break;

                    //drink coffee selection
                    case 'd':
                        if (customer) {
                            cup.drink();
                        } else {
                            System.out.println("Please enter a customer.");
                        }
                        break;

                    //exit selection
                    case 'x':
                        exit = true;
                        System.out.println("Enjoy!");
                        break;
                }
            }
        }
    }

    static boolean typeVerify(String elementCur, char arrCur) { //User entry verification 
        boolean correct = false;
        switch (arrCur) {
            case 'i':
                try {
                    int typeInt = Integer.parseInt(elementCur);//converting to int
                    correct = true;

                } catch (NumberFormatException e) {//catching the error
                    correct = false;
                    System.out.println("Enter a valid integer.");
                }
                break;

            case 's':

                for (int i = 0; i <= elementCur.length(); i++) {
                    //uppercase 65 to 90 lowercase 97 to 122
                    if (elementCur.charAt(i) >= 65 && elementCur.charAt(i) <= 90 || elementCur.charAt(i) >= 97 && elementCur.charAt(i) <= 122) {
                        correct = true;
                        break;
                    } else {
                        System.out.println("Enter a valid string.");
                        correct = false;
                        break;
                    }
                }
        }
        return correct;
    }

}
