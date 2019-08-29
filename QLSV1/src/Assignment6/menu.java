package Assignment6;

import java.util.ArrayList;
import java.util.Scanner;

public class menu {
	static void main() {
		int n,a,b;
		System.out.println(
				"1.nhap danh sach can bo trong truong\r\n" + "2.Xuat danh sach giang vien va nhan vien phong ban\r\n"
						+ "3.Tong so luong truong phai tra\r\n" + "4.Sap xep can bo theo luong\\r\\n"+"0.Thoat");
		while (true) {
			System.out.println("nhap lua chon");
			Scanner sc = new Scanner(System.in);
			ArrayList <GiangVien> gv =new ArrayList <GiangVien>();
			ArrayList <NhanVienHanhChinh> nv =new ArrayList <NhanVienHanhChinh>();
			n = Integer.parseInt(sc.nextLine());
			switch (n) {
				case 0:{
					System.out.println("Ket thuc");
					System.exit(0);;
				}
				case 1: {
					System.out.println("nhap so giang vien:");
					a=sc.nextInt();
					for (int i = 0; i <a ; i++) {
						GiangVien gv1 =new GiangVien();
						gv1.nhap();
						gv.add(gv1);
					}
					System.out.println("nhap so nhan vien phong ban:");	
					b=sc.nextInt();
					for (int i = 0; i < b; i++) {
						NhanVienHanhChinh nv1 =new NhanVienHanhChinh();	
						nv1.nhap();
						nv.add(nv1);
				}break;
			}
				case 2:{
					System.out.println("Xuat:");
					for (GiangVien gv1 : gv) {
						gv1.xuat();
					}
					for (NhanVienHanhChinh nv1 : nv) {
						nv1.xuat();
					}
				}break;
				case 3:{
					float c,d;
					for (GiangVien gv1 : gv) {
						c= gv1.tongLuong();
						c=+c;
					}
					for (NhanVienHanhChinh nv1 : nv) {
						d=nv1.tongLuong();
						d+=d;
					}
					
				}break;
			}
		}
	}
}
