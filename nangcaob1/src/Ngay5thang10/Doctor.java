package Ngay5thang10;

import baitap.ValidationDataDemo;


public class Doctor implements Comparable<Doctor> {
	private String code;
	private String name;
	private String specialization;
	private String availability;

	public Doctor() {
		super();
	}

	public Doctor(String code, String name, String specialization, String availability) {
		super();
		this.code = code;
		this.name = name;
		this.specialization = specialization;
		this.availability = availability;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Doctor [code=" + code + ", name=" + name + ", specialization=" + specialization + ", availability="
				+ availability + "]";
	}

	public void enterDoctor() {
		System.out.println("Enter code:");
		this.code = ValidationDataDemo.checkInputString();

		System.out.println("Enter name:");
		this.name = ValidationDataDemo.checkInputString();

		System.out.println("Enter specialization:");
		this.specialization = ValidationDataDemo.checkInputString();

		System.out.println("Enter availability:");
		this.availability = ValidationDataDemo.checkInputString();
	}

	public void display() {
		System.out.println("code:" + this.code);
		System.out.println("name:" + this.name);
		System.out.println("specialization:" + this.specialization);
		System.out.println("availability:" + this.availability);
	}

	@Override
	public int compareTo(Doctor o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}

}
