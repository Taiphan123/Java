import java.util.Scanner;

public class SinhVien {
	public String ten;
	public float diemJava;
	public float diemHtml;
	public float diemTB;

	public void nhap() {
		System.out.println("nhap ten sinh vien");
		this.ten = new Scanner(System.in).nextLine();
		System.out.println("nhap diem Java sinh vien:");
		this.diemJava = new Scanner(System.in).nextFloat();
		System.out.println("nhap diem Html sinh vien:");
		this.diemHtml = new Scanner(System.in).nextFloat();
		this.diemTB = (float) ((this.diemHtml + this.diemJava) / 2);
	}

	public void xuat() {
		System.out.println("ten:\t" + this.ten);
		System.out.printf("diem Java:%.2f\t", this.diemJava);
		System.out.printf("diem Java:%.2f\n", this.diemHtml);
	}

	public float xetdiem() {
		if (diemTB >= 9) {
			return 1;
		} else
			return 0;
	}

	public int sosanh(SinhVien TB) {
		if (this.diemTB > TB.diemTB) {
			return 1;
		} else
			return 0;
	}
}
