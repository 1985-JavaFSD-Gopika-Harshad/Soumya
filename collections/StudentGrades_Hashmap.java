// Scenario 5: to store each student with their grades using key-value pair relation

package coding_challenges.collections;

import java.util.HashMap;

public class StudentGrades_Hashmap {

	public static void main(String[] args) {
		// create a HasMap to store student grades
		HashMap<String, String> students= new HashMap<>();
		students.put("S001", "A");  //put is used to add and update the values
		students.put("S003", "B+");
		students.put("S015", "C");
		System.out.println(students);
		
		
		//to retrieve grade for particular student
		String studentId ="S015";
		System.out.println("StudentId :" + studentId +" " +"StudentGrade :" +students.get(studentId));

	}

}
