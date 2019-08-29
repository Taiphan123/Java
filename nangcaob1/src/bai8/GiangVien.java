package bai8;

import java.util.Scanner;

public class GiangVien extends CanBo {
	String khoa;
	String trinhDo;
	int soTietDay;
	
	public GiangVien() {
		
	}
	public GiangVien(String khoa, String trinhDo, int soTietDay) {
		super();
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTietDay = soTietDay;
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
	
	@Override
	public double tinhLuong() {
		return this.getHeSoLuong()*730+this.getPhuCap()+this.getSoTietDay()*45;
	}
	@Override
	public void Nhap() {
		super.Nhap();
		System.out.println("Nhap Khoa");
		khoa = sc.nextLine();
		do {
			System.out.println("nhap trinh do (1- cu nhan, 2 - thac si, 3- tien sy");
			choose = sc.nextInt();
			switch (choose) {
			case 1: trinhDo = "Cu Nhan"; this.setPhuCap(300); break;
			case 2: trinhDo = "Thac si"; this.setPhuCap(500); break;
			case 3: trinhDo = "Tien si"; this.setPhuCap(1000); break;

			default:
				System.out.println("Chon khong dung!");break;
			}
			
		}while (choose<1||choose>3);
		System.out.println("So tiet day");
		soTietDay = sc.nextInt();
	}
	@Override
	public String toString() {
		return "GiangVien [khoa=" + khoa + ", trinhDo=" + trinhDo + ", soTietDay=" + soTietDay;
	}
	
	
	
	

}
