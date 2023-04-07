import java.util.HashMap;

public class CustomerListSingleton {
    private HashMap<String, String> data = new HashMap<>();
    private static CustomerListSingleton obj;
    //    private static Singleton2 obj;


    private CustomerListSingleton(){}

    public static CustomerListSingleton getInstance(){
        if(obj == null){
            obj = new CustomerListSingleton();
        }return obj;
    }

  

    public HashMap<String, String> getData(){
        return data;
    }public void setData(HashMap<String, String> data){
        this.data = data;
    }

    public void printData(){
        System.out.println(this.data);
    }


}