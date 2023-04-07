public class Employee extends Person{
    
    public Employee(){}

    public void printCustomerListSingleton(){
        CustomerListSingleton cls = CustomerListSingleton.getInstance();
        cls.printData();
        
    }

    public void printFlightFeeSingleton(){
        FlightFeeSingleton ffs = FlightFeeSingleton.getInstance();
        ffs.printData();
        
    }

}
