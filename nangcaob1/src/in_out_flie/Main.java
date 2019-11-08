package in_out_flie;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String[] args) throws IOException {
		SinhVienFileDemo[] sinhVienDS = {new SinhVienFileDemo("Phan Van Tai",22),
				new SinhVienFileDemo("Luan",22),new SinhVienFileDemo("Son",22)};
		
		try {
			FileOutputStream fos = new FileOutputStream("sinhvien.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (int i = 0; i < sinhVienDS.length; i++) {
				oos.writeObject(sinhVienDS[i]);
			}
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.err.println("Eror"+e);
		}
		SinhVienFileDemo stTemp = new SinhVienFileDemo();
		try {
			FileInputStream fis = new FileInputStream("sinhvien.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (stTemp!=null) {
				stTemp = (SinhVienFileDemo) ois.readObject();
				System.out.println(stTemp);
			}
			ois.close();
			fis.close();
		} catch (IOException io) {
			
		} catch (ClassNotFoundException e) {
			System.err.println("Not Found"+e);
		}
		
	}
}
