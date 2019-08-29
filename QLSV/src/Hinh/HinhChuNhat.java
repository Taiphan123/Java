package Hinh;

import java.util.Scanner;

public class HinhChuNhat {
	private int dai;
	private int rong;
	public int getDai() {
		return dai;
	}
	public void setDai(int dai) {
		this.dai = dai;
	}
	public int getRong() {
		return rong;
	}
	public void setRong(int rong) {
		this.rong = rong;
	}
	public HinhChuNhat(int dai,int rong) {
		this.dai=dai;
		this.rong=rong;
	}
	public HinhChuNhat() {
		
	}
	public double getChuVi() {
		return (this.dai + this.rong) * 2;
	}

	public double dienTich() {
		return (this.dai * this.rong);
	}

//	public void nhap() {
//		System.out.println("moi nhap chieu dai va chieu rong:");
//		Scanner sc = new Scanner(System.in);
//		this.dai = sc.nextInt();
//		this.rong = sc.nextInt();
//
//	}
	public void xuat() {
		System.out.println("chieu dai:"+this.dai);
		System.out.println("chieu rong:"+this.rong);
		System.out.println("Chu Vi:"+getChuVi());
		System.out.println("Dien Tich:"+dienTich());
	}
}
