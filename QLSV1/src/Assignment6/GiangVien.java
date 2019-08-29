package Assignment6;

import java.util.Scanner;

public class GiangVien {
	private String hoTen;
	private String khoa;
	private String trinhDo;
	private float phuCap;
	private int soTietDay;
	private int heSoLuong;
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getKhoa() {
		return khoa;
	}
	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}
	public String getTrinhDo() {
		return trinhDo;
	}
	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}
	public int getSoTietDay() {
		return soTietDay;
	}
	public void setSoTietDay(int soTietDay) {
		this.soTietDay = soTietDay;
	}
	public int getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(int heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	float tinhPhuCap() {
		if(this.trinhDo=="cu nhan");
			this.phuCap=300;
		if(this.trinhDo=="thac si");
			this.phuCap=500;
		if(this.trinhDo=="tien si");
			this.phuCap=1000;
		return this.phuCap;
	}
	float tongLuong() {
		return this.heSoLuong*730+this.phuCap+this.soTietDay*45;
	}
	public void nhap() {
		Scanner sc= new Scanner (System.in);
		System.out.println("nhap ho ten:");
		this.hoTen=sc.nextLine();
		System.out.println("Khoa:");
		this.khoa=sc.nextLine();
		System.out.println("Trinh do:");
		this.trinhDo=sc.nextLine();
		System.out.println("So Tiet Day:");
		this.soTietDay=sc.nextInt();
		System.out.println("He so luong:");
		this.heSoLuong=sc.nextInt();
	}
	public void xuat() {
		System.out.println("nhap ho ten \t:"+this.hoTen);
		System.out.println("Khoa:\t"+this.khoa);
		System.out.println("Trinh do:\t"+this.trinhDo);
		System.out.println("So Tiet Day:\t"+this.soTietDay);
		System.out.println("He so luong:\t"+this.heSoLuong);
		System.out.println("Phu cap\t"+tinhPhuCap());
		System.out.println("Luong:\t"+tongLuong());
	}
}
