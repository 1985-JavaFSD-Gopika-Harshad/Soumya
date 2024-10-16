//Scenario 4 : to store collection of employee objects and sort then a/c to their salary in desc order

package coding_challenges.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class employee {
	private String name;
	private double salary;
	

	public employee(String name, double salary) {
 		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "employee [name=" + name + ", salary=" + salary + "]";
	}
	

}
 class emp{

	public static void main(String[] args)
	{
		
		List<employee> emp= new ArrayList<>();  // creating ArrayList to store employee objects
		
		//adding objs to list
		emp.add(new employee("soumya", 25000));
		emp.add(new employee("vyshnavi", 39000));
		emp.add(new employee("ananya", 35000));

		
		// sort employee in descending order based on salary using collections.sort() with a comparator
		Collections.sort(emp, new Comparator<employee>() {

			@Override
			public int compare(employee e1, employee e2) {
				
 	//			return Double.compare(e1.getSalary(), e2.getSalary()); //ascending order

 				return Double.compare(e2.getSalary(), e1.getSalary()); //descending order
			}
		});
		
		// to display the sorted list
		for(employee e :emp) {
			System.out.println(e);
		}
  
	}

}
