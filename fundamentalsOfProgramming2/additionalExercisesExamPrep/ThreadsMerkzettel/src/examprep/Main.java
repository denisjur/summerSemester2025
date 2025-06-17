package examprep;

//MegaCode-Sammlung: Java Streams & Lambdas – Klausur-ready
//Enthält 3 typische Prüfungsprogramme mit Erklärung, Struktur und Kommentaren:
//1. Personen filtern & transformieren (Stream + map/filter)
//2. Zahlenstatistik (Stream + SummaryStatistics)
//3. Gruppieren mit Map (collect(Collectors.groupingBy))

import java.util.*;
import java.util.stream.*;

//=======================================
//1. Personen filtern und transformieren
//=======================================
/*
Aufgabenstellung:
- Gegeben: Liste von Student-Objekten
- Filtere alle über 18
- Wandle sie in Personen (Name + Alter) um
- Sortiere alphabetisch, gib aus
*/

class Student {
 String name;
 int alter;
 int matrikel;

 public Student(String name, int alter, int matrikel) {
     this.name = name;
     this.alter = alter;
     this.matrikel = matrikel;
 }
}

class Person {
 String name;
 int alter;

 public Person(String name, int alter) {
     this.name = name;
     this.alter = alter;
 }

 public String toString() {
     return name + " (" + alter + ")";
 }
}

class StreamStudentDemo {
 public static void main(String[] args) {
     List<Student> studenten = List.of(
         new Student("Anna", 17, 1001),
         new Student("Bernd", 22, 1002),
         new Student("Clara", 19, 1003)
     );

     studenten.stream()
         .filter(s -> s.alter >= 18) // nur volljährige
         .map(s -> new Person(s.name, s.alter)) // umwandeln in Person
         .sorted(Comparator.comparing(p -> p.name)) // alphabetisch sortieren
         .forEach(System.out::println); // ausgeben
 }
}

//=======================================
//2. Zahlenstatistik mit Stream
//=======================================
/*
Aufgabenstellung:
- Gegeben: Array von Zahlen
- Berechne: Summe, Durchschnitt, Minimum, Maximum
- Nutze IntStream und SummaryStatistics
*/

class StreamZahlenStatistik {
 public static void main(String[] args) {
     int[] zahlen = {5, 8, 2, 9, 1, 7};

     IntSummaryStatistics stats = Arrays.stream(zahlen)
         .summaryStatistics();

     System.out.println("Summe: " + stats.getSum());
     System.out.println("Durchschnitt: " + stats.getAverage());
     System.out.println("Minimum: " + stats.getMin());
     System.out.println("Maximum: " + stats.getMax());
     System.out.println("Anzahl: " + stats.getCount());
 }
}

//=======================================
//3. Gruppieren von Objekten nach Attribut
//=======================================
/*
Aufgabenstellung:
- Gegeben: Liste von Personen mit Alter
- Gruppiere sie nach Alterskategorie:
→ "Kind" (<18), "Erwachsen" (18–65), "Senior" (>65)
- Gib Gruppen mit ihren Mitgliedern aus
*/

class Mensch {
 String name;
 int alter;

 public Mensch(String name, int alter) {
     this.name = name;
     this.alter = alter;
 }

 public String toString() {
     return name + " (" + alter + ")";
 }
}

class StreamGruppierungDemo {
 public static void main(String[] args) {
     List<Mensch> menschen = List.of(
         new Mensch("Tim", 12),
         new Mensch("Sara", 34),
         new Mensch("Oma", 80),
         new Mensch("Luca", 17),
         new Mensch("Mark", 67)
     );

     Map<String, List<Mensch>> gruppiert = menschen.stream()
         .collect(Collectors.groupingBy(m -> {
             if (m.alter < 18) return "Kind";
             else if (m.alter <= 65) return "Erwachsen";
             else return "Senior";
         }));

     gruppiert.forEach((gruppe, liste) -> {
         System.out.println(gruppe + ":");
         liste.forEach(System.out::println);
     });
 }
}