import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Menu {
	public  void show() {
		int a,n = 0;
		ArrayList<Sach> sach = new ArrayList <Sach>();
		ArrayList<Sach> sachban = new ArrayList <Sach>();
		System.out.println("1. Nhap sach\r\n" + 
				"2. Hien thi\r\n" + 
				"3. Thuc hien ban sach va luu tru\r\n" + 
				"4. Sap xep theo don gia\r\n" + 
				"5. Tim theo nha xuat ban va danh muc.\r\n" + 
				"6. Tong doanh thu.\r\n"+
				"7. Lich su ban.\r\n"+
				"0. Thoat.");

		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("nhap lua chon cua ban:");
			a=Integer.parseInt(sc.nextLine());
			
			switch(a) {
			case 0:{
				System.out.println("Ket thuc!");
				System.exit(0);
			}
			case 1:{
				System.out.println("nhap sach:");
					Sach book = new Sach();
					book.nhapSach();
					sach.add(book);
			}break;
			case 2:{
				for (Sach sach2 : sach) {
					sach2.xuatSach();
				}
			}break;
			case 3:{
				System.out.println("nhap sach can ban:");
				String str = sc.nextLine();
				Sach ban = new Sach();
				for (int i = 0; i < sach.size(); i++) {
					if(str.equals(sach.get(i).getTenSach())) {
						ban.setTenSach(sach.get(i).getTenSach());
						ban.setTacGia(sach.get(i).getTacGia());
						ban.setNhaXuatBan(sach.get(i).getNhaXuatBan());
						ban.setNamXuatBan(sach.get(i).getNamXuatBan());
						ban.setDanhMuc(sach.get(i).getDanhMuc());
						ban.setDonGia (sach.get(i).getDonGia());
						sach.remove(i);
						break;	
					}
					else System.out.println("k co ten sach hoac rong");break;
				}						
				sachban.add(ban);
				DieuKhien.luuFile(sachban);
			}break;
			case 4:{
				for(int i=0;i<sach.size();i++) {
				Collections.sort(sach, new Comparator<Sach>() {

					@Override
					public int compare(Sach s1, Sach s2) {
						return (int)(s1.getDonGia()-s2.getDonGia());
					}
				});
				}
				System.out.println("da sap xep!");}break;
			case 5:{
				System.out.println("nhap nha xuat ban hoac danh muc:");
				String k = sc.nextLine();
				for (int i = 0; i < sach.size(); i++) {
					if(k.equals(sach.get(i).getDanhMuc())||k.equals(sach.get(i).getNhaXuatBan())) {
						System.out.println("Ten sach la:"+sach.get(i).getTenSach());
					}
				}
			}break;
			case 6:{
				float tong=0;
				System.out.println("Tong thu:");
				for (int i = 0; i < sachban.size(); i++) {
				 tong = (tong+sachban.get(i).getDonGia());
				}
				System.out.printf("tong:%.3f+"+tong);
			}break;
			case 7:{
				System.out.println("Xem lich su ban sach");
				sachban=DieuKhien.xuatFile();
			}break;
			default: System.out.println("Chon lai");break;
			}
		}
	}
}
