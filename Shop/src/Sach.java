import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Sach implements Serializable{
	private String tenSach;
	private String tacGia;
	private int namXuatBan;
	private String nhaXuatBan;
	private String danhMuc;
	private float donGia;
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public int getNamXuatBan() {
		return namXuatBan;
	}
	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	public String getNhaXuatBan() {
		return nhaXuatBan;
	}
	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}
	public String getDanhMuc() {
		return danhMuc;
	}
	public void setDanhMuc(String danhMuc) {
		this.danhMuc = danhMuc;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public void nhapSach() {
		Scanner sc =new Scanner(System.in);
		checkTacGiaTacPham();
		System.out.println("Nam Xuat Ban:");
		this.namXuatBan=Integer.parseInt(sc.nextLine());
		System.out.println("Nha Xuat Ban:");
		this.nhaXuatBan=sc.nextLine();
		System.out.println("Danh muc:");
		this.danhMuc=sc.nextLine();
		 checkDonGia();
	}
	public void xuatSach() {
		System.out.printf("Ten Sach:%3s\t|",this.tenSach);
		System.out.printf("Tac gia:%3s\t|",this.tacGia);
		System.out.printf("Nam Xuat Ban:%3d\t|",this.namXuatBan);
		System.out.printf("Nha Xuat Ban:%3s\t|",this.nhaXuatBan);
		System.out.printf("Danh muc:%3s\t|",this.danhMuc);
		System.out.printf("Don Gia:%f\t",this.donGia);
		System.out.println("\n------------------------");
	}
	void checkTacGiaTacPham() {
		Scanner sc =new Scanner(System.in);
		while(true) {
			try {
				System.out.println("Ten Sach:");
				this.tenSach=sc.nextLine();
				System.out.println("Tac Gia:");
				this.tacGia=sc.nextLine();
				SachException.tacGia(this.tenSach, this.tacGia);break;
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}
	void checkDonGia() {
		Scanner sc =new Scanner(System.in);
		while(true) {
			try {
				System.out.println("Don gia");
				this.donGia=sc.nextFloat();
				SachException.donGia(this.donGia);break;
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}
}
