import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverExample {

	public static void main(String[] args) {
		try {
			System.out.println("Begin server");
			ServerSocket ss = new ServerSocket(2010);
			Socket socketAtServer = ss.accept();
			
			// 2. Server receives
			InputStream is = socketAtServer.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			String s = (String) ois.readObject();
			System.out.println("Server receives"+s);
			
			// 3 server reply
			OutputStream os = socketAtServer.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			s="Ok";
			oos.writeObject(s);
			oos.flush();
			System.out.println("end server");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
