package Hinh;

public class Main {
	public static void main(String[] args) {
		HinhChuNhat cn=new HinhChuNhat(3,4);
		HinhChuNhat du=new HinhVuong(4);
		cn.xuat();
		System.out.println("Hinh Vuong");
		du.xuat();
	}
}
