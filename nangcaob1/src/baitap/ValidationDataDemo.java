package baitap;

import java.util.Scanner;

public class ValidationDataDemo {
	private static final Scanner in = new Scanner(System.in);

	public static String checkInputString() {
		while (true) {
			String result = in.nextLine();
			if (result.isEmpty()) {
				System.err.println("No empty");
				System.err.println("Enter again");
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

	public static void main(String[] args) {
		while (true) {
			System.out.print("Enter fruit id: ");
			String fruitId = checkInputString();
			System.out.print("Enter fruit name: ");
			String fruitName = checkInputString();
			System.out.print("Enter price: ");
			double price = checkInputDouble();
			System.out.print("Enter quantity: ");
			int quantity = checkInputInt();
			System.out.print("Enter origin: ");
			String origin = checkInputString();
			System.out.println(fruitId + " " + fruitName + " " + price + " " + quantity + " " + origin);
			// check user want to continue or not
			if (checkInputYN() == false) {
				return;
			}
		}

	}

}
