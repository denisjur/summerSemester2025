package GettersSetters;

public class Main {
	public static void main(String[] args) {
	// Getter und Setter helfen dabei, Daten in einer Klasse zu schützen und 
	// kontrollieren den Zugriff darauf (Encapsulation).

	// GETTER = Methode, um ein privates Feld auszulesen (READ).
	// SETTER = Methode, um ein privates Feld zu ändern (WRITE).
	
		Car car = new Car("Charger", "Yellow", 10000);
		// Aici doar citim normal wertele
		System.out.println(car.getColor() + " " + car.getModel() + " " + car.getPrice());

		// Aici le schimbam prin SetterMethode
		car.setColor("Blue");
		car.setPrice(6000);
		System.out.println(car.getColor() + " " + car.getModel() + " " + car.getPrice());

		//	Output:
		//	Yellow Charger 10000
		//	Blue Charger 6000

	
	
	
	}
}
