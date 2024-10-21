package coding_challenges.collections;

//Type-safe container class - this can hold a single object of any type T
public class Container<T> {
	private T object;
	
	//getters and setters
	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}


	public static void main(String[] args) {
		
		//Integer
		Container<Integer> intContainer = new Container<>();
		intContainer.setObject(12);
		System.out.println("Integer value :" +intContainer.getObject());
		
		//String
		Container<String> stringContainer = new Container<>();
		stringContainer.setObject("Soumya");
		System.out.println("String Value: " +stringContainer.getObject());

	}

}
