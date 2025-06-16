package animal;

public class Dog extends Animal {  // <-- Ca sa poata o KindKlasse sa vererben alle Eigenschaften de la un
	                              // ElternKlasse, trebuie sa scriem EXTENDS ...
		
	int lives = 1;

	void speak() {
	    System.out.println("The dog goes *woof*");
	}

}
