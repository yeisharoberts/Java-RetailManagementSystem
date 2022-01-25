/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author adeli
 */
public class test {}
    
//   public static void main(String[] args) throws IOException {
       

       
//        int lineCount=0;
//
//        File f = new File("CustomerData.txt");
//        
//        // create a file when file doent exist 
//            if(!f.exists()){
//                f.createNewFile();
//             }
//        
//           BufferedReader br = new BufferedReader(new FileReader(f));
//           while(br.readLine() != null)
//           {
//               lineCount++;
//               
//           }
//               System.out.println(lineCount);
           
//        String tempFile = "temp.txt";
//        File oldFile = new File("CustomerData.txt");
//        File newFile = new File(tempFile);
//        
//            oldFile.delete();
//            File dump = new File("CustomerData.txt");
//            newFile.renameTo(dump);

            
//            String cusID =""; 
//            String cusName ="";
//            String username = "";
//            String password = "";
//            String gender = "";
//            String email = "";
//            String addr = "";
//        try
//        {
//            FileWriter fw = new FileWriter(tempFile,true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            PrintWriter pw = new PrintWriter(bw);
//                        
//            Scanner data = new Scanner(oldFile);
//            data.useDelimiter("[\t\n]");
//            
//            while(data.hasNext())
//            {  
//                cusID = data.next();
//                System.out.println(cusID);
//                cusName = data.next();
//                System.out.println(cusName);
//                username = data.next();
//                System.out.println(username);
//                password = data.next();
//                System.out.println(password);
//                gender = data.next();
//                System.out.println(gender);
//                email = data.next();
//                System.out.println(email);
//                addr = data.next();
//                System.out.println(addr);
//                
//                if(cusID.equalsIgnoreCase("C001") == false)
//                {
//                    pw.println(cusID+"\t"+cusName+"\t"+username+"\t"+password+"\t"+gender+"\t"+email+"\t"+addr);
//                }   
//            }
//            data.close();
//            pw.flush();
//            pw.close();

//        }
//        catch(Exception ex)
//        {
//            JOptionPane.showMessageDialog(null,"");
//        }
        
   
   // Shape.java
// Shape abstract-superclass declaration.
     
//public abstract class Shape extends Object {
//         
//// return area of shape; 0.0 by default
//public double getArea(){
//	return 0.0;
//} 
//    
//// return volume of shape; 0.0 by default
//public double getVolume() {
//	return 0.0;
//} 
//    
//// abstract method, overridden by subclasses
//public abstract String getName();           
//   
//} // end abstract class Shape
//// Point.java
//// Point class declaration inherits from Shape.
//     
//
//
//
//
//public class Point extends Shape {
//private int x;  // x part of coordinate pair
//private int y;  // y part of coordinate pair
//     
//// no-argument constructor; x and y default to 0
//public Point() {
//// implicit call to Object constructor occurs here
//} 
//   
//// constructor
//public Point(int xValue, int yValue) {
//// implicit call to Object constructor occurs here
//x = xValue;  // no need for validation
//y = yValue;  // no need for validation
//} 
//     
//// set x in coordinate pair
//public void setX(int xValue) {
//	x = xValue;  // no need for validation
//} 
//// return x from coordinate pair
//public int getX() {
//   return x;
//} 
//   
//// set y in coordinate pair
//public void setY(int yValue) {
//   y = yValue;  // no need for validation
//} 
//   
//// return y from coordinate pair
//public int getY() {
//   return y;
//} 
//    
//// override abstract method getName to return "Point"
//public String getName() {                                                 
//   return "Point";                                   
//}                                               
//  
//// override toString to return String representation of Point
//public String toString(){
//   return "[" + getX() + ", " + getY() + "]";
//}     
//} // end class Point
//// Circle.java
//// Circle class inherits from Point.
//   
//
//
//public class Circle extends Point {
//	private double radius;  // Circle's radius
//     
//// no-argument constructor; radius defaults to 0.0
//public Circle(){
//// implicit call to Point constructor occurs here
//} 
//       
//// constructor
//public Circle(int x, int y, double radiusValue) {
//	super( x, y );  // call Point constructor
//	setRadius( radiusValue );
//} 
//   
//// set radius
//public void setRadius(double radiusValue) {
//	radius = (radiusValue < 0.0 ? 0.0 : radiusValue);
//} 
//    
//
//
//}

//    }
    



