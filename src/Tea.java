public class Tea extends Product{
    // field
    private int sugarSpoons;
    private double price;

    // default constructor
    /**
     * The default constructor creates 1 instance (1 object) of the class Tea<br>
     */
    public Tea(){
        super();
        sugarSpoons = 0;
        price = 0;
    }

    // constructor
    /**
     * The constructor creates 1 instance (1 object) of the class Product<br>
     * @param _name - The name of the product.
     * @param _type - The type of product.
     * @param _isLarge - The size of the product.
     * @param _sugar - The size of the product.
     */
    public Tea(String _name, String _type, boolean _isLarge, int _sugar){
        super(_name, _type, _isLarge);
        this.sugarSpoons = _sugar;

    }
    // copy constructor, used when loading info from disk and price is already set
    /**
     * The constructor creates 1 instance (1 object) of the class Tea<br>
     * @param _name - The name of the tea.
     * @param _type - The type of tea.
     * @param _isLarge - The size of the tea.
     * @param _sugar - The size of the tea.
     * @param _price - The price of the tea .
     */
    public Tea(String _name, String _type, boolean _isLarge, int _sugar, double _price){
        super(_name, _type, _isLarge);
        this.sugarSpoons = _sugar;
        this.price = _price;

    }

    /**
     * Given a concrete tea (this), the function returns the number of sugar spoons in the tea
     * @return sugarSpoons - the number of sugar spoons in the tea
     */
    public int getSugarSpoons(){
        return sugarSpoons;
    }

    /**
     * Given a concrete tea (this), the function set the number of sugar spoons in the tea
     * @param _sugarSpoons - number of sugar spoons in the tea
     */
    public void setSugarSpoons(int _sugarSpoons){
        this.sugarSpoons  = _sugarSpoons;
    }

    /**
     * Given a concrete tea (this), the function sets the price of the tea
     */
    public void setPrice(double _price){
        this.price = _price;
    }

    /**
     * Given a concrete tea (this), the function gets the price of the tea
     */
    public double getPrice() {
        price =  3.75;
        return price;
    }

    /**
     * Given a concrete tea (this), the function overrides the Object method toString.<br>
     */
    public String toString(){
        return super.toString() + "\t" + price + "\t" + sugarSpoons + "\n";
    }
}
