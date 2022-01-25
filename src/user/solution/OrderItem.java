package user.solution;

import java.io.File;
import java.util.Scanner;

public class OrderItem{
    
    private int productQuantity;
    private double productPrice;
    private double productTotal;
    
    //Constructor
    public OrderItem(int initQuantity, double initPrice, double initTotal){
        setProductQuantity(initQuantity);
        setProductPrice(initPrice);
        setProductTotal(initTotal);
    }
    
    public OrderItem(int initQuantity, double initPrice){
        setProductQuantity(initQuantity);
        setProductPrice(initPrice);
    }

    public OrderItem() {
        
    }
    //Getter 
    public int getProductQuantity(){
        return productQuantity;
    }
    public double getProductPrice(){
        return productPrice;
    }
    public double getProductTotal(){
        return productTotal;
    }
    //Setter
    public void setProductQuantity(int newQuantity){
        this.productQuantity = newQuantity;
    }
    public void setProductPrice(double newPrice){
        this.productPrice = newPrice;
    }
    public void setProductTotal(double newTotal){
        this.productTotal = newTotal;
    }
    
    
    //toString
    public String toString(){
        String str = "";
        str += "Quantity is: " + productQuantity;
        str += "\nPrice is: " + productPrice;
        str += "\nTotal is: " + productTotal;
        return str;
    }
    
    public void findTotal(double price, int quantity){
        double total = price * quantity;
        setProductTotal(total);
    }
    
    
    public void calcTotal(double total){
        
        double tots = getProductTotal();
        
        tots += total;
        
        setProductTotal(tots);
    }
    
    
}
