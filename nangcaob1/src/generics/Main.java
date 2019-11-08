package generics;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Actor at1 = new Actor("a","Tai");
		Actor at2 = new Actor("A","Tai4");
		Actor at3 = new Actor("C","Tai3");
		Actor at4 = new Actor("B","Tai2");
		Actor at5 = new Actor("D","Tai1");
		
		Actor [] actor = new Actor [] {at1,at2,at3,at4,at5};		
		Arrays.sort(actor);
		for (int i = 0;i <actor.length;i++) {
			System.out.println(actor[i].getFistName()+" " +actor[i].getLastName());
		}
	}
}
