package bai5;

import java.util.ArrayList;
import java.util.Scanner;

public class baitapArray {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner (System.in);
		
		ArrayList<String> myArray = new ArrayList<String>();
		for (int i = 1; i < 5 ;i++) {
			System.out.println("Moi nhap ten:");
			String name = sc.nextLine();
			myArray.add(name);
		}
		
		System.out.println("arraylist"+myArray);
		
		boolean isContain = myArray.contains("Phan Van Tai");
		System.out.println("Array List contained Phan Van Tai \n"+isContain);
		
		for (int i=0 ; i<myArray.size();i++) {
			System.out.println(myArray.get(i).contains("Phan Van Tai"));
		}
	}
}
