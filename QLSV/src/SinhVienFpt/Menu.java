package SinhVienFpt;

import java.util.Scanner;

public class Menu {
	public void Menu() {
		SinhVienFpt[] it = new SinhVienIT[10];
		SinhVienFpt[] biz = new SinhVienBiz[10];
		int n, c = 1, a = 0, b = 0;
		System.out.println("1. nhap danh sach sinh vien\r\n" + "2. xuat thong tin sinh vien\r\n"
				+ "3. xuat danh sach sinh vien co hoc luc gioi\r\n" + "4. sap xep sinh vien theo diem\r\n"
				+ "5. Ket thuc\r\n" + "");
		while (c != 5) {
			Scanner sc = new Scanner(System.in);
			System.out.println("moi nhap su lua chon:");
			n = sc.nextInt();
			switch (n) {
			case 1: {
				System.out.println("nhap danh sach sinh vien");
				System.out.println("so luong sinh vien IT");
				a = sc.nextInt();
				for (int i = 0; i <= a; i++) {
					it[i] = new SinhVienIT();
					it[i].nhap();
				}
				System.out.println("so luong sinh vien Biz");
				b = sc.nextInt();
				for (int i = 0; i < b; i++) {
					biz[i] = new SinhVienBiz();
					biz[i].nhap();
				}
				break;

			}
			case 2: {
				System.out.println("Xuat thong tin sinh vien IT");
				for (int i = 0; i < a; i++) {
					it[i].xuat();
				}
				System.out.println("Xuat thong tin sinh vien Biz");
				for (int i = 0; i < b; i++) {
					biz[i].xuat();
				}
				break;
			}
			case 3: {
				System.out.println("sinh vien co hoc luc gioi IT");
				for (int i = 0; i < a; i++) {
					if (it[i].getHocLuc() == "Gioi") {
						it[i].xuat();
					}
				}
				System.out.println("sinh vien co hoc luc gioi BIZ");
				for (int i = 0; i < b; i++) {
					if (biz[i].getHocLuc() == "Gioi") {
						biz[i].xuat();
					}
				}
				break;
			}
			case 4: {
				for (int i = 0; i < a; i++) {
					for (int j = 0; j < a; j++) {
						if (it[i].getDiem() > it[j].getDiem()) {
							SinhVienIT lon = (SinhVienIT) it[i];
							it[i] = it[j];
							it[j] = lon;
						}
					}

				}
				System.out.println("da sap xep sinh vien it");
				for (int i = 0; i < b; i++) {
					for (int j = 0; j < b; j++) {
						if (biz[i].getDiem() > biz[j].getDiem()) {
							SinhVienBiz lon = (SinhVienBiz) biz[i];
							biz[i] = biz[j];
							biz[j] = lon;
						}
					}
				}
				System.out.println("da sap xep sinh vien biz");
				System.out.println("da sap xep xong moi bam lai so 2");
				break;
			}
			case 5: {
				c = 5;
				System.out.println("ket thuc");
				break;
			}

			}
		}
	}
}
