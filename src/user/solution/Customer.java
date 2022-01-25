
package user.solution;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Customer extends User implements Information{

    private String customerID, name, gender, email, phoneNum,addr;
    
    // Overload Constructor 
    
    public Customer(){
        
    }
    
    public Customer(String username, String password){
        super(username,password);
    }
    
    public Customer (String customerID, String name ,String username, String password, String gender,  
            String phoneNum, String email, String addr) {
        super(username, password);
        this.customerID = customerID;
        this.name = name;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.email = email;
        this.addr = addr;
    }

    @Override
    public String toString() {
        return getCustomerID()+"\t"+ getName()+"\t"+ getUsername()+"\t"+ getPassword()+"\t"+ getGender()+"\t"+ getPhoneNum()+"\t"+ getEmail()+"\t"+ getAddr();
    }
    
    // Getter & Setter
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    
      public String getName() {
        return name;
    }


    public void setName(String name) {    
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    
    // Method to add customer info (register)
    public int customerData(String customerID,String name, String username, String pass, 
                         String gender, String email, String phoneNum, String address)
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
    
    @Override
   public void getInfo(){
        try{
            File f = new File("CustomerData.txt");

            BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
            PrintWriter pw = new PrintWriter(bw);

            pw.write(""+getCustomerID()+"\t"+ getName()+"\t"+ getUsername()+"\t"+ getPassword()+"\t"+ getGender()+"\t"+ getPhoneNum()+"\t"+ getEmail()+"\t"+ getAddr());
            bw.newLine();
            pw.close();
            bw.close();
        }
        catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                        productQuantity+"\t"+productPrice+"\t"+productDescription+"\t"+productTotal+"\t");
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
    
    public boolean search(String toFind){
        
        String filepath = "products.txt";    
        String currentLine;
        File file = new File(filepath);
        
                
        boolean found = false;
        try{
            Scanner scan = new Scanner(file);
            
            while(scan.hasNext()){
                String line = scan.nextLine();
                String[] values = line.split("\t");
                
                if(values[0].equalsIgnoreCase(toFind)){
                   found = true; 
                }
            }          

        }catch(Exception e){
            
        } 
     
        return found;
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
    
    public void setSessionDetails(String session){
        
        
        String filepath = "CustomerData.txt";    
        String currentLine;
        File file = new File(filepath);

        try{
            Scanner scan = new Scanner(file);
            
            while(scan.hasNext()){
                String line = scan.nextLine();
                String[] values = line.split("\t");
                
                if(values[2].equalsIgnoreCase(session)){
                    setName(values[1]);
                    setAddr(values[7]);
                    setPhoneNum(values[5]);
                }else{
                    System.out.println("Error!");
                }
            }          

        }catch(Exception e){
            
        } 
    } 

}

