package arraylist;

import java.util.ArrayList; //IMPORTANT
import java.util.Collections;

public class Main {

	public static void main(String[] args) {

		// ArrayList = a resizable array. (E ceva dynamic, pentru ca un array normal nu se misca)
		// Elements can be added and removed after compilation phase
		// store reference data types

		ArrayList<String> food = new ArrayList<String>(); // In diamond operator <> scriem
														  // ce type de object o sa salvam 
														  // inside of the ArrayList, aici String
														  // La int scriai: Arraylist<Integer> = ...
		// How to insert elements
		food.add("pizza");
		food.add("hamburger");
		food.add("hotdog");

		// IMPORTANT Methods
		food.set(0, "sushi"); // replace element
		food.remove(2); // Entfernen eines Elements
		food.clear(); // Löscht alle Elemente!
		Collections.sort(food); //e o methoda care sorteaza alfabetic sau numeric la cifre

		// display items of the ArraysList
		for (int i = 0; i < food.size(); i++) { // IMPORTANT normal ar 
												// fii .lenght, dar la ArrayList e .size()!!!!!
			System.out.println(food.get(i)); ///get()-Method imi da elementul la pozitia i
		}
		

		// 2D-ArrayList
		// 2D ArrayList = a dynamic list of lists
		// You can change the size of these lists during runtime

		// We can now add all of those 3 different Lists to one big List!

		ArrayList<ArrayList<String>> groceryList = new ArrayList();

		// First List
		ArrayList<String> bakeryList = new ArrayList();
		bakeryList.add("pasta"); // Add something to the list
		bakeryList.add("garlic bread");
		bakeryList.add("donuts");

		System.out.println(bakeryList.get(0)); // Retreive something from the lsit

		// Second List
		ArrayList<String> produceList = new ArrayList();
		produceList.add("tomatoes");
		produceList.add("zucchini");
		produceList.add("peppers");

		// Third List
		ArrayList<String> drinksList = new ArrayList();
		drinksList.add("soda");
		drinksList.add("coffee");

		// Alles Lists zusammenfügen
		groceryList.add(bakeryList);
		groceryList.add(produceList);
		groceryList.add(drinksList);

		// Display all our Lists:
		System.out.println(groceryList);
		//Output: [[pasta, garlic bread, donuts], [tomatoes, zucchini, peppers], [soda, coffee]]

		// If you only want to display one list, you use get:
		System.out.println(groceryList.get(0));
		//Otuput: [pasta, garlic bread, donuts]
		
		
		// If you want something more specific, so an element, you simply use get
		// multiple times:
		System.out.println(groceryList.get(0).get(0));
		//Output: pasta
		
	}

}
