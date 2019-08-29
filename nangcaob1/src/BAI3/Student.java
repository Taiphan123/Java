package BAI3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Student extends Person {

	private int mark;
	private String grade;

	public Student() {

	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Student(String id, String name, int age) {
		super(id, name, age);
	}

	public void kq() {
		String a = ((this.mark < 4) ? "yeu" : (this.mark < 7) ? "trungbinh" : (this.mark < 8) ? "kha" : "gioi");
		System.out.println(a);
	}

	@Override
	public void input() {

		System.out.println("moi ban nhap vao:");
		System.out.println("nhap vao id");
		this.Id = sc.nextLine();
		System.out.println("nhap vao name");
		this.name = sc.nextLine();
		System.out.println("nhap vao age");
		this.age = sc.nextInt();

	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("xuat ra:");
		System.out.println("id" + this.Id);
		System.out.println("name" + this.name);
		System.out.println("tuoi" + this.age);

	}

	// xu ly nut chon trong menu

	public static int checkInputIntLimit(int min, int max) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				int result = Integer.parseInt(scanner.nextLine().trim());
				if (result < min || result > max) {
					throw new NumberFormatException();
				}
				return result;
			} catch (NumberFormatException e) {
				System.err.println("Nhap so trong khoang [" + min + "," + max + "]");
				System.out.println("Nhap lai");
			}
		}
	}

	// menu
	public static int menu() {
		System.out.println("\n 1. Nhap thong tin sinh vien");
		System.out.println("\n 2. Hien thong tin sinh vien");
		System.out.println("\n 3. Thoat");
		System.out.println("\n Lua chon nao:");
		int choice = checkInputIntLimit(1, 3);
		return choice;
	}

	// ham main

	public static void main(String[] args) {
		Student st = new Student();
		while (true) {
			int choice = menu();
			switch (choice) {
			case 1: {
				st.input();
			}
				break;
			case 2: {
				st.display();
			}
				break;
			case 3: {
				System.out.println("Cam on da su dung dich vu !!!");
				return;
			}

			}
		}

	}
}
