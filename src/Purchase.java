import java.util.ArrayList;

/**
 * This class models a purchase for the shop<br>.
 */
public class Purchase extends Agent{

    private int purchaseID;
    private final int customerID;
    private final int productID;



    /**
     * The constructor creates 1 instance (1 object) of the class Purchase<br>
     * This constructor is used when the purchase ID is already known
     * @param _purchaseID - The ID of the purchase.
     * @param _customerID - The ID of the customer.
     * @param _productID - The ID of the product.
     */
    public Purchase(int _purchaseID, int _customerID, int _productID){
        super.setId(_purchaseID);
        this.purchaseID = _purchaseID;
        this.customerID = _customerID;
        this.productID = _productID;
    }

    /**
     * The constructor creates 1 instance (1 object) of the class Purchase<br>
     * This constructor is used when the purchase ID needs to be created
     * @param _custID - The ID of the customer.
     * @param _prodID - The ID of the product.
     */
    public Purchase(int _custID, int _prodID){
        super();
        this.customerID = _custID;
        this.productID = _prodID;
    }

    /**
     * Given a concrete purchase (this), the function returns the ID
     * @return the id of the item
     */
    public int getPurchaseID(){
        return super.getId();
    }



    /**
     * Given a concrete purchase (this), the function overrides the Object method toString.<br>
     */
    public String toString(){
        return "" + super.getId() + "\t" + productID + "\t" + customerID + "\n";
    }

    /**
     * This method attempts to find it a purchase is in the purchaseList<br>
     * @param id - The id of the purchase.
     * @param newList - The list of purchases where we are looking.
     * @return The index in newList where the purchase with id is located at; (-1) if it is not in the list.
     */
    public static int isPurchaseInPurchaseList(int id, ArrayList<Purchase> newList){
        int res = -1;
        int i = 0;

        while ((res == -1) && (i < newList.size())){
            if (id == newList.get(i).getId())
                res = i;
            else
                i++;

        }
        return res;

    }

}
