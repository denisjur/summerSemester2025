package annonymusclasses;

public class Main {

	public static void main(String[] args) {
		
		// ************************************************************************************
		// 🔹 Anonymous class = Eine Klasse ohne Namen. Kann nicht wiederverwendet werden.
		// ➤ Ermöglicht individuelles Verhalten, ohne eine neue separate Klasse zu erstellen.
		// ➤ Wird oft für einmalige Anwendungen genutzt: TimerTask, Runnable, Callbacks etc.
		// ************************************************************************************
		
		// 🔸 În loc să creăm o clasă complet nouă pentru un câine vorbitor,
		//	  putem folosi o clasă anonimă (Anonymous Class).
		// 🔸 Statt eine neue eigene Klasse zu schreiben (z. B. TalkingDog),
		//	  erstellen wir direkt ein Dog-Objekt mit überschriebenem Verhalten.

		// 🔹 Anonymous Classes beginnen mit {} nach dem new-Konstruktor:
		//	  -> Innerhalb dieser geschweiften Klammern können wir Methoden überschreiben
		//	  oder individuelles Verhalten hinzufügen, ohne eine benannte Klasse zu definieren.

		
		 // 🔹 Normale Instanz von Dog
        Dog dog1 = new Dog();

        // 🔹 Anonyme Klasse, die `speak()` überschreibt
        Dog dog2 = new Dog() {
            @Override
            void speak() {
                System.out.println("Scooby Doo says *Ruh Roh*");
            }
        };

        // 🧪 Methoden aufrufen
        dog1.speak(); // Ausgabe: The dog goes *woof*
        dog2.speak(); // Ausgabe: Scooby Doo says *Ruh Roh*
    
	}

}
