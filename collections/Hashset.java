
//scenario 1:  to store unique usernames
package coding_challenges.collections;

import java.util.HashSet;

public class Hashset {

	public static void main(String[] args) {
		HashSet<String> username = new HashSet<String>();
		username.add("Soumya");
		username.add("vyshnavi");
//		username.add("vyshnavi");  //trying to add duplicate username but it doesn't
		username.add("Kodumuri");
		System.out.println(username);
		if(username.contains("chandu")) {
			System.out.println("username already exists in the set");
		}
		else {
			username.add("chandu");
		}
		System.out.println(username);
 
	}

}
