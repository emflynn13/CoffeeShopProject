public class Agent {

    protected int ID;
    //fields
    private static int id = 1;


    // -----------
    // constructor
    // -----------

    /**
     * The default constructor creates 1 instance (1 object) of the class Agent<br>
     */
    public Agent(){
        this.ID = id;
        ++id; // increase value of static id variable for next agent created
    }

    /**
     * Given a concrete agent (this), this function sets its ID
     * @param _id - the id the agent
     */
    public void setId(int _id){
        this.ID = _id;
    }


    //get method

    /**
     * Given a concrete agent (this), this function returns its ID
     * @return the id id the agent
     */
    public int getId(){
        return ID;
    }


    /**
     * Given a concrete agent (this), the function overrides the Object method equals.<br>
     * @param i - The other agent we want to compare 'this' to.
     * @return - Whether 'this' and 'i' are equal.
     */
    public boolean equals(Agent i) {
        return this.ID == i.ID;
    }



}
