package in_out_flie;

import java.util.ArrayList;
import java.util.Collections;

public class Main2 {
	public static void main(String[] args) {
		ArrayList<Product> pro = new ArrayList<Product>();
		while (true) {
			int choice = Manager.menu();
			switch (choice) {
			case 1:
					Manager.addProduct(pro);
				break;
			case 2:
					Manager.updateProduct(pro);
				break;
			case 3:
					Manager.allProduct(pro);	
				break;
			case 4:
				Collections.sort(pro);
				Manager.allProduct(pro);
				break;
			}

		}

	}
}
