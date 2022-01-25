package user.solution;

import java.io.File;
import java.util.Random;
import java.util.Scanner;


public class Order extends Product{
 
    private OrderItem orderItem;
    
    private String orderID;
    private String orderShipTo;
    private double subTotal;

  //constructor  
    public Order(){
        orderItem = new OrderItem();
    }
    public Order(String initOrderID, String initOrderShipTo, double initSubTotal){
        setOrderID(initOrderID);
        setOrderShipTo(initOrderShipTo);
        setSubTotal(initSubTotal);
    }
    
    //toString method
    public String toString(){
        String str = "";
        str += "Order ID: " + getOrderID();
        str += "\nOrder Ship To: " + getOrderShipTo();
        str += "\nSub Total is: " + getSubTotal();
        return str;
    }
    
    //setter
    public void setOrderID(String newOrderID){
        this.orderID = newOrderID;
    }
    public void setOrderShipTo(String newOrderShipTo){
        this.orderShipTo = newOrderShipTo;
    }
    public void setSubTotal(double newSubTotal){
        this.subTotal = newSubTotal;
    }

    //getter
    public String getOrderID(){
        return orderID;
    }
    public String getOrderShipTo(){
        return orderShipTo;
    }
    
    public void generateOrderID(){
            String str = "";
            
            Random rand = new Random();
            int upperbound = 1000;
            int intRandom = rand.nextInt(upperbound);
            
            str = "O" + String.format("%03d",intRandom); 
            
            setOrderID(str);
    }
    
    
    public boolean isFoundID(String orderID){
        String filepath = "orders.txt";    
        String currentLine;
        File file = new File(filepath);
                      
        boolean found = false;
        
        try{
            Scanner scan = new Scanner(file);
            
            while(scan.hasNext()){
                String line = scan.nextLine();
                String[] values = line.split("\t");
                
                if(values[0].equals(orderID)){
                   found = true; 
                }
            }          

        }catch(Exception e){
            
        } 
     
        return found;
    }
    
    public double getSubTotal(){
        return subTotal;
    }
   
}
