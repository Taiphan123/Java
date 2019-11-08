package in_out_flie;

import java.util.ArrayList;

public class Manager {
	public static int menu() {
			System.out.println("1. Add product");
			System.out.println("2. Update product");
			System.out.println("3. A list of all");
			System.out.println("4. Sort");
//			System.out.println("3. A list of all");
//			System.out.println("3. A list of all");
//			System.out.println("3. A list of all");
//			System.out.println("4. Search product");
			System.out.println("5. Exit product");
			System.out.println("Enter your choice");
			int choice = Validate.checkInputIntLimit(1,5);
			return choice;
	}
	// them
	public static void addProduct(ArrayList<Product> doc) {
		System.out.println("Enter the number of product:");
		int a = Validate.checkInputInt();
		for (int i = 0; i < a; i++) {
			System.out.println("nhap product thu "+i+" :");
			Product doctor = new Product();
			doctor.enterData();
			doc.add(doctor);
		}		
	}
	// in
	public static void allProduct(ArrayList<Product> pro) {
		for (Product product : pro) {
			System.out.println("--------------------------");
			product.xuatData();
		}
	}
	
	
	
	// tim
	 public static void updateProduct(ArrayList<Product> doc) {
	        System.out.print("Enter code: ");
	        String code = Validate.checkInputString();
	        // kiem tra code da ton tai hay chua
	        if (Validate.checkIdExist(doc, code)) {
	            System.err.println("Not found doctor");
	            return;
	        }
	        System.out.print("Enter id: ");
	        String codeUpdate = Validate.checkInputString();
	        Product doctor = getProductByCode(doc, code);
	        System.out.print("Enter name: ");
	        String name = Validate.checkInputString();
	        System.out.print("Enter value: ");
	        int value = Validate.checkInputInt();
	        // kiem tra da thay doi chua
	        if (!Validate.checkChangeInfomation(doctor, codeUpdate, name,value)) {
	            System.err.println("No change");
	            return;
	        }
	        doctor.setId(codeUpdate);
	        doctor.setName(name);
	        doctor.setValue(value);
	        System.err.println("Update successful");
	    }

	
	// xoa
	public static void deleteProduct (ArrayList<Product> doc) {
		System.out.println("Enter Code");
		String code = Validate.checkInputString();
		Product doctor = getProductByCode(doc, code);
		if (doctor == null) {
            System.err.println("Not found doctor.");
            return;
        }
		else {
			doc.remove(doctor);
			System.err.println("Delete successful");
		}
		
	}
	private static Product getProductByCode(ArrayList<Product> doc, String code) {
		 for (Product doctor : doc) {
	            if (doctor.getId().equalsIgnoreCase(code)) {
	                return doctor;
	            }
	        }
	        return null;
	}
	// tim
	public static void searchProduct (ArrayList<Product> doc) {
		System.out.println("Enter Code");
		String code = Validate.checkInputString();
		if(Validate.checkIdExist(doc, code)) {
			System.err.println("Not found doctor:");
			return;
		}
		for (Product doctor : doc) {
			if(doctor.getId().equalsIgnoreCase(code)) {
				System.out.println(doctor.getId());
				System.out.println(doctor.getName());
				System.out.println(doctor.getValue());
				
			}
		}
	}
}