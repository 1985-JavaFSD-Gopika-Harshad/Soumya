package coding_challenges.collections;

public class Pair<T, U> {
	private T obj1;
	private U obj2;
	
	public Pair(T obj1, U obj2) {
		this.obj1=obj1;
		this.obj2= obj2;
	}
	

	public T getObj1() {
		return obj1;
	}

	public void setObj1(T obj1) {
		this.obj1 = obj1;
	}

	public U getObj2() {
		return obj2;
	}

	public void setObj2(U obj2) {
		this.obj2 = obj2;
	}

	@Override
	public String toString() {
		return "Pair: [" + obj1 + ", " + obj2 + "]";
	}


	public static void main(String[] args) {
		
		//creating pair of String and Integer types
		Pair<String, Integer> p1= new  Pair<String, Integer>("Soumya", 01);
		System.out.println(p1);
		
		//creating pair od Integer and float types
		Pair<Integer, Float> p2 = new Pair<Integer, Float>(01, 22000.0f);
         System.out.println(p2);
	}

}
