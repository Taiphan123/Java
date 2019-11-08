package Ngay5thang10;

import java.util.ArrayList;
import java.util.Collections;

public class DoctorDriver {
	public static void main(String[] args) {
		ArrayList<Doctor> dc = new ArrayList<Doctor>();
		
		for (int i = 0; i < 2; i++) {
			Doctor doc = new Doctor();
			doc.enterDoctor();
			dc.add(doc);
		}
		Collections.sort(dc);
		// System.out.println(dc);
		for (Doctor doctor : dc) {
			doctor.display();
		}

	}
}
