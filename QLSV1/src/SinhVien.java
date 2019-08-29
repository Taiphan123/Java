
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class SinhVien implements Serializable {
	private int id;
	private String name;
	private int age;
	private String address;
	private float gpa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public void nhap(ArrayList<SinhVien> arr) {
		Scanner sc=new Scanner (System.in);
		kiemtraID(arr);
		kiemtraTen();
		kiemtraTuoi();
		System.out.println("nhap address:");
		this.address = sc.nextLine();
		kiemtraGpa();

	}

	public void xuat() {
		System.out.printf("ID:%d \t name:%s \t age:%d \t address:%s \t gpa:%.2f \n", this.id, this.name, this.age,
				this.address, this.gpa);
	}
	void kiemtraID(ArrayList<SinhVien> arr) {
		Scanner sc=new Scanner (System.in);
		while(true) {
			try {
				System.out.println("nhap ID:");
				
				this.id = Integer.parseInt(sc.nextLine());
				SinhVienException.checkMASV(this.id, arr);break;
			} catch (SinhVienException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.toString());
			}
			catch(NumberFormatException e){
				System.out.println("Id khong duoc rong!");

			}
			}
	}
	void kiemtraTen() {
		Scanner sc=new Scanner (System.in);
		while(true) {
	
			try {
				System.out.println("nhap name:");
				this.name = sc.nextLine();
				SinhVienException.checkHoTen(this.name);break;
			} catch (SinhVienException e) {
				// TODO Auto-generated catch block
				System.out.println("vui long nhap lai ten");
			}
			}
	}
	void kiemtraTuoi() {
		Scanner sc=new Scanner (System.in);
		while(true) {
			
			try {
				System.out.println("nhap age:");
				this.age = Integer.parseInt(sc.nextLine());
				SinhVienException.checkTuoi(this.age);break;
			} catch (SinhVienException e1) {
				// TODO Auto-generated catch block
				System.out.println("tuoi phai nho hon 100");
			}
			}
	}
	void kiemtraGpa() {
		Scanner sc=new Scanner (System.in);
		while(true) {
		
			try {
				System.out.println("nhap gpa:");
				this.gpa = Integer.parseInt(sc.nextLine());
				SinhVienException.checkDiem(this.gpa);break;
			} catch (SinhVienException e) {
				// TODO Auto-generated catch block
				System.out.println("diem phai tu 0 den 10");
			}
			}
	}

	
}
