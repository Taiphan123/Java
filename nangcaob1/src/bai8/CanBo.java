package bai8;

import java.util.Scanner;

public class CanBo {
	private String name;
	private double phuCap;
	private int heSoLuong;
	protected int choose;
	final Scanner sc = new Scanner (System.in); 
	public CanBo()
	{
		
	}
	
	public CanBo(String name, String khoa, int heSoLuong, double phuCap) {
		super();
		this.name = name;;
		this.phuCap = phuCap;
		this.heSoLuong = heSoLuong;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}

	public int getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(int heSoLuong) {
		this.heSoLuong = heSoLuong;
	}	
	
	public double tinhLuong() {
		return 0;	
	}
	
	@Override
	public String toString() {
		return "CanBo [name=" + name + ", phuCap=" + phuCap + ", heSoLuong=" + heSoLuong + "]";
	}

	public void Nhap() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Nhap vao danh sach can bo:");
		System.out.println("\nTen:");
		this.name = sc.nextLine();
		System.out.println("\n He so Luong");
		this.heSoLuong = sc.nextInt();
		
	}
}
