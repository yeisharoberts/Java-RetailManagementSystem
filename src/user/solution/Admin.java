
package user.solution;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Admin extends User{
    
    private String adminID;
    
    // used to call logging activity method in user class
    public Admin(){
    }
    

    //overload constructor
    public Admin(String adminID,String username, String password) {
        super(username, password);    
        this.adminID = adminID;
    }
    
    // to string
    @Override
    public String toString() {
        return "Admin{" + "adminID=" + adminID + '}';
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }
    
    // method to add new customer acc
    public int addCustomerData(String customerID,String name, String username, String pass, 
                         String gender, String phoneNum, String email, String address)
    {
        boolean valid = false;
        File f = new File("CustomerData.txt");

        // When file doen't exists & Create a file
        try {
            if(!f.exists()){
                f.createNewFile();
             }
        } catch(IOException Ex){
            System.out.println("File Error");
        }
        
        // When file exist
        try{
            Scanner scan = new Scanner(f);
            while(scan.hasNextLine())
            {
                String line = scan.nextLine();
                if(line.contains(username)&& line.contains(email)){
                    // data already exist
                    valid = true;
                    break;                
                }
            }
            scan.close();
        }catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        if(valid == false){
            Customer cus = new Customer(customerID, name ,username, pass, gender, phoneNum, email, address);
            cus.getInfo();
            return 1;
        }
        else
        {
            // record exist
            return 2;
        }
    
    }
    

  
    // method to modify customer information
    public void modifyCustomer(String customerID, String name, String username, 
           String password,String gender,String phoneNum, String email,String address)
    {
        File f = new File("CustomerData.txt");
        String details = "";
        
        //Match the Customer ID to modify
        Scanner data;
        try {
            data = new Scanner(f);
            while(data.hasNextLine())
           {
            String line = data.nextLine();
            String[] cusLine = line.split("\t");
                
            if(cusLine[0].startsWith(customerID))
            {
                //Modify Customer info
                Customer modiCustomer = new Customer(customerID, name,username,
                                      password,gender,phoneNum,email,address);
                //Replace record
                details += modiCustomer.toString()+"\n";   
            }
            else {
                details += line +"\n";   
                }
            }
            data.close();
                       
            try {
                FileWriter fw = new FileWriter (f,false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.write(details);
                bw.close();
                pw.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Verify that customer changes have been made
    public int validateModiCusChanges(String customerID, String name, String username, 
           String password,String gender,String phoneNum, String email,String address){
        
        boolean valid = false;
        File f = new File("CustomerData.txt");
      
        //Match the Customer ID to modify
        try {
              Scanner scan = new Scanner(f);
              while(scan.hasNextLine())
             {
                String line = scan.nextLine();
                String[] cusLine = line.split("\t");
                
                if(cusLine[0].equals(customerID)&& cusLine[1].equals(name)&& cusLine[2].equals(username)&&cusLine[3].equals(password)
                    &&cusLine[4].equals(gender)&&cusLine[5].equals(phoneNum)&&cusLine[6].equals(email) &&cusLine[7].equals(address))
                {
                    valid=true;
                    break;
                } 
             }
             scan.close();
        }catch(Exception e){}
       
        if(valid == false){
            modifyCustomer( customerID,  name,  username, password, gender, phoneNum, email,address);
        }
        else{
            return 1;
        }
        return 0;

    }
    
//      method to delete specific record
    public void removeRecord(String file, String removeTerm, int termPosition, String delimiter)
    {
        int position = termPosition - 1;
        String tempFile = "temp.txt";
        File oldFile = new File(file);
        File newFile = new File(tempFile);  
          
        String currentLine;
        String data[];
          
        try
        {
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
             
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
             
            while((currentLine = br.readLine())!= null)
            {
                data = currentLine.split("\t");
                if(!data[position].equalsIgnoreCase(removeTerm))
                {
                    pw.println(currentLine);
                }
            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();
            
            oldFile.delete();
            File dump = new File(file);
            newFile.renameTo(dump);
                                                                                                   
            }catch(Exception e){}
      }      
        
    public int addProduct(String productID, String productName, String category,
                        String material, int quantity, double price, String proDesc)
    {
        boolean valid = false;
        File f = new File("Product.txt");           

        // When file doen't exists & Create a file
        try {          
            if(!f.exists()){
                f.createNewFile();
             }
        } catch(IOException Ex){
            System.out.println("File Error");
        }
        
        // the file is exist and check the product existance
        try{
            Scanner scan = new Scanner(f);
            while (scan.hasNextLine())
           {
               String line = scan.nextLine();
                if (line.contains(productName))
                {
                    // the data is exist already
                    valid=true;
                    break;
                }
            }
            scan.close();
        }catch(IOException Ex) {}      
            
            // the data does not exist in the file
        if(valid == false)
        {
            Product pd = new Product( productID, productName, category, material, quantity, price,proDesc);
            pd.getInfo();
            return 1;
        }else{
             // show error (record exist)
            return 0;
        }                
    }

    // method to modify product information
    public void modifyProduct(String productID, String productName, String category, String material, 
            int quantity, double price,String proDesc)
    {
        File f = new File("Product.txt");
        String details = "";
        
        //Match the Customer ID to modify
        Scanner data;
        try {
            data = new Scanner(f);
            while(data.hasNextLine())
           {
            String line = data.nextLine();
            String[] proLine = line.split("\t");
                
            if(proLine[0].startsWith(productID))
            {
//                if(!proLine[1].equals(productName)||!proLine[2].equals(category)||!proLine[2].equals(category)  )
                //Modify Customer info
                Product modifyProduct = new Product(productID,productName, category,material, 
                                                     quantity, price,proDesc);
                //Replace record
                details += modifyProduct.toString()+"\n";   
            }
            else {
                details += line +"\n";   
                }
            }
            
            
            data.close();
                       
            try {
                FileWriter fw = new FileWriter (f,false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.write(details);
                bw.close();
                pw.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Verify that product changes have been made
    public int validateModiProChanges(String productID, String productName, String category, String material, 
            int quantity, double price,String proDesc){
        
        boolean valid = false;
        File f = new File("Product.txt");
        //Check did the data still the same
        try {
            Scanner scan = new Scanner(f);
            while(scan.hasNextLine())
           {
                String line = scan.nextLine();
                String[] proLine = line.split("\t");
                
                if(proLine[0].equals(productID)&& proLine[1].equals(productName)&& proLine[2].equals(category)&& proLine[3].equals(material)
                    &&proLine[4].equals(String.valueOf(quantity))&& proLine[5].equals(String.valueOf(price))&& proLine[6].equals(proDesc))
                {
                    valid=true;
                    break;
                } 
           }
           scan.close();
        }catch(Exception e){}
       
        if(valid == false){
            modifyProduct(productID, productName, category, material, quantity, price, proDesc);
        }
        else{
            return 1;
        }
        return 0;

    }
    public double calcProductTotal(String prodName){
        
        String filepath = "orders.txt";    
        String currentLine;
        File file = new File(filepath);

        double amount = 0.00;

        
        try{
            Scanner scan = new Scanner(file);
            
            while(scan.hasNext()){
                String line = scan.nextLine();
                String[] values = line.split("\t");
                
                if(values[2].equalsIgnoreCase(prodName)){
                   amount += Double.parseDouble(values[8]);
                  
                }
            }          

        }catch(Exception e){
            
        }  
        return amount;
    }
    
    public double calcProdQuantity(String prodName){
        
        String filepath = "orders.txt";    
        String currentLine;
        File file = new File(filepath);

        int quantity = 0;
      
        try{
            Scanner scan = new Scanner(file);
            
            while(scan.hasNext()){
                String line = scan.nextLine();
                String[] values = line.split("\t");
                
                if(values[2].equalsIgnoreCase(prodName)){
                   quantity += Integer.valueOf(values[5]);                
                }
                
            }          

        }catch(Exception e){
            
        }  
        return quantity;
    }
    
    public double calcEarnings(){
        
        String filepath = "orders.txt";    
        String currentLine;
        File file = new File(filepath);

        double earnings = 0;
        double temp = 0;
      
        try{
            Scanner scan = new Scanner(file);
            
            while(scan.hasNext()){
                String line = scan.nextLine();
                String[] values = line.split("\t");
                
                earnings += Double.parseDouble(values[8]);                
                
                
            }          

        }catch(Exception e){
            
        }  
        return earnings;
    }
    
    public String getCustInfo(String cusName, int num){
        Customer cus = new Customer();
     
        String filepath = "CustomerData.txt";    
        String currentLine;
        File file = new File(filepath);
        String value = "";
        
        
        try{
            Scanner scan = new Scanner(file);
            
            while(scan.hasNext()){
                String line = scan.nextLine();
                String[] values = line.split("\t");
                
                if(values[1].equalsIgnoreCase(cusName)){
                   cus.setAddr(values[7]);
                   cus.setPhoneNum(values[5]);
                   cus.setEmail(values[6]);
                }          
            }     
        }catch(Exception e){
            
        } 
       
        if(num == 1){
            value = cus.getAddr();
        }else if(num == 2){
            value = cus.getPhoneNum();
        }else{
            value = cus.getEmail();
        }

        return value;
    }
    
    public boolean findPurchase(String prodName){
        
        boolean isPurchased = false;
        
        String filepath = "order.txt";    
        String currentLine;
        File file = new File(filepath);

        try{
            Scanner scan = new Scanner(file);
            
            while(scan.hasNext()){
                String line = scan.nextLine();
                String[] values = line.split("\t");
                
                if(values[2].equalsIgnoreCase(prodName)){
                   isPurchased = true; 
                }
            }          

        }catch(Exception e){
            
        } 
            
        return isPurchased;
    }
    
    public void writeFile(String productID,String productName,String productCategory,String productMaterial,
            int productQuantity, double productPrice, double productTotal, String productDescription){
        
        // Create a file
        int lineCount = 0;
        
        try{               
            File f = new File("order.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
            PrintWriter pw = new PrintWriter(bw);
            BufferedReader br = new BufferedReader(new FileReader(f));
            
            Order order = new Order();
            order.generateOrderID();
            
            boolean isFound = order.isFoundID(order.getOrderID());
            
            if(isFound == false){      
                pw.write(""+order.getOrderID()+"\t"+productID+"\t"+productName+"\t"+productCategory+"\t"+productMaterial+"\t"+
                        productQuantity+"\t"+productPrice+"\t"+productDescription+"\t"+productTotal);
            }
            
            bw.newLine();
            pw.close();
            bw.close();
        }
        catch (IOException ex) {
            System.out.println("Error");
        }
    }
    
    public void deleteOrder(String removeOrder){
        int positionOfTerm = 1;
        String delimeter = "\t";
        int position = positionOfTerm - 1;
  
        String filepath = "order.txt";
        String tempFile = "temp.txt";
        File newFile = new File(tempFile);
        File oldFile = new File(filepath);
        
        String currentLine;
        String data[];
        
        try{
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            
            while((currentLine = br.readLine()) != null){
                data = currentLine.split("\t");
                if(!(data[0].equalsIgnoreCase(removeOrder))){
                    pw.println(currentLine);
                }
            }
            
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();
            
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
            
        }catch(Exception e){
            
        }
        
    }
    
    public void modifyProduct(String orderID,String productID,String productName,String productCategory,String productMaterial,
            int quantitySelected,double productPrice,String productDesc,double total, int quantityEdit)
    {
        File f = new File("order.txt");
        String details = "";
        
        //Match the Customer ID to modify
        Scanner data;
        try {
            data = new Scanner(f);
            while(data.hasNextLine())
           {
            String line = data.nextLine();
            String[] orderLine = line.split("\t");
            String str = "";
           
            if(orderLine[0].startsWith(orderID))
            {
//                if(!proLine[1].equals(productName)||!proLine[2].equals(category)||!proLine[2].equals(category)  )
                //Modify Customer info
                
                //Replace record
                details += orderID+"\t"+productID+"\t"+productName+"\t"+productCategory+"\t"+productMaterial+"\t"+
                        quantityEdit+"\t"+productPrice+"\t"+productDesc+"\t"+total+"\n";   
            }
            else {
                details += line +"\n";   
                }
            }
            
            
            data.close();
                       
            try {
                FileWriter fw = new FileWriter (f,false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.write(details);
                bw.close();
                pw.close();
                
            } catch (IOException ex) {
                System.out.println(ex);
                }
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
        
    public int validateModiProChanges(String orderID,String productID,String productName,String productCategory,String productMaterial,
            int quantitySelected,double productPrice,String productDesc,double total, int quantityEdit){
        
        boolean valid = false;
        File f = new File("order.txt");
        //Check did the data still the same
        try {
            Scanner scan = new Scanner(f);
            while(scan.hasNextLine())
           {
                String line = scan.nextLine();
                String[] orderLine = line.split("\t");
                
                if(orderLine[0].equals(orderID)&& orderLine[1].equals(productID)&& orderLine[2].equals(productName)&& orderLine[3].equals(productCategory)
                    && orderLine[4].equals(String.valueOf(productMaterial))&& orderLine[5].equals(String.valueOf(quantityEdit))&& 
                        orderLine[6].equals(String.valueOf(productPrice)) && orderLine[7].equals(productDesc) &&
                        orderLine[8].equals(String.valueOf(total)))
                {
                    valid=true;
                    break;
                } 
           }
           scan.close();
        }catch(Exception e){}
       
        if(valid == false){
            modifyProduct(orderID,productID,productName,productCategory,productMaterial,
            quantitySelected,productPrice,productDesc,total,quantityEdit);
        }
        else{
            return 1;
        }
        return 0;

    }
    
    public boolean search(String toFind){
        
        String filepath = "Product.txt";    
        String currentLine;
        File file = new File(filepath);
        
                
        boolean found = false;
        try{
            Scanner scan = new Scanner(file);
            
            while(scan.hasNext()){
                String line = scan.nextLine();
                String[] values = line.split("\t");
                
                if(values[1].equalsIgnoreCase(toFind)){
                   found = true; 
                }
            }          

        }catch(Exception e){
            
        } 
     
        return found;
    }   
     
}

