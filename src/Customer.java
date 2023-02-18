import java.util.ArrayList;

/**
 * This class models a customer of the shop
 */
public class Customer extends Agent {

    private final String name;

    private final ArrayList<Purchase>pastPurchases;

    // constructor
    /**
     * The constructor creates 1 instance (1 object) of the class User<br>
     * @param _name - The name of the customer.
     */
    public Customer(String _name) {
        super();  // call to super for id
        this.name = _name;
        this.pastPurchases = new ArrayList<>();
    }

    /**
     * Given a concrete customer (this), the function returns a list of the past purchases of the customer.<br>
     * @return pastPurchases - A list of the past purchases of the customer.
     */
    public ArrayList<Purchase> getPastPurchases(){
        return pastPurchases;
    }

    /**
     * Given a concrete customer (this), the function adds a new purchase to the customers purchase list.<br>
     * @param newPurchase - The name of the customer.
     */
    public void setPastPurchases(Purchase newPurchase){
        pastPurchases.add(newPurchase);
    }

    /**
     * This method attempts to find if a customer is in the customersList<br>
     * @param id - The id of the user.
     * @param newList - The list of users where we are looking for.
     * @return The index in myList where the agent with id is located at; (-1) if it is not in the list.
     */
    public static int isCustomerInCustomerList(int id, ArrayList<Customer> newList){
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

    /**
     * Given a concrete customer (this), the function overrides the Object method toString.<br>
     */
    public String toString(){
        int numPurchases = this.pastPurchases.size();
        String res = "" + super.ID + "\t" + name + "\t" + numPurchases + "\n" ;

        for (Purchase pastPurchase : this.pastPurchases)
            res += pastPurchase.toString();

        return res;
    }
}
