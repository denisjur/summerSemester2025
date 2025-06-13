package hashmap;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
        // GENERICS → ermöglichen das Schreiben von Klassen oder Methoden,
        //            die mit beliebigen (flexiblen) Datentypen arbeiten können.
        //            z. B. <T> für Artikelname, <U> für Preis
        //            → macht Code wiederverwendbar & typsicher
        //            → Beispiel: Product<String, Double>

        // HASHMAP → speichert Schlüssel-Wert-Paare (Key = eindeutige ID, Value = z. B. Product-Objekt)
        //           → Aufbau: HashMap<Key, Value>
        //           → Beispiel: HashMap<String, Product<String, Double>>
        //           → speichert Daten effizient & ermöglicht schnellen Zugriff per Schlüssel

        // UNTERSCHIED:
        // - Generics = sorgen für Typflexibilität innerhalb von Klassen/Methoden
        // - HashMap  = dient der Zuordnung & Verwaltung von Daten über eindeutige Schlüssel
        //              (z. B. map.get("A1"))
			
		
		HashMap<String, Double> map = new HashMap<>();

		// Elemente einfügen
		map.put("apple", 0.50);
		map.put("orange", 0.75);
		map.put("banana", 0.25);

		// Optional: Element entfernen
		// map.remove("apple");

		// Werte abfragen
		System.out.println(map.get("coconut")); // Output: null (nicht vorhanden)
		System.out.println(map.containsKey("pineapple")); // Output: false
		System.out.println(map.containsValue(1.00)); // Output: false
		System.out.println(map.size()); // Output: 3

		// Alle Einträge ausgeben:
		for (String key : map.keySet()) {
			System.out.println(key + " : $" + map.get(key));
		}
		//Output:
		// apple : $0.5
		// orange : $0.75
		// banana : $0.25
	}

}
