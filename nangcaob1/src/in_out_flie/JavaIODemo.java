package in_out_flie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class JavaIODemo {
	public static void main(String[] args) {
		try {
			File fl = new File("kientruc.txt");
			FileWriter fw = new FileWriter(fl);
			
			String st[] = new String[4];
			st[0]="Tai xinh trai";
			st[1]= "Pro";
			st[2] ="Luan tuoi tom";
			st[3] ="SON AN CUC";
			for (int i = 0; i < st.length; i++) {
				fw.write(st[i]+"\n");
			}
			
			fw.close();
			fl.exists();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		// viet file
		
		try {
			File fl = new File("kientruc.txt");
			FileReader fr = new FileReader(fl);
			
			BufferedReader br = new BufferedReader(fr);
			String st;
			;
			while (((st = br.readLine()) != null)) {	
				System.out.println(st);
			}
			br.close();
			fl.exists();
		} catch (Exception e) {
			System.out.println("Loi file doc k ra");
		}
		// xuat file
		
	}
}
