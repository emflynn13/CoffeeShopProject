import java.util.Scanner;

public class Main {


    //--------------------------------------------------
    //	printMenu
    //--------------------------------------------------

    /**
     * printMenu prints the menu on the screen
     */
    public static void printMenu(){
        System.out.println("------------------------------------");
        System.out.println("		***	    MENU	***	  	  ");
        System.out.println("------------------------------------");
        System.out.println("0. Exit");
        System.out.println("1. Add New Customer");
        System.out.println("2. Remove Customer");
        System.out.println("3. Display Customer Info");
        System.out.println("4. Display All Customer IDs");
        System.out.println("5. Add Coffee Item");
        System.out.println("6. Add Tea Product");
        System.out.println("7. Remove Product");
        System.out.println("8. Display Product Info");
        System.out.println("9. Display All Product IDs");
        System.out.println("10. Purchase Product");
        System.out.println("11. Display Purchase Info");
        System.out.println("12. Display Purchase IDs");
        System.out.println("13. Load Database from Disk");
        System.out.println("14. Save Database to Disk");
        System.out.println("\n");
    }

    //--------------------------------------------------
    //	intValidation
    //--------------------------------------------------

    /**
     * Function gets a valid integer input from user
     * @param sc - The scanner getting the input value by keyboard
     * @param min - The lower bound value accepted.
     * @param max - The upper bound value accepted.
     * @return - value entered by user
     */
    public static int intValidation(Scanner sc,
                                      int min,
                                      int max
    ){

        //create the output variable
        int res = -1;

        // create an auxiliary variable for the loop
        boolean validOption = false;

        // While loop keeps going until it gets a valid answer and breaks out of it
        while (!validOption) {
            System.out.println("Choose an integer value within the range " + min + " and " + max + ": ");
            try {
                res = sc.nextInt();
                sc.nextLine();
                if ((res >= min) && (res <= max))
                    validOption = true;
                else
                    System.out.println("Please choose an option between " + min + " and " + max + ": ");
            }
            catch (Exception e) {
                System.out.println("Must enter an integer");
                sc.next();
            }
        }

        //4. We return res
        return res;
    }


    //--------------------------------------------------
    //	intValidation
    //--------------------------------------------------
    /**
     * Function gets a valid integer input from user
     * @param sc - The scanner getting the input value by keyboard
     * @return - value entered by user
     */
    // example of overloading
    public static int intValidation(Scanner sc){
        // create the output variable
        int res = -1;

        // create an auxiliary variable for the loop
        boolean validOption = false;

        // keep asking for a valid option until one is given
        while (!validOption) {
            System.out.println("Enter an integer");
            try {
                res = sc.nextInt();
                sc.nextLine();
                validOption = true;
            }
            catch (Exception e) {
                System.out.println("Must be an integer");
                sc.next();
            }
        }

        // return res
        return res;
    }

    //--------------------------------------------------
    //	stringValidation
    //--------------------------------------------------

    /**
     * Function gets a valid string input from user
     * @param sc - The scanner getting the input value by keyboard
     * @return - value entered by user
     */
    public static String stringValidation(Scanner sc){

        // create the output variable
        String res = "";

        // create a placeholder variable for the loop
        boolean validOption = false;

        // keep asking for a valid option until one is given
        while (!validOption) {
            System.out.println("Please enter a String");
            try {
                res = sc.nextLine();
                if ((res.length() > 0) && (res.charAt(0) >= 'A') && (res.charAt(0) <= 'Z'))
                    validOption = true;
                else
                    System.out.println("Sorry but the option must be a non-empty string starting by a capital letter");
            }
            catch (Exception e) {
                System.out.println("Sorry you did not enter a String and then press the return key");
                sc.next();
            }
        }

        // return res
        return res;
    }


    //--------------------------------------------------
    //	boolean Validation
    //--------------------------------------------------
    /**
     * Function gets a valid boolean input from user
     * @param sc - The scanner getting the input value by keyboard
     * @return - value entered by user
     */
    public static boolean booleanValidation(Scanner sc){
        boolean res = false;
        boolean validOption = false;

        while (!validOption) {
            System.out.println("Enter a boolean");
            try {
                res = sc.nextBoolean();
                validOption = true;
            }
            catch (Exception e) {
                System.out.println("Must enter a boolean");
                sc.next();
            }
        }


        return res;
    }


    //-------------------------------------------------------------------
    // interactiveSession
    //-------------------------------------------------------------------
    /**
     * This function performs the interactive session to the user.<br>
     * @param customersFileName - The name of the database file for users.
     * @param productsFileName - The name of the database file for items.
     */
    public static void interactiveSession(String customersFileName,
                                          String productsFileName
    ) {
        CoffeeShop cs = new CoffeeShopImp();


        //  create some auxiliary variables
        boolean finish = false;
        int option;
        Scanner sc = new Scanner(System.in);

        // While the user wants to continue the session
        while (!finish){ // when 0 is chosen finish = true
            // clear the screen
            for (int i = 0; i < 3; i++)
                System.out.println("\n");

            // print the menu
            printMenu();

            // ask user for input option
            option = intValidation(sc,
                    0,
                    14
            );

            // add more space between printing
            for (int i = 0; i < 3; i++)
                System.out.println("\n");

            // We create a few auxiliary variables which will be used throughout this block
            String myStr;
            String myStr2;

            int myInt;
            int myInt2;
            int myInt3;


            boolean myBool1;
            boolean myBool2;

            // user input decides the case
            switch (option) {
                case 0 -> finish = true;

                case 1 -> {
                    // I. We print the message
                    System.out.println("---------------\n1. Add Customer\n---------------");

                    // get customer info from user
                    System.out.println("Please enter the name for the new user");
                    myStr = stringValidation(sc);

                    // add the user
                    myInt = cs.addCustomer(myStr);

                    // state whether it was successful
                    System.out.println("New user with id " + myInt + " successfully created");
                }

                case 2 -> {
                    System.out.println("---------------\n2. Remove Customer\n---------------");

                    // ask the user for the ID
                    System.out.println("Please enter the ID for the user to be removed");
                    myInt = intValidation(sc);

                    // try to remove the user
                    int newInt = cs.removeCustomer(myInt);

                    // display whether operation was successful
                    if (newInt == -1)
                        System.out.println("Sorry, no customer is registered with ID: " + myInt + " so the remove operation cannot proceed.");
                    else
                        System.out.println("User with ID: " + myInt + " successfully removed");
                }

                case 3 -> {
                    System.out.println("---------------\n3. Display Customer Info\n---------------");

                    // ask the user to input the ID of the user to be removed
                    System.out.println("Enter the id for the customer to be displayed");
                    myInt = intValidation(sc);

                    // display the user info
                    cs.displayCustomerInfo(myInt);
                }

                case 4 -> {
                    System.out.println("---------------\n4. Display All Customer IDs\n---------------");

                    cs.displayAllCustomerIDs();
                }

                case 5 -> {
                    System.out.println("---------------\n5. Add Coffee Product\n---------------");

                    // get the user input to define the coffee
                    System.out.println("Please enter the name for the new coffee");
                    myStr = stringValidation(sc);
                    System.out.println("Please enter the type of the new coffee");
                    myStr2 = stringValidation(sc);
                    System.out.println("Please enter whether the new coffee is large");
                    myBool1 = booleanValidation(sc);
                    System.out.println("Please enter whether the coffee is dairy-free");
                    myBool2 = booleanValidation(sc);

                    // add the coffee
                    myInt = cs.addCoffee(myStr,
                            myStr2,
                            myBool1,
                            myBool2
                    );

                    System.out.println("New coffee with id " + myInt + " successfully created");
                }

                case 6 -> {
                    System.out.println("---------------\n6. Add Tea Product\n---------------");

                    // get user input to define the tea
                    System.out.println("Please enter the name for the new tea product");
                    myStr = stringValidation(sc);
                    System.out.println("Please enter the type of the new tea product");
                    myStr2 = stringValidation(sc);
                    System.out.println("Please enter whether new tea is large");
                    myBool1 = booleanValidation(sc);
                    System.out.println("Please enter how many sugar spoons are in the new tea product");
                    myInt = intValidation(sc);

                    // add the tea
                    myInt = cs.addTea(myStr,
                            myStr2,
                            myBool1,
                            myInt
                    );

                    System.out.println("New tea with id " + myInt + " successfully created");
                }

                case 7 -> {
                    System.out.println("---------------\n7. Remove Product\n---------------");

                    // get user input to identify the item to be removed
                    System.out.println("Please enter the ID for the product to be removed");
                    myInt = intValidation(sc);

                    //  remove the user
                    myBool1 = cs.removeProduct(myInt);

                    if (!myBool1) {
                        System.out.println("Sorry, no product is registered with ID: " + myInt + " .");
                    } else
                        System.out.println("Product with ID = " + myInt + " successfully removed");
                }

                case 8 -> {
                    System.out.println("---------------\n8. Display Product Info\n---------------");

                    // get user input to identify the product to be displayed
                    System.out.println("Enter the ID for the product to be displayed");
                    myInt = intValidation(sc);

                    cs.displayProduct(myInt);
                }

                case 9 -> {
                    System.out.println("---------------\n9. Display All Product IDs\n---------------");

                    cs.displayAllProductIDs();
                }

                case 10 -> {
                    System.out.println("---------------\n10. Purchase Product\n---------------");

                    System.out.println("Please enter the ID for the customer buying the product");
                    myInt = intValidation(sc);

                    // while loop gives the option of purchasing more products, enter false to exit
                    boolean buyMore = true;
                    while (buyMore) {
                        System.out.println("Please enter the ID for the product to be purchased");
                        myInt2 = intValidation(sc);

                        // try to purchase the product
                        myInt3 = cs.purchaseProduct(myInt, myInt2);

                        // if -1 is returned then something has gone wrong
                        if (myInt3 == -1) {
                            System.out.println("Sorry, there was an error");
                        } else
                            System.out.println("New purchase with ID: " + myInt3 + " successfully performed");
                        System.out.println("Would you like to make another purchase? ");
                        buyMore = booleanValidation(sc);
                    }
                }
                case 11 -> {
                    System.out.println("---------------\n11. Display Purchase Info\n---------------");

                    System.out.println("Enter the ID for the purchase to be displayed");
                    myInt = intValidation(sc);

                    cs.displayPurchaseInfo(myInt);
                }
                case 12 -> {
                    System.out.println("---------------\n12. Display All Purchase IDs\n---------------");

                    cs.displayAllPurchaseIDs();
                }


                case 13 -> {
                    System.out.println("---------------\n13. Load Database from Disk\n---------------");

                    // try to load the customer, products and purchases from the disk, true if successful, else false
                    myBool1 = cs.loadContentFromDisk(customersFileName,
                            productsFileName
                    );


                    if (!myBool1) {
                        System.out.println("Sorry, the loading from disk can not be completed");
                    } else
                        System.out.println("The loading from disk is completed successfully.");
                }

                case 14 -> {
                    System.out.println("---------------\n14. Save Database to File\n---------------");

                    // try to save the customers, products and purchases to disk
                    myBool1 = cs.saveContentToFile(customersFileName,
                            productsFileName
                    );

                    if (!myBool1) {
                        System.out.println("Sorry, the saving to disk can not be completed");
                    } else
                        System.out.println("The saving to disk is completed successfully.");
                }
            }

            // if 0 is chosen then we break out of the switch case
            if (option != 0) {
                System.out.println("Please key to continue");
                sc.nextLine();
            }
        }
    }


    //--------------------------------------------------
    //	main
    //--------------------------------------------------
    /**
     * This is the main entry point for the Java application.<br>
     * @param args - Any argument passed when calling to the Java application.
     */
    public static void main(String[] args) {
        String customersFileName = "./myDatabase/customers.txt";
        String productsFileName = "./myDatabase/products.txt";

        // send the file names into the session to begin
        interactiveSession(customersFileName, productsFileName);
    }

}