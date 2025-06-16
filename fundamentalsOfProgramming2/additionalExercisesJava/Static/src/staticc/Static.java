package staticc;

public class Static {
	    public static void main(String[] args) {

	        // 📦 Wir erstellen 3 Objekte
	        Friend f1 = new Friend("Jay");
	        Friend f2 = new Friend("Cole");
	        Friend f3 = new Friend("Kai");

	        // 💬 Jeder kann sich selbst vorstellen (nicht static)
	        f1.sayHello();  // Hi! Ich bin Jay
	        f2.sayHello();  // Hi! Ich bin Cole
	        f3.sayHello();  // Hi! Ich bin Kai

	        // ✅ Zugriff auf static-Methode (empfohlen über Klasse)
	        Friend.showNumOfFriends();  // Es gibt aktuell 3 Freunde.
	    }

}
