package streams;

import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {

    	// ===========================================
    	// 🧠 Einführung: Was sind Streams in Java?
    	// ===========================================
    	//
    	// Ein Stream in Java ist ein modernes Werkzeug, um Datenmengen (z. B. Listen) auf deklarative Art zu verarbeiten.
    	// Es funktioniert nach dem Prinzip: DATEN ➝ VERARBEITUNG ➝ ERGEBNIS
    	//
    	// Streams ermöglichen folgende Dinge:
    	//  - filtern (filter(...))
    	//  - sortieren (sorted(...))
    	//  - transformieren (map(...))
    	//  - zählen (count())
    	//  - zusammenfassen (collect(...))
    	//
    	// 📌 Wichtige Methoden, die du für die Informatik-Klausur in Bayern kennen solltest:
    	//
    	//   ✅ stream()               → erzeugt den Stream aus z. B. einer Liste
    	//   ✅ filter(...)            → filtert nach einer Bedingung
    	//   ✅ sorted(...)            → sortiert die Daten (z. B. alphabetisch)
    	//   ✅ map(...)               → verändert/übersetzt die Elemente (z. B. von Person → Name)
    	//   ✅ collect(Collectors.toList()) → verwandelt den Stream zurück in eine Liste
    	//   ✅ forEach(...)           → führt für jedes Element eine Aktion aus (z. B. ausgeben)
    	//   ✅ count()                → zählt die Elemente
    	//
    	// Diese Methoden sind wichtig für strukturierte Datenverarbeitung mit Java 8+
    	// ===========================================
    	
    	
    	
        // ===========================================
        // 🔹 Erstellen einer Liste von Personen
        // ===========================================
        List<Person> people = new ArrayList<>();

        // Personen hinzufügen
        people.add(new Person("Warren Buffett", 120));
        people.add(new Person("Jeff Bezos", 150));
        people.add(new Person("Bill Gates", 100));
        people.add(new Person("Mark Zuckerberg", 50));


        // ==================================================
        // 🔹 Club der Personen mit >= 100 Milliarden (gefiltert)
        // ==================================================

        // List<Person> hundredClub = new ArrayList<>(); // ❌ Diese Zeile ist überflüssig, da Stream unten genutzt wird

        // In loc de a scrie noi, putem folosi Streams. Ele filtreaza si fac pentru noi asta
        // for (Person p : people) { // Schleife über alle Personen
        //     if (p.billions >= 100) { // Prüft: Hat Person mindestens 100 Milliarden?
        //         hundredClub.add(p);  // Dann wird sie in den Club aufgenommen
        //     }
        // }

        // Aici folosim STREAMS, ele sorteaza pentru noi totul mai usor!
        List<Person> hundredClub = people.stream() // ✅ Stream zum Filtern der passenden Personen
            .filter(person -> person.billions >= 100) // nur wer >= 100 Milliarden hat
            .collect(Collectors.toList()); // Ergebnis zurück in Liste speichern

        hundredClub.forEach(person -> System.out.println(person.name)); // Ausgabe der Namen
        // Output :
        // Warren Buffett
        // Jeff Bezos
        // Bill Gates



        // ===========================================
        // 🔹 Acum vrem sa sortam alfabetic dupa nume
        // ===========================================

        List<Person> sortedList = people.stream()
            .sorted(Comparator.comparing(person -> person.name)) // alphabetisch sortieren nach .name
            .collect(Collectors.toList());

        sortedList.forEach(person -> System.out.println(person.name)); // Ausgabe der Namen
        // Output :
        // Bill Gates
        // Jeff Bezos
        // Mark Zuckerberg
        // Warren Buffett



        // =======================================================
        // 🔹 Iar daca acum vrem sa combinam totul de sus (filter + sort)
        // =======================================================

        List<Person> hundredSortedClub = people.stream() // starte mit allen Personen
            .filter(person -> person.billions >= 100) // zuerst: nur die mit ≥ 100 Milliarden
            .sorted(Comparator.comparing(person -> person.name)) // dann: alphabetisch sortieren
            .collect(Collectors.toList()); // Ergebnis als Liste

        hundredSortedClub.forEach(person -> System.out.println(person.name)); // Ausgabe der Namen
        // Output :
        // Bill Gates
        // Jeff Bezos
        // Warren Buffett
    }

    // ============================================================
    // 🔹 Eigene Datenklasse: Person mit name und billions (Vermögen)
    // ============================================================
    static class Person {
        String name;
        int billions;

        public Person(String name, int billions) {
            this.name = name;
            this.billions = billions;
        }
    }
}
