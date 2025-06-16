package composition;

public class Main {

	public static void main(String[] args) {
		// Komposition = Repräsentiert eine "ist-Teil-von/ part of"-Beziehung zwischen Objekten.
		// 🔸 Beispiel: Ein Motor ist ein **Teil** eines Autos.
		// Wenn das Auto zerstört wird, wird der Motor normalerweise auch zerstört.
		// Der Motor kann nicht unabhängig vom Auto existieren (aus Sicht des Objektdesigns).
		// ✅ Komposition erlaubt es, komplexe Objekte aus kleineren Objekten zusammenzusetzen.

		Car car = new Car("Corvette", 2025, "V8");
		System.out.println(car.model);
		System.out.println(car.year);
		System.out.println(car.engine); // <-- Pentru asta primim o reference HashID
		//Output:
		//	Corvette
		//	2025
		//	composition.Engine@79fc0f2f
		
		// Correct ar fii:
		System.out.println(car.model);
		System.out.println(car.year);
		System.out.println(car.engine.type);  // <-- Our type engine object is part of the car object
												// No car, no engine
		
		//Output:
		//	Corvette
		//	2025
		//	V8
		
		car.start();
		//Output:
		//	You start the V8 engine
		//  The Corvette is running

		
	}

}
