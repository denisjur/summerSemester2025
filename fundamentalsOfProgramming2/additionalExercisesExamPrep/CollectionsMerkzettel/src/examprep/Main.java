package examprep;

//MegaCode-Sammlung: Java Collections – klausurtauglich & kommentiert
//Enthält 3 realistische Programme mit Aufgabenstellung, Struktur und Erklärungen:
//1. Farben sortieren (HashMap + Comparator)
//2. Mitarbeiter laden & sortieren (CSV -> Map -> Sortierung)
//3. Wörter zählen (Map + Schleife)

//=======================================
//1. Farben nach RGB-Werten sortieren
//=======================================
/*
Aufgabenstellung:
- Lies ein Array mit Farbnamen und RGB-Werten (z. B. "rot", 255, 0, 0)
- Speichere sie in einer HashMap<Farbe, String>
- Gib alle Farben sortiert nach RGB (erst rot, dann grün, dann blau) aus

Struktur:
Map<Farbe, Name>
→ Comparator für Farbe (nach rot, grün, blau)
*/

import java.util.*;

class Farbe {
 int rot, gruen, blau;
 public Farbe(int r, int g, int b) {
     rot = r; gruen = g; blau = b;
 }
 public String toString() {
     return rot + "," + gruen + "," + blau;
 }
 public int hashCode() {
     return Objects.hash(rot, gruen, blau);
 }
 public boolean equals(Object o) {
     if (!(o instanceof Farbe f)) return false;
     return rot == f.rot && gruen == f.gruen && blau == f.blau;
 }
}

class FarbenSortieren {
 public static void main(String[] args) {
     // Datenquelle als String-Array
     String[] daten = {
         "rot", "255", "0", "0",
         "blau", "0", "0", "255",
         "grau", "128", "128", "128",
         "orange", "255", "165", "0"
     };

     Map<Farbe, String> farben = new HashMap<>();
     for (int i = 0; i < daten.length; i += 4) {
         String name = daten[i];
         int r = Integer.parseInt(daten[i + 1]);
         int g = Integer.parseInt(daten[i + 2]);
         int b = Integer.parseInt(daten[i + 3]);
         farben.put(new Farbe(r, g, b), name);
     }

     // Liste erstellen & sortieren
     List<Farbe> farbliste = new ArrayList<>(farben.keySet());
     farbliste.sort(Comparator.comparingInt((Farbe f) -> f.rot)
             .thenComparingInt(f -> f.gruen)
             .thenComparingInt(f -> f.blau));

     for (Farbe f : farbliste) {
         System.out.println(f + " = " + farben.get(f));
     }
 }
}

//=======================================
//2. Mitarbeiter aus CSV-Daten sortieren
//=======================================
/*
Aufgabenstellung:
- Lies Mitarbeiterdaten aus String-Array (CSV)
- Baue Map<Integer, Mitarbeiter>
- Sortiere einmal nach Nummer, einmal nach Ort

CSV-Feld: "Nr;Name;Ort;Gehalt"
*/

class Mitarbeiter {
 int nr;
 String name, ort;
 double gehalt;

 public Mitarbeiter(int nr, String name, String ort, double gehalt) {
     this.nr = nr; this.name = name; this.ort = ort; this.gehalt = gehalt;
 }
 public String toString() {
     return nr + ", " + name + ", " + ort + ", " + gehalt;
 }
}

class MitarbeiterVerwaltung {
 public static void main(String[] args) {
     String[] daten = {
         "4711;Anna;Ingolstadt;3500",
         "4712;Bernd;Augsburg;3000",
         "4713;Clara;Ingolstadt;4000"
     };

     Map<Integer, Mitarbeiter> mitarbeiter = new HashMap<>();
     for (String zeile : daten) {
         String[] spalten = zeile.split(";");
         int nr = Integer.parseInt(spalten[0]);
         String name = spalten[1];
         String ort = spalten[2];
         double gehalt = Double.parseDouble(spalten[3]);
         mitarbeiter.put(nr, new Mitarbeiter(nr, name, ort, gehalt));
     }

     // Ausgabe: Standard (nach Nummer)
     System.out.println("Sortiert nach Nummer:");
     mitarbeiter.entrySet().stream()
             .sorted(Map.Entry.comparingByKey())
             .forEach(e -> System.out.println(e.getValue()));

     // Ausgabe: Nach Ort (und bei Gleichheit nach Name)
     System.out.println("\nSortiert nach Ort:");
     mitarbeiter.values().stream()
             .sorted(Comparator.comparing((Mitarbeiter m) -> m.ort)
                     .thenComparing(m -> m.name))
             .forEach(System.out::println);
 }
}

//=======================================
//3. Wortzähler mit Map (Klassiker!)
//=======================================
/*
Aufgabenstellung:
- Lies Text als String
- Zähle, wie oft jedes Wort vorkommt
- Gib jedes Wort mit Häufigkeit aus (Map<String, Integer>)
*/

class WortCounter {
 public static void main(String[] args) {
     String text = "Apfel Banane Apfel Apfel Birne Banane";
     String[] woerter = text.split(" ");

     Map<String, Integer> zaehler = new HashMap<>();
     for (String wort : woerter) {
         zaehler.put(wort, zaehler.getOrDefault(wort, 0) + 1);
     }

     for (Map.Entry<String, Integer> e : zaehler.entrySet()) {
         System.out.println(e.getKey() + ": " + e.getValue());
     }
 }
}
