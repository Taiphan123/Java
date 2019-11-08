import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientExample {
	public static void main(String[] args) {
		try {
			Socket socketAtClient = new Socket("localhost",2010);
			String s = "Hello Tai Phan";
			// 1 . Client sends to server
			OutputStream os = socketAtClient.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(s);
			oos.flush();
			// 4 Client receives
			InputStream is = socketAtClient.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			s = (String) ois.readObject();
			System.out.println("Client receives"+s);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
