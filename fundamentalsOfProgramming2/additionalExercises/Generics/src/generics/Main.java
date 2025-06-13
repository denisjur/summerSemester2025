package generics;

public class Main {

	public static void main(String[] args) {
		// Generics = A concept where you can write a class, interface, or method
		//      that is compatible with different data types.
		//<T>       = type parameter (placeholder that gets replaced with a real type)
		//<String>  = type argument (specifies the type)

		Box<String> box = new Box<>();          // Box für Strings erstellen mit passendem Datatype

		box.setItem("banana");                  // "banana" in die Box legen

		System.out.println(box.getItem());      // "Banana" aus der Box raus nehmen
		// Output: banana
		
		
		// Acum noi putem sa avem si mai multe DataTypes, deci facem un Bsp. cu class product:
		
		
		Product<String, Double> product = new Product<>("appe", 0.50);
		System.out.println(product.getItem());
		//Output: apple
		
		Product<String, Integer> product2 = new Product<>("ticket", 50); // Jetzt mit Integer
		System.out.println(product2.getPrice());
		//Output: 50
		
	}

}
