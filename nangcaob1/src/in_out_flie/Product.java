package in_out_flie;

import baitapvn.Validate;

public class Product implements Comparable<Product> {
	private String name;
	private String id;
	private double value;
	public Product() {
		super();
	}
	public Product(String name, String id, double value) {
		super();
		this.name = name;
		this.id = id;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", id=" + id + ", value=" + value + "]";
	}
	public void enterData() {
		System.out.println("Enter name:");
		this.name = Validate.checkInputString();
		System.out.println("id:");
		this.id = Validate.checkInputString();
		System.out.println("Enter value:");
		this.value = Validate.checkInputDouble();
	}
	public void xuatData() {
		System.out.println("Enter name:"+this.name);
		System.out.println("id:"+this.id);
		System.out.println("Enter value:"+this.value);
	}
	@Override
	public int compareTo(Product o) {
		return this.name.compareToIgnoreCase(o.name);
	}
	
}
