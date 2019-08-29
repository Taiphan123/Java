import java.util.Scanner;

public class mang {
	public static void main(String[] args) {
		SinhVien danhsach[] = new SinhVien[10];
		int n;
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("nhap so sinh vien:");
			n = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n; i++) {
				danhsach[i] = new SinhVien();
				danhsach[i].Nhap();
				if (danhsach[i].ten.equals(""))
					break;
			}
			for (int i = 0; i < n; i++) {
				danhsach[i].Xuat();
				System.out.printf("Hoc luc:");
				danhsach[i].tongket();
			}
			System.out.println("sau khi xap xep la:");

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (danhsach[i].sosanh(danhsach[j]) == 1) {
						SinhVien tam = danhsach[j];
						danhsach[j] = danhsach[i];
						danhsach[i] = tam;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				danhsach[i].Xuat();
			}
		
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("vui long nhap lai!");
		}

}}

class SinhVien {
	public String ten;
	public float diem;

	public void Xuat() {
		System.out.println("ten:" + this.ten);
		System.out.println("diem:" + this.diem);
	}

	public void Nhap() {
		int i = 0;
		System.out.println("Moi nhap ten sinh vien");
		this.ten = new Scanner(System.in).nextLine();
		System.out.println("Moi nhap diem sinh vien");
		this.diem = new Scanner(System.in).nextFloat();
	}

	public int sosanh(SinhVien d) {
		if (this.diem < d.diem) {
			return 1;
		} else
			return 0;
	}

	public void tongket() {
		String a,b,c;
//		boolean c;
		a=(this.diem<5)?("Yeu"):(b=(this.diem >= 5 && this.diem < 6.5)?("trungbinh"):(c=(this.diem >= 7.5 && this.diem < 9)?("kha"):("gioi")));
		System.out.println(a);
//		if (this.diem < 5) {
//			System.out.println("Yeu");
//		}
//		if (this.diem >= 5 && this.diem < 6.5) {
//			System.out.println("trung binh");
//		}
//		if (this.diem >= 7.5 && this.diem < 9) {
//			System.out.println("Kha");
//		}
//		if (this.diem >= 9) {
//			System.out.println("Gioi");
//		}
	}
}
