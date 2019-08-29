import java.util.Scanner;

public class Student {
	private int id;
	private String name;
	private int age;
	private String address;
	private float gpa;
	Scanner sc=new Scanner (System.in);
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
	public void them() {
		System.out.println("nhap id:");
		this.id=Integer.parseInt(sc.nextLine());
		System.out.println("nhap name:");
		this.name=sc.nextLine();
		System.out.println("nhap age");
		this.age=Integer.parseInt(sc.nextLine());
		System.out.println("nhap dia chi");
		this.address=sc.nextLine();
		System.out.println("nhap diem");
		this.gpa=Float.parseFloat(sc.nextLine());
	}
	public void xuat() {
		System.out.println("id:\t"+this.id+"name:\t"+this.name+"age:\t"+this.age+"address:\t"+this.address+"diem:\t"+this.gpa);
	}
	
}
