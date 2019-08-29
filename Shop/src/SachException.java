import java.util.Scanner;

public class SachException extends Exception {
	private String msg;

	public SachException(String string) {
		// TODO Auto-generated constructor stub
	}


	public String getMsg() {
		return msg;
	}

	public void SachException(String msg) {
		this.msg = msg;
	}
	public String toString() {
		return msg;
	}
	static void luaChon(int n) throws SachException {
		Scanner sc = new Scanner (System.in);
		if(n==Integer.parseInt(sc.nextLine()))
		throw new SachException ("lua chon bang so!");
	}
	static void tacGia(String s1,String s2) throws SachException {
		if(s1.isEmpty()||s2.isEmpty())
		throw new SachException("tac gia tac pham k dc trong!");
	}
	static void donGia(float n) throws SachException {
		Scanner sc = new Scanner (System.in);
		if(n<0)
		throw new SachException ("khong am!");
	}
}
