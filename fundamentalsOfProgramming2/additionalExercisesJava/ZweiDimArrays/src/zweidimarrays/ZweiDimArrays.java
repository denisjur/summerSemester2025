package zweidimarrays;

public class ZweiDimArrays {
	public static void main(String[] args) {

		// 2D-Array = Ein Array, bei dem jedes Element selbst ein Array ist
		// Nützlich zum Speichern von tabellarischen Daten (wie eine Matrix)

		// Eindimensionale Arrays mit Obst, Gemüse und Fleisch
			// String[] fruits = { "apple", "orange", "banana" };
			// String[] vegetables = { "potato", "onion", "carrot" };
			// String[] meats = { "chicken", "pork", "beef", "fish" };
		//Stattdessen kann man es auch so schreiben. Ist das Selbe:

		// Zweidimensionales Array, das die obigen Arrays zusammenfasst
		String[][] groceries = { { "apple", "orange", "banana" }, // Obst
								 { "potato", "onion", "carrot" }, // Gemüse
								 { "chicken", "pork", "beef",   "fish" } // Fleisch
		};

		// Äußere Schleife durchläuft jede Kategorie (Obst, Gemüse, Fleisch)
		for (String[] foods : groceries) {
			// Innere Schleife durchläuft jedes einzelne Element innerhalb der Kategorie
			for (String food : foods) {
				// Gibt das aktuelle Lebensmittel aus, gefolgt von einem Leerzeichen
				System.out.print(food + " ");
			}
			// Nach jeder Kategorie ein Zeilenumbruch für bessere Lesbarkeit
			System.out.println();
		}
	}
}
