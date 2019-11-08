package Ngay5thang10;

import java.util.Scanner;

public class NgoaiLe {
	
	public static void main(String[] args) {
		int a;
		int b;
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.println("nhap a:");
				a = Integer.parseInt(sc.nextLine());
				System.out.println("nhap b:");
				b = Integer.parseInt(sc.nextLine());;
				int c = a/b;
				System.out.println(c);
			} catch (ArithmeticException e) {
				System.err.println(e);
			}
			
		}
		
	}
	
}
