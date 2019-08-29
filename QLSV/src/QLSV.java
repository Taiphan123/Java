import java.util.Scanner;


public class QLSV {
	public static void main(String[] args) {
		int n,a=0;
		Scanner sc=new Scanner (System.in);
		SinhVien []sv=new SinhVien[3];

		while(a!=5) {
			System.out.println("moi nhap lua chon");
			n=sc.nextInt();
			switch(n) {
			case 1:{
				System.out.println("Nhap danh sach sinh vien:");
				for(int i=0;i<3;i++) {
					sv[i]=new SinhVien();
					sv[i].nhap();
				}break;
			}
			case 2:{
				System.out.println("Hien thi sinh vien gioi:");
				for (int i = 0; i < 3; i++) {
					if(sv[i].xetdiem()==1) {
						System.out.println("kq la:"+sv[i].ten);
					}
				}
				break;
			}
			case 3:{
				System.out.println("Tinh sinh vien cao diem nhat lop:");
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if(sv[i].sosanh(sv[j])==1) {
							System.out.println("kq la:"+sv[i].ten+":"+sv[i].diemTB);
							break;
						}
					}
				}
				break;
			}
			case 4:{
				System.out.println("ket qua la:");
				for(int i=0;i<3;i++) {
					sv[i].xuat();	
				}break;
			}
			case 5:{
				System.out.println("Thoat chuong trinh:");
				break;
			}
			}
			
}}}