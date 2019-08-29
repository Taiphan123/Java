package lad5;

public class StudentException extends Exception {
	private String msg;
	public StudentException(String msg) {
		this.msg=msg;
	}
	public String toString() {
		return "Exception"+msg;
	}
	static void checkDiem(float diem) throws StudentException{
		if(diem<0||diem>10) throw new StudentException("Diem phai >0 va <10");
	}
}
