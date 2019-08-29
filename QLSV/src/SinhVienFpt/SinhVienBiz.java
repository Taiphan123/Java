package SinhVienFpt;

import java.util.Scanner;

public class SinhVienBiz extends SinhVienFpt {
	private float diemMarketting;
	private float diemSales;

	@Override
	double getDiem() {
		// TODO Auto-generated method stub
		return (2 * this.diemMarketting + this.diemSales) / 3;
	}
	public void nhap() {
		
		System.out.println("nhap diem Biz");
		Scanner sc=new Scanner (System.in);
		System.out.println("nhap ho ten");
		super.ten=sc.nextLine();
		System.out.println("nganh");
		super.nganh=sc.nextLine();
		System.out.println("nhap diem Marketting va diem Sales");
		this.diemMarketting=sc.nextFloat();
		this.diemSales=sc.nextFloat();
	}


}
