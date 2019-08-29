import java.util.Scanner;

public class tinhtiendien {
	public static void main(String[] args) {
		int tien;
		int soDien;
		System.out.print("nhap vao so dien:");
		Scanner sc = new Scanner(System.in);
		soDien = sc.nextInt();
		for (int i = 0; i <= soDien; i++) {
			if (soDien > 0 && soDien <= 50) {
				tien = soDien * 1000;
				System.out.printf("so tien dien phai tra la:" + tien);
				break;

			} else {
				tien = 50 * 1000 * (soDien - 50) * 1200;
				System.out.println("so tien dien phai tra la:" + tien);
				break;
			}
		}
	}
}
