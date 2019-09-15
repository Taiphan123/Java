package HashMap;

import java.security.KeyStore.Entry;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class TuDien {
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("TaO 7", "Apple");
		map.put("tAO 8", "Apple Green");
		map.put("TAO 9", "Apple Red");
		map.put("Tao 10", "Apple Gray");
		map.put("TaO 1", "Apple 5");
		map.put("TaO 2", "Apple 6");
		map.put("TaO 3", "Apple 7");
		map.put("TaO 4", "Apple 8");
		map.put("TaO 5", "Apple 9");
		map.put("TaO 6", "Apple 10");
		
		Set<java.util.Map.Entry<String,String>> entrySet = map.entrySet();
		for (java.util.Map.Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		
	}
}
