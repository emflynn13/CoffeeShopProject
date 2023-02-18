import java.util.ArrayList;

public abstract class Product extends Agent{
    protected final String name;
    protected final String type;
    protected final boolean isLarge;

    // ------------
    // Constructors
    // ------------

    /**
     * The default constructor creates 1 instance (1 object) of the class Product<br>
     */
    public Product(){
        super();
        name = null;
        type = null;
        isLarge = false;
    }

    /**
     * The constructor creates 1 instance (1 object) of the class Product<br>
     * @param _name - The name of the product.
     * @param _type - The type of product.
     * @param _isLarge - The size of the product.
     */
    public Product(String _name, String _type, boolean _isLarge){
        super();  // call to agent for id
        this.name = _name;
        this.type = _type;
        this.isLarge = _isLarge;

    }

    /**
     * Given a concrete product (this), the function returns the name of the product
     * @return the name of the product
     */
    public String getName(){
        return name;
    }

    /**
     * Given a concrete product (this), the function returns the type of the product
     * @return the type of the product
     */
    public String getType(){
        return type;
    }

    /**
     * Given a concrete product (this), the function returns the size of the product
     * @return the size of the product
     */
    public boolean getIsLarge(){
        return isLarge;
    }

    /**
     * Given a concrete product (this), the function sets the price of the product
     */
    public abstract void setPrice(double _price);


    /**
     * Given a concrete product (this), the function gets the price of the product
     */
    public abstract double getPrice();



    /**
     * This method attempts to find it a product is in the productList<br>
     * @param id - The id of the product.
     * @param newList - The list of products where we are looking.
     * @return The index in newList where the product with id is located at; (-1) if it is not in the list.
     */
    public static int isProductInProductList(int id, ArrayList<Product> newList){
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
     * Given a concrete product (this), the function overrides the Object method toString.<br>
     */
    public String toString(){
        return "" + super.ID + "\t" + name + "\t" + type + "\t" + isLarge + "\t";

    }

}
