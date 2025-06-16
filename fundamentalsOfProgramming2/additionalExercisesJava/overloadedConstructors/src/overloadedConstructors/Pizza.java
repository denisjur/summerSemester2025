package overloadedConstructors;

public class Pizza {

	String bread;
	String sauce;
	String cheese;
	String topping;
	
	
	// Overloaded constructors in Java are multiple constructors in the same class 
	// that have the same name (which is the class name) but different parameters.
	
	Pizza(String bread) {		// -> Overloaded constructor
		this.bread = bread;
	}	
	
	Pizza(String bread, String sauce) {		// -> Overloaded constructor
		this.bread = bread;
		this.sauce = sauce;
	}	
	
	Pizza(String bread, String sauce, String cheese) {		// -> Overloaded constructor
		this.bread = bread;
		this.sauce = sauce;
		this.cheese = cheese;
	}	
	
	Pizza(String bread, String sauce, String cheese, String topping) {		// -> Overloaded constructor
		this.bread = bread;
		this.sauce = sauce;
		this.cheese = cheese;
		this.topping = topping;
	}	
}
