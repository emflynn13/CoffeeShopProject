public class Coffee extends Product{

    private final boolean dairyFree;
    private double price;

    // default constructor
    /**
     * The default constructor creates 1 instance (1 object) of the class Coffee<br>
     */
    public Coffee(){
        super();
        dairyFree = false;
        price = 0;
    }

    // constructor
    /**
     * The constructor creates 1 instance (1 object) of the class Product<br>
     * @param _name - The name of the product.
     * @param _type - The type of product.
     * @param _isLarge - The size of the product.
     * @param _dairyFree - The size of the product.
     */
    public Coffee(String _name, String _type, boolean _isLarge, boolean _dairyFree){
        super(_name, _type, _isLarge);
        this.dairyFree = _dairyFree;
    }

    // copy constructor, used when loading info from disk and price is already set
    /**
     * The constructor creates 1 instance (1 object) of the class Coffee<br>
     * @param _name - The name of the coffee.
     * @param _type - The type of coffee.
     * @param _isLarge - The size of the coffee.
     * @param _dairyFree - The size of the coffee.
     * @param _price - The price of the coffee.
     */
    public Coffee(String _name, String _type, boolean _isLarge, boolean _dairyFree, double _price){
        super(_name, _type, _isLarge);
        this.dairyFree = _dairyFree;
        this.price = _price;
    }

    /**
     * Given a concrete coffee (this), the function returns whether is it dairy free or not
     */
    public boolean getdairyFree(){
        return dairyFree;
    }


    /**
     * Given a concrete product (this), the function sets the price of the product
     */
    public void setPrice(double _price){
        price = _price;
    }

    /**
     * Given a concrete product (this), the function gets the price of the product
     */
    @Override
    public double getPrice() {
        if (isLarge)
            price = 5.55;
        else
            price =  4.65;
        return price;
    }

    /**
     * Given a concrete coffee (this), the function overrides the Object method toString.<br>
     */
    public String toString(){
        return super.toString() + "\t" + price + "\t" + dairyFree + "\n";


    }


}
