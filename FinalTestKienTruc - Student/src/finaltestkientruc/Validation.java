/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaltestkientruc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Quynh Tran Ly
 */
public class Validation {

    private static final Scanner in = new Scanner(System.in);
    
    
    
    
    public static int autoIncreaseIDProduct(ArrayList<Product> lp){
        int max = 0;
        for (Product p : lp) {
            if(max<p.getId()){
                max=p.getId();
            }
        }
        return max+1;
    }
     public static int autoIncreaseIDOrder(ArrayList<Order> order){
        int max = 0;
         for (Order order1 : order) {
             if(max<order1.getId()){
                 max = order1.getId();
             }
         }
        return max+1;
    }
    
    public static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Input must be in Integer type");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            try {
                String result = in.nextLine().trim();
                if (result.isEmpty()) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Input must not be empty!");
                System.out.print("Enter again: ");
            }
        }
    }

    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = checkInputInt();
                if (result < min || result > max) {
                    throw new Exception();
                }
                return result;
            } catch (Exception ex) {
                System.err.println("Input must be from " + min + " to " + max);
                System.out.print("Enter again: ");
            }
        }
    }

    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Input must be in Integer type");
                System.out.print("Enter again: ");
            }
        }
    }


    public static boolean checkYN() {
        while (true) {
            try {
                String r = checkInputString();
                if (r.equalsIgnoreCase("Y")) {
                    return true;
                } else if (r.equalsIgnoreCase("N")) {
                    return false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("You must input Y or N");
                System.out.print("Enter again: ");
            }
        }
    }

    static Product checkProductId(ArrayList<Product> lp, int pId) {
        for (Product product : lp) {
            if(product.getId()==pId){
                return product;
            }
        }return null;
        
    }

}
