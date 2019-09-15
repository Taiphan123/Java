package Generic;

public class Animal {
	private String name;
	private double weight;
	private double high;
	private String chungLoai;
	
	
	public Animal() {
		super();
	}
	
	@Override
	public String toString() {
		return "name" + name + "weight" + weight + "high" + high + "chungLoai" + chungLoai + "\n";
	}

	public Animal(String name, double weight, double high, String chungLoai) {
		super();
		this.name = name;
		this.weight = weight;
		this.high = high;
		this.chungLoai = chungLoai;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public String getChungLoai() {
		return chungLoai;
	}
	public void setChungLoai(String chungLoai) {
		this.chungLoai = chungLoai;
	}
	
	
	
}
