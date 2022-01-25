
package user.solution;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;


public abstract class User {
    private String username,password;

    //Constructor
    public User(){
    }
    
    // Overload Constructer
    public User( String username,String password){
       this.username = username;
       this.password = password; 
    }
    
    // to string
    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + '}';
    }



    // getter & setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // method to verify user account and login
    public boolean verifyLogin(String file, int a, int b){
       File f = new File(file);
       boolean isAuthenticated = false;

       try {
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) 
            {
                 String line = myReader.nextLine();
                 String [] value = line.split("\t");
                 
                 
                 if(value[0].equals(this.username) || value[a].equals(this.username) 
                         && value[b].equals(this.password))
                 {
                     isAuthenticated = true;
                     break;
                 }
                  
            }
             myReader.close();
        }
        catch(IOException Ex) {
            System.out.println("File error ~");
        }
        return isAuthenticated;        
    }

    public void logActivity(String role, String username, String timeInOut){
        int i = 0;

        String ts = new SimpleDateFormat("yyyy.MM.dd"+"   "+"HH.mm.ss").format(new Date());
        try{
            if(username != null  ){
            if(username != "" ){
            
                File f = new File("LoggingActivity.txt");

                FileWriter write = new FileWriter(f, true);
                BufferedWriter out = new BufferedWriter(write);

                Scanner sc = new Scanner(f);
                   while(sc.hasNextLine()) {
                    sc.nextLine();
                    i++;
                    }   

                write.write(role+"   "+username+ "   " + ts + "   " + timeInOut + "\n" );
                write.close();
                out.close();
           }else{
                System.out.println("Fields are not filled empty field");
            }
        }else{
            System.out.println("Fields are not filled null");
        } 
        }
        catch (IOException e){
          System.out.println("Error");  
        }
        
        
    } 

    

    
}


