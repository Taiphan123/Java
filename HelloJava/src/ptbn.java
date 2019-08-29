import java.util.Scanner;

public class ptbn {
	public static void main(String[] args) {
		System.out.println("Kiem tra phuong trinh bac nhat");
		float a, b;
		float x = 0;
		System.out.println("nhap vao ax+b");
		System.out.println("nhap a:");
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		System.out.println("nhap b:");
		b = sc.nextInt();
		if (a == 0) {
			if (b == 0) {
				x = 0;
				System.out.println(x);
			}
			else {
				System.out.println("phuong trinh vo nghiem");
			}}
		else {
			x=-b/a;
			System.out.println("nghiem la :"+x);	
		}
	}}
