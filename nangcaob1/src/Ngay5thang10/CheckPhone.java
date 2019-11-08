package Ngay5thang10;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPhone {
	public static boolean checkFormatNumberPhone(String text) {
		Pattern pattern = Pattern.compile("(09|07|05|03[2|6|8|9])+([0-9]{8})\\b");
		Matcher matcher = pattern.matcher(text);
		return (matcher.find());
	}
	public static void main(String[] args) {
		String res;
		Scanner sc = new Scanner (System.in);
		while (true) {
			try {
				res = sc.nextLine();
				if (!checkFormatNumberPhone(res)) {
					throw new Exception();
				}
			} catch (Exception e) {
				System.err.println("format numberphone error - please reinput numberphone");
			}
		}
	}
	
}
