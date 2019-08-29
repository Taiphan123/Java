import java.util.Scanner;

public class SinhVien {
	private String maSV;
	private String hoTenSV;
	private String idLop;
	// Ma_SV,Hoten_SV,ID_Lop
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHoTenSV() {
		return hoTenSV;
	}
	public void setHoTenSV(String hoTenSV) {
		this.hoTenSV = hoTenSV;
	}
	public String getIdLop() {
		return idLop;
	}
	public void setIdLop(String idLop) {
		this.idLop = idLop;
	}
	public void nhap() {
		Scanner sc = new Scanner (System.in);
		System.out.println("nhap ma sv: ");
		this.maSV = sc.nextLine();
		System.out.println("Ho Ten:");
		this.hoTenSV = sc.nextLine();
		System.out.println("id lop:");
		this.idLop = sc.nextLine();
	}
}
