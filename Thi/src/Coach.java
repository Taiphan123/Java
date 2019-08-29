import java.util.Scanner;

public class Coach extends DoiBong{
	private String quocTich;
	public Coach() {
		super();
	}
	public Coach(String quocTich) {
		super();
		this.quocTich=quocTich;
	}
	public String getQuocTich() {
		return quocTich;
	}
	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}
	@Override
	public float thuong() {
		return (float) (super.getLuong()*0.1);
	}
	@Override
	public float phuCap() {
		// TODO Auto-generated method stub
		return (float) (super.getLuong()*0.2);
	}
	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner (System.in);
		System.out.println("nhap Que Quan");
		this.quocTich = sc.nextLine();

	}
	public void xuat() {
		super.xuat();
		System.out.printf("que quan : %s |",this.quocTich);
		System.out.printf("phu cap : %f |",this.phuCap());
	}
	@Override
	float tinhThunhap() {
		return this.getLuong()+this.thuong();
	}
	
}
