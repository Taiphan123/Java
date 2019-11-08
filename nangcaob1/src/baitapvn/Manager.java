package baitapvn;

import java.util.ArrayList;

public class Manager {
	public static int menu() {
			System.out.println("1. Add doctor");
			System.out.println("2. Update doctor");
			System.out.println("3. Delete doctor");
			System.out.println("4. Search doctor");
			System.out.println("5. Exit doctor");
			System.out.println("Enter your choice");
			int choice = Validate.checkInputIntLimit(1,5);
			return choice;
	}
	// them
	public static void addDoctor(ArrayList<Doctor> doc) {
		System.out.println("Enter the number of students:");
		int a = Validate.checkInputInt();
		for (int i = 0; i < a; i++) {
			Doctor doctor = new Doctor();
			doctor.enterData();
			doc.add(doctor);
		}		
	}
	// tim
	 public static void updateDoctor(ArrayList<Doctor> doc) {
	        System.out.print("Enter code: ");
	        String code = Validate.checkInputString();
	        // kiem tra code da ton tai hay chua
	        if (Validate.checkIdExist(doc, code)) {
	            System.err.println("Not found doctor");
	            return;
	        }
	        System.out.print("Enter code: ");
	        String codeUpdate = Validate.checkInputString();
	        Doctor doctor = getDoctorByCode(doc, code);
	        System.out.print("Enter name: ");
	        String name = Validate.checkInputString();
	        System.out.print("Enter specialization: ");
	        String specialization = Validate.checkInputString();
	        System.out.print("Enter availability: ");
	        String availability = Validate.checkInputString();
	        // kiem tra da thay doi chua
	        if (!Validate.checkChangeInfomation(doctor, code, name, specialization, availability)) {
	            System.err.println("No change");
	            return;
	        }
	        doctor.setCode(codeUpdate);
	        doctor.setName(name);
	        doctor.setSpecialization(specialization);
	        doctor.setAvailabillity(availability);
	        System.err.println("Update successful");
	    }

	
	// xoa
	public static void deleteDoctor (ArrayList<Doctor> doc) {
		System.out.println("Enter Code");
		String code = Validate.checkInputString();
		Doctor doctor = getDoctorByCode(doc, code);
		if (doctor == null) {
            System.err.println("Not found doctor.");
            return;
        }
		else {
			doc.remove(doctor);
			System.err.println("Delete successful");
		}
		
	}
	private static Doctor getDoctorByCode(ArrayList<Doctor> doc, String code) {
		 for (Doctor doctor : doc) {
	            if (doctor.getCode().equalsIgnoreCase(code)) {
	                return doctor;
	            }
	        }
	        return null;
	}
	// tim
	public static void searchDoctor (ArrayList<Doctor> doc) {
		System.out.println("Enter Code");
		String code = Validate.checkInputString();
		if(Validate.checkIdExist(doc, code)) {
			System.err.println("Not found doctor:");
			return;
		}
		for (Doctor doctor : doc) {
			if(doctor.getCode().equalsIgnoreCase(code)) {
				System.out.println(doctor.getCode());
				System.out.println(doctor.getName());
				System.out.println(doctor.getSpecialization());
				System.out.println(doctor.getAvailabillity());
				
			}
		}
	}
}
