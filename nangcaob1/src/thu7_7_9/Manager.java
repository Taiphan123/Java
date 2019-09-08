package thu7_7_9;

import java.util.ArrayList;

public class Manager {
	public static int menu() {
		System.out.println("1. them");
		System.out.println("2. hien thi");
		System.out.println("3. xoa");
		System.out.println("4. tim kiem");
		System.out.println("5. Exit");
		int choice = Validation.checkInputInt();
		return choice;
	}

	public static void createContract(ArrayList<Contract> list) {
		System.out.println("Enter id contract");
		int contractId = Validation.checkInputInt();
		System.out.println("fist Name");
		String firstName = Validation.checkInputString();
		System.out.println("last Name");
		String lastName = Validation.checkInputString();
		System.out.println("group");
		String group = Validation.checkInputString();
		System.out.println("full Name");
		String fullName = Validation.checkInputString();
		System.out.println("Enter address");
		String address = Validation.checkInputString();
		System.out.println("Enter phone");
		String phone = Validation.checkInputString();
		list.add(new Contract(contractId, fullName, firstName, lastName, group, address, phone));
		System.err.println("add successful");

	}

	public static void printAllContract(ArrayList<Contract> list) {
		System.out
				.println("ID\t" + " Name\t" + "\tFristName\t" + "lastName\t" + "Group\t" + "Address\t" + "\tPhone \t");
		for (Contract ct : list) {
			System.out.println(ct.getContractId() + "\t" + ct.getFullName() + "\t" + ct.getFirstName() + "\t" + "\t"
					+ ct.getLastName() + "\t" + ct.getGroup() + "\t" + ct.getAddress() + "\t"+"\t" + ct.getPhone());

		}
	}

	public static Contract getContractById(ArrayList<Contract> list, int idDelete) {
		for (Contract newContract : list) {
			if (newContract.getContractId() == idDelete) {
				return newContract;
			}
		}
		return null;
	}

	public static void deleteContractId(ArrayList<Contract> list) {
		System.out.println("Enter id");
		int idDelete = Validation.checkInputInt();
		Contract contractDelete = getContractById(list, idDelete);
		if (contractDelete == null) {
			System.err.println("Not found contract");
			return;
		} else {
			list.remove(contractDelete);
		}
		System.out.println("delete successful");
	}
	
	public static void findFistName(ArrayList<Contract> list) {
		
		ArrayList<Contract> listContractFind = new ArrayList<>();
		System.out.println("ten can tim:");
		String name = Validation.checkInputString();
		for (Contract newContract : list) {
			if(newContract.getFirstName().contains(name)) {
				listContractFind.add(newContract);
				Manager.printAllContract(listContractFind);	
			}
			
			
		}
		
		
	}

}
