package model;

public class MonHoc {
	private String maMonHoc;
	private String tenMH;
	private int soTinChi;
	private int gioHoc;
	
	
	public MonHoc(String maMonHoc, String tenMH, int soTinChi, int gioHoc) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMH = tenMH;
		this.soTinChi = soTinChi;
		this.gioHoc = gioHoc;
	}
	public String getMonHoc() {
		return maMonHoc;
	}
	public void setMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public int getSoTinChi() {
		return soTinChi;
	}
	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}
	public int getGioHoc() {
		return gioHoc;
	}
	public void setGioHoc(int gioHoc) {
		this.gioHoc = gioHoc;
	}
	
	@Override
	public String toString() {
		return "\n MaMonHoc: " + maMonHoc
				+ "\n TenMonHoc : " + tenMH
				+ "\n SoTinChi : " + soTinChi
				+ "\n GioHoc : " + gioHoc+"\n";
	}
	

}
