//Scenario 2: store student grades in order they received with unique id

package coding_challenges.collections;

import java.util.LinkedHashMap;

public class LinkedHashmap {
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> grades= new LinkedHashMap<>();
		
		grades.put("CSE001", 70);
		grades.put("CSE002", 80);
		grades.put("CSE003", 90);
		grades.put("CSE005", 78);

		grades.put("CSE001", 72); //updates the existing value for that particular key

		System.out.println(grades); //here insertion order is preserved
		System.out.println(grades.containsKey("CSE002"));
		System.out.println(grades.containsValue(90));
	}

}
