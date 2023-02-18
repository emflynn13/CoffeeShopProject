public interface CoffeeShop {

    /**
     * This method attempts to add a customer to the coffee shop<br>
     * @param _name - The name of the customer.
     * @return The id of the customer created.
     */
    int addCustomer(String _name);

    /**
     * This method attempts to remove a customer from the coffee shop<br>
     * @param _customerId - The id of the user.
     * @return (-1) if user does not exist; else 0 if removed.
     */
    int removeCustomer(int _customerId);


    /**
     * This method attempts to display customer info to the screen<br>
     * @param _customerID - The id of the user.
     */
    void displayCustomerInfo(int _customerID);

    /**
     * This method displays all customerIDs to the screen<br>
     */
    void displayAllCustomerIDs();

    /**
     * This method attempts to add a coffee to the shop<br>
     * @param _name - The name of the coffee.
     * @param _type - The type of coffee.
     * @param _isLarge - The size of the coffee, small or large.
     * @param _dairy_free - Whether the coffee is dairy free or not
     * @return The id of the coffee created.
     */
    int addCoffee(String _name, String _type, boolean _isLarge, boolean _dairy_free);

    /**
     * This method attempts to add a tea to the shop<br>
     * @param _name - The name of the tea.
     * @param _type - The type of tea.
     * @param _isLarge - The size if the tea.
     * @param sugarSpoons - The number of sugar spoons in the tea.
     * @return The id of the tea created.
     */
    int addTea(String _name, String _type, boolean _isLarge, int sugarSpoons);

    /**
     * This method attempts to remove a product from the store<br>
     * @param _prodId - The id of the product.
     * @return Whether the product could be removed or not.
     */
    boolean removeProduct(int _prodId);

    /**
     * This method attempts to display the product info to the screen<br>
     * @param _prodID - The id of the product.
     */
    void displayProduct(int _prodID);

    /**
     * This method displays all productIDs to the screen<br>
     */
    void displayAllProductIDs();

    /**
     * This method attempts to purchase an item of the store<br>
     * @param _customerID - The id of the customer buying the item.
     * @param _prodID - The id of the item to be purchased.
     * @return The id of the purchase being performed (-1 if not possible to purchase).
     */
    int purchaseProduct(int _customerID, int _prodID);

    /**
     * This method attempts to display the purchase info to the screen<br>
     * @param _purchaseID - The id of the purchase.
     */
    void displayPurchaseInfo(int _purchaseID);

    /**
     * This method displays all purchaseIDs to the screen<br>
     */
    void displayAllPurchaseIDs();

    /**
     * This method attempts to load the customers, products and purchases of the shop from disk.<br>
     * @param customersFileName - The name of the database file for customer.
     * @param productsFileName - The name of the database file for products.
     * @return Whether the content is loaded or not.
     */
    boolean loadContentFromDisk(String customersFileName, String productsFileName);

    /**
     * This method attempts to save the customers, products and purchases of the shop to disk.<br>
     * @param customersFileName - The name of the database file for customers.
     * @param productsFileName - The name of the database file for products.
     * @return Whether the content is saved or not.
     */
    boolean saveContentToFile(String customersFileName, String productsFileName);
}
