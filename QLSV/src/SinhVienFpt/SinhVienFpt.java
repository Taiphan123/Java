package SinhVienFpt;

import java.util.Scanner;

abstract public class SinhVienFpt {
	String ten;
	String nganh;
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getNganh() {
		return nganh;
	}
	public void setNganh(String nganh) {
		this.nganh = nganh;
	}
	public SinhVienFpt(String ten,String nganh) {
		this.ten=ten;
		this.nganh=nganh;
	}
	public SinhVienFpt() {
		
	}
	abstract double getDiem();
	protected abstract void nhap();
	public String getHocLuc() {
		String s = null;
		if(getDiem()<5) {
			return s="Yeu";
		}
		if(getDiem()<=5 && getDiem()<6.5) {
			return s="Trung Binh";
		}
		if(getDiem()<=6.5&&getDiem()<7.5) {
			return s="Kha";
		}
		if(getDiem()<=7.5&&getDiem()<9) {
			return s="Gioi";
		}
		else return s="Xuat Xac";
		
	}
	public void xuat() {
		System.out.println("Xuat:");
		System.out.println("Ho ten:"+this.ten);
		System.out.println("Nganh:"+this.nganh);
		System.out.println("hoc luc:"+getHocLuc());
	}
	

}
