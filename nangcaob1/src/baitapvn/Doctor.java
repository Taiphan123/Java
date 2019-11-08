package baitapvn;

public class Doctor {
	private String code;
	private String name;
	private String specialization;
	private String availabillity;

	public Doctor() {
		super();
	}

	public Doctor(String code, String name, String specialization, String availabillity) {
		super();
		this.code = code;
		this.name = name;
		this.specialization = specialization;
		this.availabillity = availabillity;
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

	public String getAvailabillity() {
		return availabillity;
	}

	public void setAvailabillity(String availabillity) {
		this.availabillity = availabillity;
	}
	
	public void enterData() {
		System.out.println("Enter code:");
		this.code = Validate.checkInputString();
		System.out.println("Enter name:");
		this.name = Validate.checkInputString();
		System.out.println("Enter specialization:");
		this.specialization = Validate.checkInputString();
		System.out.println("Enter availabillity:");
		this.availabillity = Validate.checkInputString();
	}

	@Override
	public String toString() {
		return "Doctor [code=" + code + ", name=" + name + ", specialization=" + specialization + ", availabillity="
				+ availabillity + "]";
	}
	
	

}
