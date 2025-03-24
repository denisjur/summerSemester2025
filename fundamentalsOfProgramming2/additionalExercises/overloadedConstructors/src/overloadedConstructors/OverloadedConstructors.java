package overloadedConstructors;

public class OverloadedConstructors {

	public static void main(String[] args) {
		// overloaded constructors = 	multiple constructors within a class with the same name,
		// 								but have different parameters
		// 								name + parameters = signature

		
		//example: Let us create some pizza
		
		Pizza pizza = new Pizza("thicc crust", "tomato", "mozarella", "pepperoni"); // Was wenn ich nun einen arg entfernen möchte, 
																					// dafür brauchen wir overloaded instructors
		System.out.println("Here are the ingredients of your pizza: ");
		System.out.println(pizza.bread);	
		System.out.println(pizza.sauce);
		System.out.println(pizza.cheese);
		System.out.println(pizza.topping);

	}

}
