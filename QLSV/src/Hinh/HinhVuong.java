package Hinh;

public class HinhVuong extends HinhChuNhat {
	private int canh;

	public HinhVuong(int canh) {
		this.canh = canh;
	}

	public int getCanh() {
		return canh;
	}

	public void setCanh(int canh) {
		this.canh = canh;
	}

	public double dienTich() {
		return (Math.pow(this.canh, 2));
	}

	public void xuat() {
		System.out.println("canh:" + this.canh);
		System.out.println("dien tich:" + dienTich());
	}
}
