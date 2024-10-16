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
		List<employee> emp= new ArrayList<>();
		emp.add(new employee("soumya", 25000));
		emp.add(new employee("vyshnavi", 29000));
		emp.add(new employee("ananya", 35000));

		Collections.sort(emp, new Comparator<employee>() {

			@Override
			public int compare(employee e1, employee e2) {
 				return Double.compare(e2.getSalary(), e1.getSalary());
			}
		});
		
		for(employee e :emp) {
			System.out.println(e);
		}
  
	}

}
