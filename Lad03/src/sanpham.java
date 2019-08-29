import java.util.Scanner;

public class sanpham {
	private String tenSp;
	private double donGia;
	private double giamGia;
	
	
	public String getTenSp() {
		return tenSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	private double getThueNhapKhau() {
		double thueNK;
		thueNK = (double) this.donGia * 0.1;
		return thueNK;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap ten:");
		this.tenSp = sc.nextLine();
		System.out.println("nhap don gia:");
		this.donGia = sc.nextDouble();
		System.out.println("nhap giam gia:");
		this.giamGia = sc.nextDouble();
	}
	
	public void xuat() {
		System.out.printf("ten:%s \t don gia:%.2f \t giam gia:%.2f \t thue:%.2f \t \n", this.tenSp, this.donGia,
				this.giamGia, this.getThueNhapKhau());
	}
}
