import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class implements the interface CoffeeShop,
 * representing the management of a coffee shop<br>.
 * The class is final, to avoid any further class specialising it more.
 */
public final class CoffeeShopImp implements CoffeeShop{

    private final ArrayList<Customer> customersList;
    private final ArrayList<Product> productList;
    private final ArrayList<Purchase> purchaseList;

    /**
     * The constructor creates 1 instance (1 object) of the class LibraryImp<br>
     */
    public CoffeeShopImp(){
        this.customersList = new ArrayList<>();
        this.productList = new ArrayList<>();
        this.purchaseList = new ArrayList<>();
    }

    /**
     * This method attempts to add a customer to the coffee shop<br>
     * @param _name - The name of the customer.
     * @return The id of the customer created.
     */
    public int addCustomer(String _name){
        Customer newCustomer = new Customer(_name);
        int id = newCustomer.getId();
        this.customersList.add(newCustomer); // add to the customer list
        return id;
    }

    /**
     * This method attempts to remove a customer from the coffee shop<br>
     * @param _customerId - The id of the user.
     * @return (-1) if user does not exist; else 0 if removed.
     */
    public int removeCustomer(int _customerId) {
    int res = -1;
    int index = Customer.isCustomerInCustomerList(_customerId, this.customersList);

    if (index != -1){
        res = 0;
        this.customersList.remove(index);

    }
    return res;
    }

    /**
     * This method attempts to display customer info to the screen<br>
     * @param _customerID - The id of the user.
     */
    public void displayCustomerInfo(int _customerID) {
        int index = Customer.isCustomerInCustomerList(_customerID, this.customersList);

        if (index != -1){
            Customer myCustomer = this.customersList.get(index);

            String info = myCustomer.toString();
            System.out.println(info);
        }
        else
            System.out.println("No such customer registered with ID: " + _customerID);
    }

    /**
     * This method displays all customerIDs to the screen<br>
     */
    public void displayAllCustomerIDs(){
        System.out.println("** USER IDS **");
        for (Customer customer : this.customersList)
            System.out.println(customer.getId());
    }

    /**
     * This method attempts to add a coffee to the shop<br>
     * @param _name - The name of the coffee.
     * @param _type - The type of coffee.
     * @param _isLarge - The size of the coffee, small or large.
     * @param _dairy_free - Whether the coffee is dairy free or not
     * @return The id of the coffee created.
     */
    public int addCoffee(String _name, String _type, boolean _isLarge, boolean _dairy_free){
        Coffee newCoffee = new Coffee(_name, _type, _isLarge, _dairy_free);
        int id = newCoffee.getId();
        newCoffee.getPrice(); // used to set the instance variable this.price of the coffee
        this.productList.add(newCoffee);
        return id;
    }

    /**
     * This method attempts to add a tea to the shop<br>
     * @param _name - The name of the tea.
     * @param _type - The type of tea.
     * @param _isLarge - The size if the tea.
     * @param sugarSpoons - The number of sugar spoons in the tea.
     * @return The id of the tea created.
     */
    public int addTea(String _name, String _type, boolean _isLarge, int sugarSpoons){
        Tea newTea = new Tea(_name, _type, _isLarge, sugarSpoons);
        int id = newTea.getId();
        newTea.getPrice(); // used to set the instance variable this.price of the coffee
        this.productList.add(newTea);
        return id;
    }

    /**
     * This method attempts to remove a product from the store<br>
     * @param _prodId - The id of the product.
     * @return Whether the product could be removed or not.
     */
    public boolean removeProduct(int _prodId){
        boolean res = false;

        // check if product is in the product list
        int index = Product.isProductInProductList(_prodId, this.productList);

        // if it is in the list
        if (index != -1){
            res = true;
            this.productList.remove(index);
        }
        return res;
    }

    /**
     * This method attempts to display the product info to the screen<br>
     * @param _prodID - The id of the product.
     */
    public void displayProduct(int _prodID){
        int index = Product.isProductInProductList(_prodID, this.productList);
        if (index != -1){
            Product myProd = this.productList.get(index);
            String info = myProd.toString();

            System.out.println(info);
        }
        else
            System.out.println("Sorry no such product found with ID: " + _prodID);
    }

    /**
     * This method displays all productIDs to the screen<br>
     */
    public void displayAllProductIDs(){
        System.out.println("** Product ID List **");
        for (Product prod : this.productList){
            System.out.println(prod.getId());
        }
    }

    /**
     * This method attempts to purchase an item of the store<br>
     * @param _customerID - The id of the customer buying the item.
     * @param _prodID - The id of the item to be purchased.
     * @return The id of the purchase being performed (-1 if not possible to purchase).
     */
    public int purchaseProduct(int _customerID, int _prodID){

        // get index of the customer in customerList
        int customerIndex = Customer.isCustomerInCustomerList(_customerID, this.customersList);
        if (customerIndex == -1) // if not there
            System.out.println("There is no user with the ID: " + _customerID);

        // get the index of the product in productList
        int prodIndex = Product.isProductInProductList(_prodID, this.productList);
        if (prodIndex == -1) // if not there
            {System.out.println("There is no product with ID: " + _prodID);
            return -1;
            }

        Customer myCustomer = this.customersList.get(customerIndex);
        Product myProduct = this.productList.get(prodIndex);
        int custID = myCustomer.getId();
        int prodID = myProduct.getId();


        Purchase myPurchase = new Purchase(custID, prodID);
        this.purchaseList.add(myPurchase);
        myCustomer.setPastPurchases(myPurchase);

        return myPurchase.getPurchaseID();
    }

    /**
     * This method attempts to display the purchase info to the screen<br>
     * @param _purchaseID - The id of the purchase.
     */
    public void displayPurchaseInfo(int _purchaseID){
        int index = Purchase.isPurchaseInPurchaseList(_purchaseID, this.purchaseList);
        if (index != -1){
            Purchase myPur = this.purchaseList.get(index);
            String info = myPur.toString();

            System.out.println(info);
        }
        else
            System.out.println("Sorry no such purchase found with ID: " + _purchaseID);
    }

    /**
     * This method displays all purchaseIDs to the screen<br>
     */
    public void displayAllPurchaseIDs(){
        System.out.println("** Purchase ID List **");
        for (Purchase pur : this.purchaseList){
            System.out.println(pur.getId());
        }
    }


    /**
     * This method attempts to load the customers, products and purchases of the shop from disk.<br>
     * @param customersFileName - The name of the database file for customer.
     * @param productsFileName - The name of the database file for products.
     * @return Whether the content is loaded or not.
     */
    @Override
    public boolean loadContentFromDisk(String customersFileName, String productsFileName){
        return ((this.loadCustomersFromFile(customersFileName)) && (this.loadProductsFromFile(productsFileName)));
    }

    /**
     * This method attempts to load the customers from disk.<br>
     * @param customerFileName - The name of the database file for users.
     */
    private boolean loadCustomersFromFile(String customerFileName){
        boolean res = false;

        try {
            File myFile = new File(customerFileName);
            Scanner scan = new Scanner(myFile);

            if (scan.hasNext()) {
                int numCustomers = scan.nextInt(); // first int in file is the number of customers

                // iterate through customer details
                for (int index = 0; index < numCustomers; index++) {
                    int custID = scan.nextInt();
                    String name = scan.next();

                    Customer myCustomer = new Customer(name);
                    myCustomer.setId(custID);

                    int numPurchases = scan.nextInt();

                    // read purchases
                    for (int purchaseIndex = 0; purchaseIndex < numPurchases; purchaseIndex++) {
                        int purchaseID = scan.nextInt();
                        int customerID = scan.nextInt();
                        int productID = scan.nextInt();

                        Purchase myPurchase = new Purchase(customerID, productID);
                        myPurchase.setId(purchaseID);
                        this.purchaseList.add(myPurchase);

                        // add new purchase to customer's past-purchase list
                        myCustomer.setPastPurchases(myPurchase);
                    }

                    //add to customer to list
                    this.customersList.add(myCustomer);

                }

                scan.close();
                res = true;
            }
        }
        catch (Exception e){
                System.out.println("No such file");
        }
        return res;

    }

    /**
     * This method attempts to load the products from disk.<br>
     * @param productsFileName - The name of the database file for products.
     */
    public boolean loadProductsFromFile(String productsFileName){
        boolean res = false;

        try{
            File myFile = new File(productsFileName);
            Scanner scan = new Scanner(myFile);

            if (scan.hasNext()){
                int numProducts = scan.nextInt();

                //parse through each product
                for (int index = 0; index < numProducts; index++){
                    int id = scan.nextInt();
                    String name = scan.next();
                    String type = scan.next();
                    boolean isLarge = scan.nextBoolean();
                    double price = scan.nextDouble();
                    int sugarSpoons;
                    boolean isDairyFree;

                    Product myProduct;
                    if (scan.hasNextBoolean()) {
                        isDairyFree = scan.nextBoolean();
                        myProduct = new Coffee(name, type, isLarge, isDairyFree, price); // uses copy constructor
                        myProduct.setId(id);
                    }
                    else {
                        sugarSpoons = scan.nextInt();

                        myProduct = new Tea(name, type, isLarge,sugarSpoons, price);
                        myProduct.setId(id);
                    }
                    this.productList.add(myProduct);
                }
            }
            scan.close();
            res = true;

        }
        catch (Exception e){
            System.out.println("No such file");
        }
        return res;
    }

    /**
     * This method attempts to save the customers, products and purchases of the shop to disk.<br>
     * @param customersFileName - The name of the database file for customers.
     * @param productsFileName - The name of the database file for products.
     * @return Whether the content is saved or not.
     */
    public boolean saveContentToFile(String customersFileName, String productsFileName){
        boolean res = false;

        // create PrintWriter objects
        PrintWriter customersWriter;
        PrintWriter productsWriter;

        // try to save the content
        try {
            customersWriter = new PrintWriter(customersFileName, StandardCharsets.UTF_8);
            productsWriter = new PrintWriter(productsFileName, StandardCharsets.UTF_8);

            int size = this.customersList.size();
            customersWriter.println(size);
            for (int index = 0; index < size; index++){
                Customer myCustomer = this.customersList.get(index);
                String info = myCustomer.toString();
                customersWriter.print(info);
            }
            size = this.productList.size();
            productsWriter.println(size);
            for (int i = 0; i < size; i++){
                Product myProd = this.productList.get(i);
                String info = myProd.toString();
                productsWriter.print(info);
            }

            customersWriter.close();
            productsWriter.close();

            res = true;
        }
        catch (Exception e) {
            System.out.println("File cannot be created to write to");
        }

        return res;
    }
}
