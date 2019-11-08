/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaltestkientruc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinalTestKienTruc {

    public static void main(String[] args) throws IOException {
        ArrayList<Product> lp = new ArrayList<>();
        ArrayList<Order> lo = new ArrayList<>();
        lp.add(new Product(2, "Banana", 3));
        lp.add(new Product(8, "Apple", 5));
        lp.add(new Product(3, "Kiwi", 4));
        while (true) {
            int choice = Management.menu();
            switch (choice) {
                case 1: {
                    Management.addNewProduct(lp);
                    break;
                }
                case 2: {
                    Management.updatePrice(lp);
                    break;
                }
                case 3: {
                    Management.listAllProduct(lp);
                    break;
                }
                case 4: {
                    Management.createNewOrder(lo, lp);
                    break;
                }
                case 5: {
                    Management.printOrderByID(lo);
                    break;
                }
                case 6: {
                    Management.sortProductByPrice(lp);
                    break;
                }
                case 7: {
                    Management.printOrderByCustomerID(lo);
                    break;
                }
                case 8: {
                    try {
                        Management.SaveToFile(lo);
                        System.err.println("SAVE SUCCESS");
                    } catch (IOException ex) {
                        Logger.getLogger(FinalTestKienTruc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case 9:
                    try {
                        Management.saveProductDB(lo);
                    } catch (Exception e) {
                        System.err.println("Not Found");
                    }
                    
                    break;
                    
                case 10:
                    return;
            }
        }
    }
}
