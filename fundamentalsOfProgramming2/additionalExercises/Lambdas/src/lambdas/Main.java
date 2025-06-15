package lambdas;

public class Main {

    public static void main(String[] args) {
    	
    	// ============================================================================
    	// 🧠 Einführung: Was ist ein Lambda-Ausdruck in Java?
    	// ============================================================================
    	//
    	// Ein Lambda-Ausdruck ist eine anonyme Methode – also eine Funktion ohne Namen –
    	// die in Java seit Version 8 verwendet werden kann.
    	//
    	// ✅ Wofür verwendet man Lambda-Ausdrücke?
    	// - Um anonyme Klassen kürzer zu schreiben
    	// - Um Funktionen als Parameter zu übergeben
    	// - Um funktionale Interfaces zu implementieren
    	//
    	// ✅ Voraussetzung für Lambda:
    	// - Ein funktionales Interface (enthält genau **eine** abstrakte Methode)
    	//
    	// ✅ Syntax:
    	// (Parameter) -> { Anweisungen }
    	//
    	// ✅ Beispiele für funktionale Interfaces (die man kennen sollte):
    	// - java.lang.Runnable
    	// - java.awt.event.ActionListener
    	// - java.util.function.Consumer<T>, Predicate<T>, Function<T,R>
    	// - Eigene Interfaces mit nur einer Methode (z. B. „MyInterface” unten)
    	//
    	// ============================================================================

    	
        // ****************************************************************************************
        /*
         * Lambda-Ausdruck = Funktion ab Java 8 und höher
         *                   auch bekannt als anonyme Methode
         *                   eine kürzere Art, anonyme Klassen mit nur einer Methode zu schreiben
         *
         * Erfordert die Verwendung eines funktionalen Interfaces 
         * (entweder vordefiniert oder selbst erstellt)
         * Funktionale Interfaces enthalten genau eine abstrakte Methode
         * Beispiele: ActionListener, Runnable, (benutzerdefiniert)
         *
         * Ein Lambda-Ausdruck kann überall dort verwendet werden,
         * wo eine funktionale Schnittstelle benötigt wird
         *
         * Syntax eines Lambda-Ausdrucks:
         * (Argumente) -> { Anweisung(en) }
         */
        // ****************************************************************************************


        // ================================================================
        // 🔹 1) Lambda Example for User-defined Interfaces
        // ================================================================

        // Variante mit nur einer Zeile
        // MyInterface myInterface = () -> System.out.println("Hello world"); 
        // myInterface.message();

        // Fara Lambda, ai scrie, clasa anonyma mult mai lung, asa ca cu Lambda e mult mai scurt:
        /*
        MyInterface myInterface = new MyInterface() {
            @Override
            public void message(String x, char y) {
                System.out.println("Hello world");
            }
        };
        myInterface.message("Bro", '!');
        */

        String name = "Bro";
        char symbol = '!';

        // Erste Lambda-Implementierung von MyInterface
        MyInterface myInterface = (x, y) -> {
            System.out.println("Heello World!");
            System.out.println("It is a nice day " + x + y);
        };
        myInterface.message(name, symbol);

        // Zweite Lambda-Implementierung mit anderem Verhalten
        MyInterface myInterface2 = (x, y) -> {
            System.out.println("Hello " + x + y);
        };
        myInterface2.message(name, symbol);

        /*
        - Poți declara mai multe interfețe diferite în codul tău. Amândouă fac chestii diferite.
        - Poți avea mai multe implementări ale aceleiași interfețe, cu comportamente diferite.
        - O clasă poate implementa mai multe interfețe (Java suportă „multiple inheritance” prin interfețe).
        */

        // ================================================================
        // 🔹 2) Lambda Example for Pre-defined Interfaces: ActionListener
        // ================================================================
        MyFrame myFrame = new MyFrame(); // Erstellt ein neues Fenster mit einem Button + Lambda-ActionListener
    }
}
