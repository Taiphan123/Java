package Assignment6;

import java.util.Scanner;

public class NhanVienHanhChinh {
	private String hoTen;
	private int PhongBan;
	private int soNgayCong;
	private int heSoLuong;
	private float phuCap;
	private String chucVu;
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getPhongBan() {
		return PhongBan;
	}
	public void setPhongBan(int phongBan) {
		PhongBan = phongBan;
	}
	public int getSoNgayCong() {
		return soNgayCong;
	}
	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}
	public int getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(int heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public float getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	float tinhPhuCap() {
		float tongLuong;
		if(this.chucVu=="truong phong");
			this.phuCap=300;
		if(this.chucVu=="pho phong");
			this.phuCap=500;
		if(this.chucVu=="nhan vien");
			this.phuCap=1000;
		return this.phuCap;
	}
	float tongLuong() {
		return this.heSoLuong*730+this.phuCap+this.soNgayCong*30;
	}
	public void nhap() {
		Scanner sc= new Scanner (System.in);
		System.out.println("nhap ho ten:");
		this.hoTen=sc.nextLine();
		System.out.println("Phong Ban:");
		this.PhongBan=sc.nextInt();
		System.out.println("So ngay cong:");
		this.soNgayCong=sc.nextInt();
		System.out.println("He so luong:");
		this.heSoLuong=sc.nextInt();
		System.out.println("Chuc Vu:");
		sc.nextLine();
	}
	public void xuat() {
		System.out.println("nhap ho ten:\t"+this.hoTen);
		System.out.println("Phong Ban:\t"+this.PhongBan);
		System.out.println("So ngay cong:\t"+this.soNgayCong);
		System.out.println("He so Luong:\t"+this.heSoLuong);
		System.out.println("Chuc Vu:\t"+this.chucVu);
		System.out.println("Phu cap:\t"+tinhPhuCap());
		System.out.println("Luong:\t"+tongLuong());
	}
	
}
