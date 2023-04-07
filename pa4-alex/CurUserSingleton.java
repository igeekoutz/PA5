public class CurUserSingleton {
    private Customer curCustomer;
    private Employee curEmployee;
    private static CurUserSingleton obj;
    private String curUserType;

    /**
     * Default constructor
     */
    private CurUserSingleton() {
    }

    /**
     * Constructor to create an instance of the singleton and return the singelton
     * 
     * @return CurUserSingleton returns the object
     */
    public static CurUserSingleton getInstance() {
        if (obj == null) {
            obj = new CurUserSingleton();
        }
        return obj;
    }

    /**
     * Sets the current customer object and the current user type
     * 
     * @param userIn Customer object
     */
    public void setCustomer(Customer userIn) {
        this.curCustomer = userIn;
        setCurUserType("Customer");
    }

    /**
     * Returns the current customer object
     * 
     * @return Customer Object
     */
    public Customer getCustomer() {
        return this.curCustomer;
    }

    /**
     * Sets the current employee object and the current user type
     * 
     * @param userIn Employee object
     */
    public void setEmploye(Employee userIn) {
        this.curEmployee = userIn;
        setCurUserType("Employee");
    }

    /**
     * Returns the current employee object
     * 
     * @return Employee object
     */
    public Employee getEmployee() {
        return this.curEmployee;
    }

    /**
     * Sets the current user type
     * 
     * @param userTypeIn Current user type
     */
    private void setCurUserType(String userTypeIn) {
        this.curUserType = userTypeIn;
    }

    /**
     * Returns the current user type
     * 
     * @return String Current user type
     */
    public String getCurUserType() {
        return this.curUserType;
    }
}
