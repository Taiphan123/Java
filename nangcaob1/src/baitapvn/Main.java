package baitapvn;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Doctor> dc = new ArrayList<Doctor>();
		while (true) {
			int choice = Manager.menu();
			switch (choice) {
			case 1:
				Manager.addDoctor(dc);
				break;
			case 2:
				Manager.updateDoctor(dc);
				break;
			case 3:
				Manager.deleteDoctor(dc);
				break;
			case 4:
				Manager.searchDoctor(dc);
				break;
			case 5:
				return;
			}

		}
	}
}
