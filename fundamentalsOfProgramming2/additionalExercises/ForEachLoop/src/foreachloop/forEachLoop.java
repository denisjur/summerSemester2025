package foreachloop;

import java.util.ArrayList;

public class forEachLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// for-each = traversing technique to iterate through the elements in an array/collection
		//      less steps, more readable
		//      less flexible

		//String[] animals = {"Snake", "Bat", "Lion", "Tiger"};
		ArrayList<String> animals = new ArrayList<String>();
		animals.add("cat");
		animals.add("bird");
		animals.add("dog");
		animals.add("Bat");
		
		for(String i : animals) {
			System.out.println(i);
		}
		
	}

}
