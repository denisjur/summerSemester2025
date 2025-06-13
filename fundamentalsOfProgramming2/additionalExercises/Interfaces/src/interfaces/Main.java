package interfaces;

public class Main {

	public static void main(String[] args) {
		// Interface = A blueprint for a class that specifies a set of abstract methods
		//             that implementing classes MUST define.
		//             Supports multiple inheritance-like behavior.
		
		// La interfaces faci IMPLEMENTS, la Vererbung faci EXTENDS!
		
		// **************************************************************************************
		// Deci, scurt explicat: În mod normal, o clasă poate moșteni (extinde) doar de la o 
		// singură clasă părinte.
		// Dar dacă folosim interfețe, atunci o clasă copil poate implementa mai multe interfețe,
		// adică poate "moșteni comportamente" de la mai mulți "părinți".
		// **************************************************************************************
		
		
		Rabbit rabbit = new Rabbit();
		rabbit.flee();
		// Output: The rabbit is running away
		
		Fish fish = new Fish();
		fish.hunt();
		fish.flee();
		// Output: 
		// The fish is attacking!
		// The fish is swimming away!

	}

}
