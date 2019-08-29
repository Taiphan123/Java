
public class DayException extends Exception {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void DayException(String msg) {
		this.msg = msg;
	}
	static void day(int Ngay,int Thang,int Nam) throws DayException {
		if(Ngay>31||Ngay<0) {
			throw new DayException();
		}
		if(Thang>12||Thang<0) {
			throw new DayException();
		}
		if(Nam<0) {
			throw new DayException();
		}
	}
	static void diem(float diem) throws DayException {
		if(diem<0||diem>10) {
			throw new DayException();
		}
	}

}
