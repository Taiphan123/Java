package bai8;

public class NhanVien extends CanBo {
	String phongBan;
	int soNgayCong,choose;
	String chucVu;
	
	public NhanVien() {
		
	}
	public NhanVien(String phongBan, int soNgayCong, String chucVu) {
		super();
		this.phongBan = phongBan;
		this.soNgayCong = soNgayCong;
		this.chucVu = chucVu;
	}
	public String getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}
	public int getSoNgayCong() {
		return soNgayCong;
	}
	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	
	@Override
	public double tinhLuong() {
		return this.getHeSoLuong()*730+this.getPhuCap()+this.soNgayCong*200;
	}
	
	@Override
	public void Nhap() {
		super.Nhap();
		System.out.println("Nhap Khoa");
		phongBan = sc.nextLine();
		do {
			System.out.println("nhap trinh do (1- cu nhan, 2 - thac si, 3- tien sy");
			choose = sc.nextInt();
			switch (choose) {
			case 1: chucVu = "Truong Phong"; this.setPhuCap(2000); break;
			case 2: chucVu = "Pho Phong"; this.setPhuCap(1000); break;
			case 3: chucVu = "Nhan Vien"; this.setPhuCap(500); break;

			default:
				System.out.println("Chon khong dung!");break;
			}
			
		}while (choose<1||choose>3);
		System.out.println("Nhap so ngay cong :");
		soNgayCong = sc.nextInt();
	}
	@Override
	public String toString() {
		return "NhanVien [phongBan=" + phongBan + ", soNgayCong=" + soNgayCong + ", choose=" + choose + ", chucVu="
				+ chucVu + "]";
	}
	
	
}
