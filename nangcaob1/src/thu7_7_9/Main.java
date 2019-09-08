package thu7_7_9;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Contract> list = new ArrayList<>();
		list.add(new Contract(1, "Le Thi Thuy Vi", "Da nang", "VietNam", "1234567890", "Vi1", "Le Thi Thuy"));
		list.add(new Contract(2, "Le Thi Thuy Vi", "Da nang", "VietNam", "1234567890", "Vi2", "Le Thi Thuy"));
		list.add(new Contract(3, "Le Thi Thuy Vi", "Da nang", "VietNam", "1234567890", "Vi3", "Le Thi Thuy"));
		while (true) {
			int choice = Manager.menu();
			switch (choice) {
			case 1:
				Manager.createContract(list);
				break;
			case 2:
				Manager.printAllContract(list);
				break;
			case 3:
				Manager.deleteContractId(list);
				break;
			case 4:
				Manager.findFistName(list);
				break;
			case 5:
				return;
			}
		}
	}
}
