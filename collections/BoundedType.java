package coding_challenges.collections;

import java.util.Arrays;
import java.util.List;

public class BoundedType {
	//method to print a list of elements bounded to the Number type and prints each element.
	public static void printList(List<? extends Number> list) {
		for(Number number : list ) {
			System.out.println(number);
		}
	}

	public static void main(String[] args) {
		
		//List.of()- it is a factory method introduced in Java 9, used to create immutable lists
	//	List<Integer> list = List.of(10, 20, 30, 40, 50);

		List<Integer> list1 = Arrays.asList(10, 20, 30, 40, 50);  //old method
		List<Float>  list2 = Arrays.asList(1.1f, 1.2f, 1.3f);
		
		System.out.println("Integer List: ");
		printList(list1);
		
		System.out.println("Float List: ");
		printList(list2);
 
	}

}
