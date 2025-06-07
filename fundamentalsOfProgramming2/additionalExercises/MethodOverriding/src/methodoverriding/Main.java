package methodoverriding;

public class Main {
	public static void main(String[] args){	
	// Method Overriding = Wenn eine Unterklasse (subclass) ihre eigene
	// 					   Implementierung einer Methode bereitstellt, die bereits in der Oberklasse definiert wurde.
	//					   Ermöglicht Wiederverwendbarkeit des Codes und spezifische Anpassungen.

	
	Dog dog = new Dog();
	Cat cat = new Cat();
	Fish fish = new Fish();
	
	dog.move();
	cat.move();
	fish.move();
	
	// Output before overriding: ----------------------------------------------------------------------
	//	This animal is running
	//	This animal is running
	//	This animal is running
	// ------------------------------------------------------------------------------------------------
	
	// Vs.
	
	// Output after overriding fish: ----------------------------------------------------------------------
	//	This animal is running
	//	This animal is running
	//	This animal is swimming
	// ------------------------------------------------------------------------------------------------
		
	
	
	
	}
}