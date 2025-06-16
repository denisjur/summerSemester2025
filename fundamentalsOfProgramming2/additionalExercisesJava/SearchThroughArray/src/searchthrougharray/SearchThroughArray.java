package searchthrougharray;

public class SearchThroughArray {
	public static void main(String[] args) {

//		// Se definește un array de numere întregi
//		int[] numbers = { 1, 9, 2, 8, 3, 5, 4 };
//
//		// Se definește valoarea pe care dorim să o căutăm în array
//		int target = 2;
//
//		// Se parcurge array-ul folosind un for-loop
//		for (int i = 0; i < numbers.length; i++) {
//
//			// Dacă elementul curent este egal cu targetul
//			if (target == numbers[i]) {
//
//				// Se afișează indexul unde a fost găsit elementul
//				System.out.println("Element found at index: " + i);
//
//				// Se oprește căutarea (iesire din for-loop)
//				break;
//			}
//		}
//	}

		String[] fruits = { "apple", "orange", "banana" }; // Ein Array von Strings mit Fruchtnamen
		String target = "pineapple"; // Die Frucht, nach der gesucht werden soll

		boolean isFound = false; // Eine Flag-Variable, die speichert, ob das Ziel gefunden wurde

		// Schleife über alle Elemente im Array 'fruits'
		for (int i = 0; i < fruits.length; i++) {
			// Vergleicht, ob das aktuelle Element dem Ziel entspricht
			if (fruits[i].equals(target)) {
				System.out.println("Element found at index: " + i); // Wenn ja, gib den Index aus
				isFound = true; // Setze die Flag auf 'true'
				break; // Beende die Schleife sofort
			}
		}

		// Wenn nach der Schleife nichts gefunden wurde, gib eine Nachricht aus
		if (!isFound) {
			System.out.println("Element not found in the array");
		}

	}
}