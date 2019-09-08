package thu7_7_9;

public class Contract {
	private int contractId;
	private String fullName;
	private String group;
	private String address;
	private String phone;
	private String firstName;
	private String lastName;

	public Contract() {

	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "newContract [contractId=" + contractId + ", fullName=" + fullName + ", group=" + group + ", address="
				+ address + ", phone=" + phone + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public Contract(int contractId, String fullName, String group, String address, String phone, String firstName,
			String lastName) {
		super();
		this.contractId = contractId;
		this.fullName = fullName;
		this.group = group;
		this.address = address;
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
