package model;

public class Diem {
	private String MSV;
	private String MaMH;
	private float diem;
	
	
	public Diem(String mSV, String maMH, float diem) {
		super();
		MSV = mSV;
		MaMH = maMH;
		this.diem = diem;
	}
	public String getMSV() {
		return MSV;
	}
	public void setMSV(String mSV) {
		MSV = mSV;
	}
	public String getMaMH() {
		return MaMH;
	}
	public void setMaMH(String maMH) {
		MaMH = maMH;
	}
	public float getDiem() {
		return diem;
	}
	public void setDiem(float diem) {
		this.diem = diem;
	}
	
	@Override
	public String toString() {
		return "\n MaSV: " + MSV
				+ "\n MaMonHoc : " + MaMH
				+ "\n Diem : " + diem +"\n";
	}
}
