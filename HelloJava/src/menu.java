import java.util.Scanner;

public class menu {
	public void bangcuuchuong() {
		System.out.println("Bang cuu chuong");
		System.out.println("--------------");
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				System.out.printf(i + "X" + j + "=" + (i * j) + ("\t"));

			}
			System.out.println();
		}
	}

	public void ptbn() {
		System.out.println("phuong trinh bac nhat");
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
			}} else {
				x = -b / a;
				System.out.println("nghiem la :" + x);
			}
		}

	public void tinhtiendien() {
		int tien;
		int soDien;
		System.out.print("nhap vao so dien:");
		Scanner sc = new Scanner(System.in);
		soDien = sc.nextInt();
		for (int i = 0; i <= soDien; i++) {
			if (soDien > 0 && soDien <= 50) {
				tien = soDien * 1000;
				System.out.printf("so tien dien phai tra la:" + tien);
				break;

			} else {
				tien = 50 * 1000 * (soDien - 50) * 1200;
				System.out.println("so tien dien phai tra la:" + tien);
				break;
			}
		}
	}

	public static void main(String[] args) {
		int a = 0;
		while (a != 4) {
			System.out.println("+----------------------------------+");
			System.out.println("nhap lua chon:");

			Scanner sc = new Scanner(System.in);
			a = sc.nextInt();
			switch (a) {
			case 1: {
				System.out.println("bang cuu chuong");
				menu sc1 = new menu();
				sc1.bangcuuchuong();
				break;
			}
			case 2: {
				System.out.println("phuong trinh bac nhat");
				menu sc1 = new menu();
				sc1.ptbn();
				break;
			}
			case 3: {
				System.out.println("tinh tien dien");
				menu sc1 = new menu();
				sc1.tinhtiendien();
				break;
			}
			case 4: {
				System.out.println("Ket thuc!");
			}

			}
			System.out.println("\n+----------------------------------+");
		}
	}
}
