package model;

public class LopHoc {
	private String maLop;
	private String tenLop;
	private int namHoc;
	
	
	public LopHoc(int namHoc) {
		super();
		this.namHoc = namHoc;
	}

	public LopHoc(String maLop, String tenLop, int namHoc) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.namHoc = namHoc;
	}
	
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public int getNamHoc() {
		return namHoc;
	}
	public void setNamHoc(int namHoc) {
		this.namHoc = namHoc;
	}
	@Override
	public String toString() {
		return "\n MaLop: " + maLop
				+ "\n TenLopc : " + tenLop
				+ "\n NamHoc : " + namHoc +"\n";
	}
	
	
}
