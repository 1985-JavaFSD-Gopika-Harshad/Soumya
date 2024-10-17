//17-10-24

package coding_challenges.collections;

import java.util.*;
public class Stack_Imp {

	public static void main(String[] args) {
		
		//creating stack 
		Stack<Integer> stack = new Stack<>();
		
		// adding items onto the stack
		stack.push(10);   
		stack.push(20);
		stack.push(30);
		stack.push(50);
        stack.push(30);     //allows duplicate values
        stack.push(null);  //allows null values
		System.out.println(stack);
		
		System.out.println(stack.peek());   //returns top of the stack without removing
		
		System.out.println(stack.pop());   // removes top of the stack
		
		System.out.println(stack);
		System.out.println(stack.isEmpty());  // checks if stack is empty
		
 		System.out.println(stack.size());     //returns the no. of items in stack
 		
        System.out.println(stack.search(20)); // returns the position of the item
	}

}
