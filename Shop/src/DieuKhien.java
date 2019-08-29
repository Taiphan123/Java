import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class DieuKhien implements Serializable{
	public static void luuFile(ArrayList<Sach> a) {
		try {
			FileOutputStream fos = new FileOutputStream("toi.txt");
			ObjectOutputStream oos =new ObjectOutputStream(fos);
			oos.writeObject(a);
			System.out.println("Luu lich su thanh cong!");
			oos.close();
			
		} catch (Exception e) {
			System.out.println("That bai!");
		}
	}
	public static ArrayList<Sach> xuatFile() {
		FileInputStream fis =null;
		ObjectInputStream ois =null;
		try {
			fis = new FileInputStream("toi.txt");
			ois = new ObjectInputStream(fis);
			return  (ArrayList<Sach>)ois.readObject();	
		} catch (Exception e) {
			System.out.println("co loi: "+e);
		}
		return null;
	}
}
