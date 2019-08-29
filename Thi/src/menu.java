import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class menu {
	

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		  int n2 = 0,n1 = 0;

			 ArrayList<DoiBong> db = new ArrayList<>();
			System.out.println("1. Nhap danh sach huan luan vien va cau thu.\r\n" + "2. Hien danh sach cau thu\r\n"
					+ "3. Hien thi danh sach huan luan vien\r\n" + "4. Hien thi huan luan vien va cau thu\r\n"
					+ "5. Sap xep theo ten.\r\n" + "6. Tinh tong chi phi phai tra cho cau lac bo\r\n"
					+ "7. Tim cau lac bo co ds huan luan vien nhieu nhat\r\n" + "0. Thoat:");
		while (true) {

			System.out.println("nhap lua chon:");
			int c = Integer.parseInt(sc.nextLine());
			switch (c) {
			case 0:
				System.exit(0);
			case 1: 
				System.out.println("nhap danh sach huan luan vien");
				n1 = sc.nextInt();
				for (int i = 0; i < n1; i++) {
					DoiBong coach = new Coach();
					coach.nhap();
					db.add(coach);
				}
				
				System.out.println("danh sach cau thu");
				n2 = sc.nextInt();
				for (int i = 0; i < n2; i++) {
					Player player = new Player();
					player.nhap();
					db.add(player);
				}
			
				break;
			case 2: {
				for (DoiBong ps : db) {
					if (ps instanceof Player) {
						Player pl = (Player) ps;
						pl.xuat();
					}
				}
			}
				break;
			case 3:
				for (DoiBong ps : db) {
					if (ps instanceof Coach) {
						Coach ch = (Coach) ps;
						ch.xuat();
					}
				}
				break;
			case 4:{
				for (DoiBong ps : db) {
					ps.xuat();
				}
			}			
				break;
			case 5:
			{
				for (int i = 0; i < n2; i++) {
					Comparator<Player> comparator = new Comparator<Player>() {

						@Override
						public int compare(Player o1, Player o2) {

							if (o1.getHoTen().compareTo(o2.getHoTen()) > 0) {
								return 1;
							} else {
								return 0;
							}
						}
					};
				}
				System.out.println("da sap xep!");
			}break;
			case 6:{
			float tong1=0;
			for (int i = 0; i < n1; i++) {
				DoiBong pl = new Player();
				tong1+=pl.tinhThunhap();
			}
			float tong2 = 0;
			for (int i = 0; i < n2; i++) {
				DoiBong coach = new Coach();
				tong2+=coach.tinhThunhap();
			}
			System.out.println("Tong luong phai tra la:"+(tong1+tong2));
			}break;
			case 7:{
				
			}break;
			}
		}
	}

}
