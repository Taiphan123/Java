package baitapvn;

import java.util.ArrayList;
import java.util.Scanner;

import javax.print.Doc;

import StudentManagement.Student;

public class Validate {
	private static final Scanner in = new Scanner(System.in);

	public static int checkInputIntLimit(int min, int max) {
		// loop until user input correct
		while (true) {
			try {
				int result = Integer.parseInt(in.nextLine().trim());
				if (result < min || result > max) {
					throw new NumberFormatException();

				}
				return result;
			} catch (NumberFormatException e) {
				System.err.println("Please input number in rage [" + min + ", " + max + "]");
				System.out.print("Enter again: ");
			}
		}
	}

	public static String checkInputString() {
		// loop until user input correct
		while (true) {
			String result = in.nextLine().trim();
			if (result.isEmpty()) {
				System.err.println("Not empty");
				System.out.print("Enter again: ");
			} else {
				return result;
			}
		}
	}

	public static int checkInputInt() {
		while (true) {
			try {
				int result = in.nextInt();
				return result;
			} catch (NumberFormatException e) {
				System.err.println("Must be input integer.");
				System.out.print("Enter again: ");
			}
		}
	}

	public static double checkInputDouble() {
		while (true) {
			try {
				double result = in.nextDouble();
				return result;
			} catch (NumberFormatException e) {
				System.err.println("Must be input double");
				System.out.print("Enter again: ");
			}

		}
	}
	// nhap nua hay khong
	public static boolean checkInputYN() {
		System.out.print("Do you want to continue (Y/N)? ");
		while (true) {
			String result = checkInputString();

			if (result.equalsIgnoreCase("Y")) {
				return true;
			}

			if (result.equalsIgnoreCase("N")) {
				return false;
			}
			System.err.println("Please input y/Y or n/N.");
			System.out.print("Enter again: ");
		}
	}
	
	// kiem tra co ton tai Id nay chua
	public static boolean checkIdExist(ArrayList<Doctor> ls, String code) {
        for (Doctor doctor : ls) {
			if(code.equalsIgnoreCase(doctor.getCode())) {
				return false;
			}
		}
        return true;
    }
	
	public static boolean checkChangeInfomation(Doctor doctor, String code,
            String name, String specialization, String availability) {
        if (code.equalsIgnoreCase(doctor.getCode())
                && name.equalsIgnoreCase(doctor.getName())
                && specialization.equalsIgnoreCase(doctor.getSpecialization())
                && availability.equalsIgnoreCase(doctor.getAvailabillity())) {
            return false;
        }
        return true;
    }
}
