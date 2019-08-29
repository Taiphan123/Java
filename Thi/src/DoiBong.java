import java.util.Scanner;

abstract public class DoiBong {
		private String hoTen;
		private String cauLacBo;
		private int tuoi;
		private float luong;
		public DoiBong() {

			super();
			// TODO Auto-generated constructor stub
		}

		public DoiBong(String hoTen, String cauLacBo, int tuoi,float luong) {
			super();
			this.hoTen = hoTen;
			this.cauLacBo = cauLacBo;
			this.tuoi=tuoi;
			this.luong=luong;
		}
		
		
		public String getHoTen() {
			return hoTen;
		}
		public void setHoTen(String hoTen) {
			this.hoTen = hoTen;
		}
		public String getCauLacBo() {
			return cauLacBo;
		}
		public void setCauLacBo(String cauLacBo) {
			this.cauLacBo = cauLacBo;
		}
		public int getTuoi() {
			return tuoi;
		}
		public void setTuoi(int tuoi) {
			this.tuoi = tuoi;
		}
		public float getLuong() {
			return luong;
		}
		public void setLuong(float luong) {
			this.luong = luong;
		}
		public abstract float thuong();
		public abstract float phuCap();
		public void xuat() {
			System.out.printf("nhap ho ten:%s |",this.hoTen);
			System.out.printf("nhap cau lac bo: %s|",this.cauLacBo);
			System.out.printf("nhap tuoi : %d |",this.tuoi);
			System.out.printf("nhap luong : %f |",this.luong);
		}
		public void nhap() {
			Scanner sc= new Scanner (System.in);
			System.out.println("ho ten ");
			this.hoTen=sc.nextLine();
			System.out.println("nhap ten cau lac bo:");
			this.cauLacBo=sc.nextLine();
			System.out.println("nhap tuoi");
			this.tuoi=sc.nextInt();
			System.out.println("nhap luong");
			this.luong=sc.nextFloat();
		}
		abstract float tinhThunhap();
}
