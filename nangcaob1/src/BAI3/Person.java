package BAI3;

import java.util.Scanner;

public class Person implements PersonInt {

	protected String Id;
	protected String name;
	protected int age;
	final Scanner sc = new Scanner(System.in);

	public Person() {

	}

	public Person(String id, String name, int age) {
		Id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
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
}
