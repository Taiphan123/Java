package in_out_flie;

import java.io.Serializable;

public class SinhVienFileDemo implements Serializable {
	private String hoTen;
	private int tuoi;
	public SinhVienFileDemo() {
		super();
	}
	public SinhVienFileDemo(String hoTen, int tuoi) {
		super();
		this.hoTen = hoTen;
		this.tuoi = tuoi;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	@Override
	public String toString() {
		return "SinhVienFileDemo [hoTen=" + hoTen + ", tuoi=" + tuoi + "]";
	}
	
}

