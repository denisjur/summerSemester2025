package abstraction;

public class Main {

	public static void main(String[] args) {
		// abstract = 	Used to define abstract classes and methods.
		// 				Abstraction is the process of hiding implementation details
		// 				and showing only the essential features.
		//				De ce e important? Daca vrei sa conduci o masina, nu trebe sa sti cum arata sub capota!
		// 
		// 				Abstract classes CAN'T be instantiated directly.
		// 				Can contain 'abstract' methods (Method which must be implemented by its children)
		// 				Can contain 'concrete' methods (which are inherited)
		
		// Wenn etwas mit abstrac versehen ist: Kann nicht direkt instanziiert werden! (new Animal() ❌)
		// Muss von einer Unterklasse erweitert werden, um vollständig zu funktionieren! Man kann es nicht einfach so übernehmen.
		
		Circle circle = new Circle(3);
		Rectangle rectangle = new Rectangle(4, 5);
		Triangle triangle = new Triangle(3, 6);
		
		rectangle.display(); // Output: This is a shape
		circle.display(); // Output: This is a shape
		triangle.display(); // Output: This is a shape
		
		System.out.println(circle.area());
		System.out.println(rectangle.area());
		System.out.println(triangle.area());
		// Output: 28.274333882308138
		// 20.0
		// 9.0
	}

}
