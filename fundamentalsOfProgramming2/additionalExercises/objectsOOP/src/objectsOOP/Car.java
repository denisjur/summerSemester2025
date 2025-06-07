package objectsOOP;

public class Car {  // <- Hier das Bauplan einer Autos.
		    // Es sagt alles was das Prototyp Auto haben soll.
		    // Es ist aber noch kein echtes Auto (Objekt)
		
		//Attributes of the car, so what characteristics?
		String make = "Chevrolet";
		String model = "Corvette";
		int year = 2020;
		String color = "blue";
		double price = 3000.00;
		
		//methods of the car. So what actions?
		void drive() {
			System.out.println("You drive the car!");
			}
		
		void brake() {
		    System.out.println("You hit the brake!");
		}

	
}
