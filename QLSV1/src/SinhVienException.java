import java.util.ArrayList;

public class SinhVienException extends Exception {
	private String mgs;

	public String getMgs() {
		return mgs;
	}

	public SinhVienException(String mgs) {
		this.mgs = mgs;
	}
	public String toString() {
		return mgs;
	}
	static void checkHoTen(String hoTen)throws SinhVienException{
		if(hoTen.isEmpty()) {
			 throw new SinhVienException("yeu cau nhap lai!");
		}
	}
	static void checkMASV(int ID, ArrayList<SinhVien> arr) throws SinhVienException{
		String s;
		s=String.valueOf(ID);
		if(s.equals(null)) {
			throw new SinhVienException("yeu cau nhap lai!");
		} else {
			for (SinhVien sv : arr) {
				if (sv.getId() == ID) {
					throw new SinhVienException("ID da ton tai!"); 
				}
			}
		}
	}
	static void checkDiem(float diem) throws SinhVienException{
		if(diem>10||diem<0) {
			throw new SinhVienException("Yeu cau nhap lai!");
		}
	}
	static void checkTuoi(int tuoi) throws SinhVienException{
		if(tuoi>100||tuoi<0) {
			throw new SinhVienException("Yeu cau nhap lai!");
		}
	}
}
