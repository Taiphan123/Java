package bai6;

import java.util.Scanner;

public class Customer {
	private int roll;
	private String name;
	private int marks;
	private String phone;
	public Customer(int roll, String name, int marks, String d) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
		this.phone = d;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Customer [roll=" + roll + ", name=" + name + ", marks=" + marks + ", phone=" + phone + "]";
	}
	public void nhap() {
		System.out.println("nhap:");
		Scanner sc = new Scanner (System.in);
		this.name = sc.nextLine();
		this.roll = sc.nextInt();
		this.marks = sc.nextInt();
		this.phone = sc.nextLine();
	}
}

