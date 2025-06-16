package abstraction;

public abstract class Shape { // -> We now cannot create any shape object, it is an abstract class
	abstract double area(); // ABSTRACT METHOD, jedes Kind soll eine Fläche haben!

	void display() { 	// CONCRETE METHOD is a method that is Inherited.
						// We do not need to override it like the abstract method.
						// The abstract method NEEDS to be ovverridden.
		System.out.println("This is a shape");
	}
}
