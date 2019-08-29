import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class menu1 {

	static public void show() {
		
		ArrayList<SinhVien> sv=new ArrayList<SinhVien>();
		
		System.out.println("1. them sinh vien\n" + "2. cap nhat thong tin\r\n" + "3. xoa sinh vien\r\n"
				+ "4. sap xep\r\n" + "5. Hien thi.\r\n"  + "6. Doc File.\r\n"+ "7.Luu File\r\n"+"0. Exit");
		int n = 0;
		int b, a = 1;
		Scanner sc = new Scanner(System.in);
		

		while (a != 0) {
			System.out.println("moi nhap lua chon");
			b = sc.nextInt();
			switch (b) {
			case 0: {
				System.out.println("ket thuc");
				System.exit(0);
				break;
			}
			case 1: {
				System.out.println("so sinh vien can nhap");
				n = sc.nextInt();
				System.out.println("them sinh vien");
				for (int i = 0; i < n; i++) {
				SinhVien sv1=new SinhVien();
					sv1.nhap(sv);
					sv.add(sv1);
				}
				break;
			}
			case 2: {
				System.out.println("cap nhat thong tin");
				{
					int c;
					System.out.println("moi nhap id can Update");
					c = sc.nextInt();
					for (int i = 0; i < n; i++) {
						SinhVien t = sv.get(i);
						if( c == t.getId()) {
							SinhVien sv1=new SinhVien();
							sv1.nhap(sv);
							sv.set(i, sv1 );
							System.out.println("da update thanh cong!");
							break;
						}
						else System.out.println("khong ton tai phan tu!");
						
					}
				}
				break;
			}
			case 3: {
				int c;
				System.out.println("moi nhap id can Xoa");
				c = sc.nextInt();
				for (int i = 0; i < n; i++) {
					SinhVien t=sv.get(i);
					if(c==t.getId()) {
						sv.remove(i);
						System.out.println("da xoa thanh cong");
						break;
					}
					else System.out.println("khong ton tai id");
				}
				break;
			}

			case 4: {
				System.out.println("sap xep theo ten");
				for (int i = 0; i < n; i++) {
					sv.sort(new Comparator<SinhVien>() {

						@Override
						public int compare(SinhVien sv1, SinhVien sv2) {
							// TODO Auto-generated method stub
							return sv1.getName().compareTo(sv2.getName());
						}
					});
					System.out.println("da sap xep");;
				}
				break;
			}
			case 5: {
				System.out.println("hien thi");
				for(SinhVien sv2:sv){
					sv2.xuat();
				}
				break;
			}
			case 6:{
				System.out.println("ghi file");
				
				try {
					FileOutputStream fos = new FileOutputStream("my.txt");
					ObjectOutputStream oos =new ObjectOutputStream(fos);
					oos.writeObject(sv);
					System.out.println("ghi file thanh cong!");
					oos.close();
					
				} catch (Exception e) {
					System.out.println("nhap sai!");
				}
			}break;
			case 7:{
				FileInputStream fis =null;
				ObjectInputStream ois =null;
				try {
					fis = new FileInputStream("my.txt");
					ois = new ObjectInputStream(fis);
					sv = (ArrayList<SinhVien>)ois.readObject();
					System.out.println("doc file thanh cong!");
					for(SinhVien sv2:sv){
						sv2.xuat();
					}
					ois.close();
					fis.close();
				} catch (Exception e) {
					System.out.println("co loi: "+e);
				}
			}break;
			default:System.out.println("khong tim thay lua chon!!!");break;
			}
		}
	}



}
