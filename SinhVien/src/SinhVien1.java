import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SinhVien1 {
	Scanner sc= new Scanner (System.in);
	private String hoTen;
	private float diem;
	private Date ngay;
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public float getDiem() {
		return diem;
	}
	public void setDiem(float diem) {
		this.diem = diem;
	}
	public void nhap() {
		System.out.println("nhap ho ten");
		this.hoTen=sc.nextLine();
		System.out.println("nhap diem");
		checkDiem();
		System.out.println("ngay-thang-nam:");
		String a=sc.nextLine();
		this.ngay=Day(a);
	}
	public void xuat() {
		System.out.println("ho ten:"+this.hoTen);
		System.out.println("diem:"+this.diem);
		System.out.printf("%s %tB %<te, %<tY","Date la:",this.ngay);
	}
	void checkDiem() {
		while(true) {
			try {
				this.diem=Float.parseFloat(sc.nextLine());
				DayException.diem(diem);break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Nhap diem khong hop le!");
			}
		}
	}
	public Date Day(String s) {
		Date ngay=null;
		SimpleDateFormat n = new SimpleDateFormat("dd-MM-yyyy");
		try {
			ngay=n.parse(s);
		} catch (Exception e) {
			System.out.println("Ngay thang khong hop le!");
		}
		return ngay;
	}
}
