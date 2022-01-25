

package user.solution;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Product implements Information {
    private String productID, productName, category, material, proDesc;
    private int quantity;
    private double price;
    
    // overload constructor
    public Product(){
        
    }
    
    public Product(String productID, String productName, String category, String material, 
            int quantity, double price,String proDesc)
    {
        this.productID= productID;
        this.productName = productName;
        this.category = category;
        this.material = material;
        this.quantity = quantity;
        this.price= price;
        this.proDesc = proDesc;
        
    }
 
    @Override
    public String toString() {
//        return "Product{" + "productID=" + productID + ", productName=" + productName + ", category=" + category + ", material=" + material + ", proDesc=" + proDesc + ", quantity=" + quantity + ", price=" + price + '}';
        return getProductID()+"\t"+ getProductName()+"\t"+ getCategory()+"\t"+ getMaterial()+"\t"+ getQuantity()+"\t"+ getPrice()+"\t"+ getProDesc();

    }

    
    // Getter & Setter
    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {    
        this.proDesc = proDesc;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
  
    @Override
   public void getInfo(){
        try{
            File f = new File("Product.txt");
   
            BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
            PrintWriter pw = new PrintWriter(bw);

            pw.write(""+productID+"\t"+productName+"\t"+category+"\t"+material+"\t"+quantity+"\t"+price+"\t"+proDesc);
            bw.newLine();
            pw.close();
            bw.close();
        }
        catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}
