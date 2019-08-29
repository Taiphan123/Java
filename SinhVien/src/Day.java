import java.util.Scanner;

public class Day {
	private int ngay;
	private int thang;
	private int nam;
	Scanner sc =new Scanner (System.in);
	public int getNgay() {
		return ngay;
	}
	public void setNgay(int ngay) {
		this.ngay = ngay;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public void nhap(){
		System.out.println("ngay");
		checkDay();
		
	}
	public void xuat() {
		System.out.println("ngay:"+this.ngay);
		System.out.println("thang"+this.thang);
		System.out.println("nam"+this.nam);
	}
	void checkDay() {
		while(true) {
			try {
				this.ngay=sc.nextInt();
				this.thang=sc.nextInt();
				this.nam=sc.nextInt();
				DayException.day(this.ngay,this.thang,this.nam);break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Nhap ngay khong hop le!");
			}
		}
	}

}
