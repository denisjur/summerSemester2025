package arrayofobjects;

public class ArrayOfObjects {
	public static void main(String[] args) {

		// Erstelle ein Auto mit Modell "Mustang" und Farbe "Red"
		Car car1 = new Car("Mustang", "Red");

		// Erstelle ein Auto mit Modell "Corvette" und Farbe "Blue"
		Car car2 = new Car("Corvette", "Blue");

		// Erstelle ein Auto mit Modell "Charger" und Farbe "Yellow"
		Car car3 = new Car("Charger", "Yellow");

		// Speichere alle Autos in einem Array
		Car[] cars = { car1, car2, car3 }; // -> Objekte wurden in einem Array hinzugefügt

			//	// Schleife über das Array, jedes Auto soll „fahren“ (Ausgabe erzeugen)
			//		for (int i = 0; i < cars.length; i++) {
			//		cars[i].drive(); // Gibt z. B. "You drive the Red Mustang" aus
			//		}
				//Statt dem kann mach auch das schreiben:
		
		for (Car car : cars) {
		    car.drive(); // Ruft die drive()-Methode für jedes Auto im Array auf
		}


		// Ausgabe:
		// You drive the Red Mustang
		// You drive the Blue Corvette
		// You drive the Yellow Charger
	}

}
