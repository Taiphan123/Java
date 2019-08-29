import java.util.Scanner;

public class Player extends DoiBong{
	private String queQuan;
	private String viTri;
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(String hoTen, String cauLacBo, int tuoi,float luong) {

		super(hoTen,cauLacBo,tuoi,luong);
		// TODO Auto-generated constructor stub
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	@Override
	public float thuong() {
		return (float) (super.getLuong()*0.1);
	}
	@Override
	public float phuCap() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner (System.in);
		System.out.println("nhap Que Quan");
		this.queQuan = sc.nextLine();
		System.out.println("nhap Vi tri");
		this.viTri=sc.nextLine();
	}
	public void xuat() {
		super.xuat();
		System.out.printf("que quan : %s |",this.queQuan);
		System.out.printf("vi tri : %s |",this.viTri);
		System.out.printf("Thuong : %f |",this.thuong());
	}
	@Override
	float tinhThunhap() {
		return this.getLuong()+this.phuCap();
	}
}
