package methods;

public class Methods {

	public static void main(String[] args) { // <- This is our main method! IMPORTANT. Numele e mereu mic scris
		// Method = A block of code that is executed whenever it is called upon
			
		// --------------------------------
		String name = "Bro";
		int age = 21;

		hello(name, age);
		// -------------------------------
		
		
		
		// --------------------------------
		int x = 3;
		int y = 4;

		int z = add(x, y);
		System.out.println(z);
		// --------------------------------
		
	}
	
	
	
	static void hello(String name, int age) { //IMPORTANT, we can always call this method
	    System.out.println("Hello " + name);
	    System.out.println("You are " + age);
		
	}
	
	
	//IMPORTANT Schauen wir uns nun eine Methode an, die Werte zurückgibt:
	// -----------------------------------
	static int add(int x, int y) {
	    int z = x + y;
	    return z;
	}
	// ---------------------------------------
}
