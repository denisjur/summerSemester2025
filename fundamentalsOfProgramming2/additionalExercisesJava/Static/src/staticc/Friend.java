package staticc;

public class Friend {

		// static = Makes a variable or method belong to the class
		//  rather than to any specific object.
		//  Commonly used for utility methods or shared resources.

	
	
	// 🔢 static → wird nur einmal existieren, für alle Friends gemeinsam
	static int numOfFriends = 0; // Falls ❌ KEIN static → jedes Objekt hat EIGENE Kopie, also wird nur das EIGENE numOfFriends erhöht
								// Wir haben aber ✅ static → EIN gemeinsamer Zähler. Jeder teilt sich den ZÄHLER!!! Somit funktioniert es auch
	
	// 🧍 nicht-static → individuell pro Objekt
	String name;

	// 🛠 Konstruktor: wird bei jeder Erstellung eines Objekts aufgerufen
	Friend(String name) {
		this.name = name;

		// Bei jedem neuen Friend wird der gemeinsame Zähler erhöht
		numOfFriends++;
	}

	// 📢 Eine Methode, die allen Friends gemeinsam ist
	static void showNumOfFriends() {
		System.out.println("Es gibt aktuell " + numOfFriends + " Freunde.");
	}

	// 🔊 Individuelle Methode (nicht static)
	void sayHello() {
		System.out.println("Hi! Ich bin " + name);
	}

}
