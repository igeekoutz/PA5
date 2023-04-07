import java.util.HashMap;

public class FlightFeeSingleton {
    
    private HashMap<Integer, Double> data;
    private static FlightFeeSingleton obj;
    
    private FlightFeeSingleton(){}
    
    /**
     * @return
     */
    public static FlightFeeSingleton getInstance(){
        if(obj == null){
              obj = new FlightFeeSingleton();
           }return obj;
       }
    
      
      /**
     * @return
     */
    public HashMap<Integer, Double> getData(){
          return data;
      }
      /**
     * @param data
     */
    public void setData(HashMap<Integer, Double> data){
         this.data = data;
    }
    
      /**
     * 
     */
    public void printData(){
          System.out.println(this.data);
      }
}
    
    

