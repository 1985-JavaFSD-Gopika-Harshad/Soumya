package coding_challenges.collections;

import java.util.ArrayList;
import java.util.Collections;

public class SwapArray {

	public static void main(String[] args) {
         
		ArrayList<Integer> array = new ArrayList<>();
		array.add(1);
		array.add(2);
		array .add(3);
		array.add(4);
		array.add(5);
		System.out.println("Before swap: "+ array);
		System.out.println(array.size());
		
        Collections.swap(array, 0, 4 ); //swap items of that particular indexes
        System.out.println("After swap: " +array);
        
	}

}
