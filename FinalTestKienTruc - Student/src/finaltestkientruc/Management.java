/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaltestkientruc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Quynh Tran Ly
 */
class Management {

    public static int menu() {
        System.out.println("1. Add a new product to the Store.");
        System.out.println("2. Update price for a particular product");
        System.out.println("3. A list of all available products in the Store");
        System.out.println("4. Create a new Order");
        System.out.println("5. Printf information of an Order by OrderID");
        System.out.println("6. Sort all products by product price as ascending");
        System.out.println("7. Print information of all Orders by a specific customer ID");
        System.out.println("8. Print information of all Orders to the text file.");
        System.out.println("9. Save product to Database");
        System.out.println("10. Exit");
        System.out.print("Seclect your choice: ");
        int choice = Validation.checkInputIntLimit(1, 10);
        return choice;
        
        
        
        
        
    }

    //-------------Function for Product-----------------//
    public static void addNewProduct(ArrayList<Product> lp) {
            int id = Validation.autoIncreaseIDProduct(lp);
            System.out.println("Enter Name:");
            String name = Validation.checkInputString();
            System.out.println("Enter Price:");
            Double price = Validation.checkInputDouble();
            lp.add(new Product(id,name,price));
    }

    public static void updatePrice(ArrayList<Product> lp) {
        System.out.println("Enter ID:");
        int id = Validation.checkInputInt();
        
        double priceUpdate = Validation.checkInputDouble();
        for (Product product : lp) {
            if(product.getId() == id ){
                System.out.println("Enter Price:");
                product.setPrice(priceUpdate);
                System.err.println("Update Success");
            }
        }
    }

    public static void listAllProduct(ArrayList<Product> lp) {
        System.out.printf("%-15s%-15s%-15s \n" ,"Product ID","Name","Price");
        for (Product product : lp) {
            System.out.printf("%-15s%-15s%-15s \n" ,product.getId(),product.getName(),product.getPrice());
        }
    }

    public static void sortProductByPrice(ArrayList<Product> lp) {
        System.err.println("Sort Success Price!");
        Collections.sort(lp);
        listAllProduct(lp);
       
    }
    //-------------Function for Order-----------------//

    public static void createNewOrder(ArrayList<Order> lo, ArrayList<Product> lp) {
        System.out.println("Enter Order:");
        
        int id = Validation.autoIncreaseIDOrder(lo);
        LocalDate date = LocalDate.now();
        System.out.println("Enter Name Order:");
        String name = Validation.checkInputString();
        System.out.println("Enter Address Order:");
        String address = Validation.checkInputString();
        System.out.println("Enter CId order:");
        int cId = Validation.checkInputInt();
        
        Order o = new Order(id, date, name, address, cId);
        while (true) {            
            Management.listAllProduct(lp);
            System.out.println("Enter Product ID:");
            int pId = Validation.checkInputInt();
            Product p = Validation.checkProductId(lp,pId);
            if(p==null){
                System.out.println("Product doesn't exist");
            }else{
                o.getPro().add(p);
                
            }
            System.out.println("Do you want to continue shopping (Y/N)");
            if(!Validation.checkYN()){
                break;
            }
        }
        lo.add(o);
       
        
        
    }

    public static void printOrderByID(ArrayList<Order> lo) {
        System.out.println("Enter Id search:");
        int id = Validation.checkInputInt();
        for (Order order : lo) {
            if(order.getId()==id){
                System.out.println(order);
            }
            
        }
    }

    public static void printOrderByCustomerID(ArrayList<Order> lo) {
        for (Order order : lo) {
            System.out.println(order);
        }
    }
    
    public static void SaveToFile(ArrayList<Order> lo) throws FileNotFoundException, IOException{
        File f = new File ("final.txt");
        if(f.exists()) f.delete();
        RandomAccessFile r = new RandomAccessFile("final.txt","rw");
        for (Order order : lo) {
            r.writeBytes(order.getId()+"\r\n");
            r.writeBytes(order.getDate().toString()+"\r\n");
            r.writeBytes(order.getName()+"\r\n");
            r.writeBytes(order.getAddress()+"\r\n");
            r.writeBytes(order.getcId()+"\r\n");
            for (Product pro : order.getPro()) {
                 r.writeBytes(pro.getId()+"\r\n");
                 r.writeBytes(pro.getName()+"\r\n");
                 r.writeBytes(pro.getPrice()+"\r\n");
            }
        }
       
    }


public static void saveProductDB (ArrayList<Product> lp) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
    InsertData(lp);

}
public static void InsertData(ArrayList<Product> lp) throws SQLException, ClassNotFoundException{
    Connection connect = getMySQLConnection();
     Statement statement = connect.createStatement();
    for (Product product : lp) {
        statement.executeUpdate("INSERT INTO Product "+"VALUES ("+product.getId()+",'"+product.getName()+"',"+product.getPrice()+")");
    }
        connect.close();
}

public static Connection getMySQLConnection() throws SQLException,
         ClassNotFoundException {
    String connectionURL = "jdbc:derby://localhost:1527/MyProductDB1";
     Connection conn= (Connection) DriverManager.getConnection(connectionURL,"sa","sa");
     return conn;
 }
}