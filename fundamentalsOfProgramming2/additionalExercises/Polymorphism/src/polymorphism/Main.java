package polymorphism;

public class Main {

	public static void main(String[] args) {
		// Polymorphism = "POLY" = "MANY"
		//     	 		  "MORPH" = "SHAPE"
		//      		  Objects can identify as other objects.
		//      		  Objects can be treated as objects of a common superclass.
		// A dog can identify as a dog, an animal, an organism, an object etc.
		
		Car car = new Car();
		Bike bike = new Bike();
		Boat boat = new Boat();
		car.go();
		bike.go();
		boat.go();
		// Output:
		// You drive a car!
		// You ride a bike!
		// You sail a boat!
		
		// In loc de asta putem face si asa: 
		
		
		//Now let us say we want a race: We are gonna place
		// all of these objects in an array:
		
		// Car[] cars = {car, bike, boat}; -> Nu merge ca bike si boat nu identify as cars.
		// 								   -> Lafel ar fii si daca aveai arrai de bike sau boat.
		// Ca sa rezolvam, ne trebe ceva cu care toti se identifica, sa nu primim ERROR => Vehicle.
		Vehicle[] vehicles = {car, bike, boat};
		
		for(Vehicle vehicleName : vehicles) {
			vehicleName.go(); // Chemam pentru fiecare vehicle goMethod
		}
		// Output:
		// You drive a car!
		// You ride a bike!
		// You sail a boat!
		//***************************************************************
		// LA FEL, IN LOC DE ARRAYS, POTI SA FACI SI PRIN INTERFACES
		//***************************************************************
	
	}

}
