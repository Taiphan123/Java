import java.util.Scanner;

public class User{
	private String users;
	private String password;
	private String chucNang;
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getChucNang() {
		return chucNang;
	}
	public void setChucNang(String chucNang) {
		this.chucNang = chucNang;
	}
	public void nhap() {
		Scanner sc = new Scanner (System.in);
		System.out.println("nhap username:");
		this.users = sc.nextLine();
		System.out.println("nhap password:");
		this.password=sc.nextLine();
	}
}
