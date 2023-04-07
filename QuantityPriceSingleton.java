public class QuantityPriceSingleton {
    private double seatPrice;
    private int quantity;
    private static QuantityPriceSingleton obj;


    private QuantityPriceSingleton(){}

    public static QuantityPriceSingleton getInstance(){
        if(obj == null){
            obj = new QuantityPriceSingleton();
        }return obj;
    }

  

    /**
     * @return
     */
    public double getSeatPrice(){
        return seatPrice;
    }
    /**
     * @param data
     */
    public void setSeatPrice(double data){
        this.seatPrice = data;
    }

    /**
     * @return
     */
    public int getQuantity(){
        return quantity;
    }
    /**
     * @param data
     */
    public void setQuantity(int data){
        this.quantity = data;
    }

    public void printQuantity(){
        System.out.println(this.quantity);
    }public void printSeatPrice(){
        System.out.println(this.seatPrice);
    }


}
