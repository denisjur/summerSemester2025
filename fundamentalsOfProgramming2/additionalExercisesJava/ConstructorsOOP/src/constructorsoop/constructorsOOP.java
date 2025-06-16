package constructorsoop;

public class constructorsOOP {

	public static void main(String[] args) {
		// constructor = special method that is called when an object is instantiated (created)

		// Now let us create one human and display the name
		Human human = new Human("Satoshi Nakamoto", 65, 60.55); // <- new Human() is calling the constructor in the Human-file
																// Why is passing arguments to the constructor helpful
		System.out.println(human.name);
		
		//Let us now create a second human and display the name
		Human human2 = new Human("Morty", 22, 54);
		System.out.println(human2.name);
		human2.eat();
		human.drinks();
	
	
	}

}
