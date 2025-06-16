package animal;

public class Cat extends Animal { // <-- Ca sa poata o KindKlasse sa vererben alle Eigenschaften de la un
								  // ElternKlasse, trebuie sa scriem EXTENDS ...
		
	int lives = 9;

	void speak() {
	    System.out.println("The cat goes *meow*");
	}
	
}
