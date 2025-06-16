package tostring;

public class Car {
	// Attribute der Klasse
	String make;
	String model;
	int year;
	String color;

	// Konstruktor – initialisiert alle Eigenschaften
	Car(String make, String model, int year, String color){
	    this.make = make;
	    this.model = model;
	    this.year = year;
	    this.color = color;
	}

	// Überschreibt die toString()-Methode aus der Object-Klasse
	// Gibt eine sinnvolle Textdarstellung des Autos zurück
	@Override
	public String toString(){
	    return this.color + " " + this.year + " " + this.make + " " + this.model;
	}

}
