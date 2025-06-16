package aggregation;

public class Main {

	public static void main(String[] args) {
		// Aggregation = Repräsentiert eine "hat-ein"-Beziehung zwischen Objekten.
		
		// 🔹 Definition:
		// Aggregation bedeutet, dass ein Objekt ein anderes Objekt besitzt, aber:
		// - Das enthaltene Objekt kann unabhängig existieren. (Daca as sterge
		// in exemplul acesta objectul library, objectul books, ar exista mai departe.
		// - Es besteht eine lose Verbindung zwischen den Objekten.

		// 🔸 Beispiel im echten Leben:
		// Eine Bibliothek besitzt Bücher, aber:
        // Die Bücher existieren auch außerhalb der Bibliothek. Auch wenn man die Bibliothek löscht
        // Die Bibliothek "hat Bücher",
        // aber wenn die Bibliothek geschlossen wird, verschwinden die Bücher nicht automatisch.

		Book book1 = new Book("The Fellow of the Ring", 432);
		Book book2 = new Book("The Two Towers", 352);
		Book book3 = new Book("The Return of the King", 416);
		
		Book[] books = {book1, book2, book3};
		
		
		//Aici acum avem Aggregation, ca un Object detine alt object:
		Library library = new Library("NYC Public Library", 1897, books);
		
		library.displayInfo();
		//Output:
		/*
		    The 1897 NYC Public Library
			Books Available: 
			The Fellow of the Ring (432 pages)	
			The Two Towers (352 pages)
			The Return of the King (416 pages)
		 */

		
	}

}
