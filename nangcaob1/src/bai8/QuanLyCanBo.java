package bai8;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyCanBo {
	public static void main(String[] args) {
		ArrayList<CanBo> arrCanBo = new ArrayList<CanBo>();
		int choose, soCanBo;
		double tongLuong = 0, luongThapNhat, luong;
		CanBo canbo = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhap so luong can bo trong truong:");
		soCanBo = sc.nextInt();
		for (int i = 0; i < soCanBo; i++) {
			System.out.println("Nhap thong tin can bo thu" + (i + 1) + ":");
			do {
				System.out.println("nhap loai can bo (1- giang vien , 2 - Can bo ");
				choose = sc.nextInt();
				switch (choose) {
				case 1:
					canbo = new GiangVien();
					canbo.Nhap();
					arrCanBo.add(canbo);
					break;
				case 2:
					canbo = new NhanVien();
					canbo.Nhap();
					arrCanBo.add(canbo);
					break;
				default:
					System.out.println("Khong hop le!"); break;
				}

			} while (choose < 1 || choose > 3);
		}
		System.out.println("Hien thi danh sach can bo trong truong:");
		for (CanBo canBo2 : arrCanBo) {
			System.out.println(canBo2.toString());
		}
		for (CanBo canBo2 : arrCanBo) {
			luong=canBo2.tinhLuong();
			tongLuong += luong;
		}
		System.out.println("Tong Luowng phai tra cho can bo:"+tongLuong);
	}
}
