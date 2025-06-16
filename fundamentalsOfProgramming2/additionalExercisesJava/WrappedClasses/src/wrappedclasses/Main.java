package wrappedclasses;

public class Main {

	public static void main(String[] args) {
		// 📦 Wrapper-Klassen:
		// Erlauben es, primitive Datentypen (int, double, char, boolean, etc.)
		// als Objekte zu verwenden, indem man sie in Klassen wie Integer, Double, usw. "verpackt".
		//
		// ➕ Beispiel:
		// int     → Integer
		// double  → Double
		// char    → Character
		// boolean → Boolean
		//
		// ➤ Notwendig bei:
		// - Verwendung in generischen Klassen wie ArrayList<T>
		// - Nutzung von Methoden (z. B. Integer.parseInt())
		// - Arbeiten mit null-Werten oder Objektreferenzen
		//
		// 🧠 Faustregel: Nur dann verwenden, wenn ein Objekt wirklich gebraucht wird.


		// 🔄 Autoboxing:
		// Automatisches Umwandeln eines primitiven Werts in ein entsprechendes Wrapper-Objekt.
		//
		// ➕ Beispiel (Autoboxing):
		// Integer zahl = 5;           // int → Integer (automatisch)
		//
		// ➖ Beispiel (Unboxing):
		// int x = zahl;               // Integer → int (automatisch)
		//
		// ➤ Java erledigt das still im Hintergrund.
		//   Spart Schreibarbeit und macht den Code lesbarer,
		//   kann aber bei vielen Konvertierungen etwas langsamer sein.

		
		
		// int a = 123;
		
		
		// AUTOBOXING: We directly assign these primitives into an object, using a wrapper class.
		//		"Integer" e clasa
		//		"a" e objectul
		//		"123" e primitivul
		
		//In loc de a declara asta ca int: folosim wrapper class Integer
		//Integer a = new Integer(123); // <-- Asta e stilul vechi, dar noi facem asa acum:
		Integer a = 123; // <-- Asa se scrie mai nou
		Double b = 3.14;       
		Character c = '€';     
		Boolean d = true;     
		
		
		// UNBOXING: Convert Wrapper classes back to thei primitives
		 int x = a;
		 
		 
		 
		 
		 // Exemplu general de Anwendung:
		 String e = Integer.toString(123);     // int → String "123"
		 String f = Double.toString(3.14);     // double → String "3.14"
		 String g = Character.toString('@');   // char → String "@"
		 String h = Boolean.toString(false);   // boolean → String "false"
		 
		 String i = e + f + g + h;
		 System.out.println(i);
		 //Output: 1233.14@false
		 
		 // Und andersherum
		 
		 
		 // *********************************************************************************
		 /* PARSING = bedeutet in der Programmierung, einen String (Text) in 
		  * einen anderen Datentyp umzuwandeln.
		  * 
		  * Man wandelt einen String, der eine Zahl enthält, in z. B. 
		  * einen int, double oder boolean um – mithilfe von statischen Methoden 
		  * der Wrapper-Klassen.
		  */
		 
		 	int zahl = Integer.parseInt("123");         // String → int
		 	double kommazahl = Double.parseDouble("3.14"); // String → double
		 	boolean wahrheitswert = Boolean.parseBoolean("true"); // String → boolean

		 // *********************************************************************************
		/* Weitere wichtige funktionen zu kennen: Wichtig z.b für passwords:	 
		  	 System.out.println(Character.isLetter(letter));
			 System.out.println(Character.isUpperCase(letter));
		 */
		 //**********************************************************************************
	}

}
