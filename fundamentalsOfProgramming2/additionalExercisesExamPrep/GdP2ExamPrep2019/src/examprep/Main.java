package examprep;

//============================================================================
//Lösung zur Klausur "Programmierung in Java II", SS2019
//Stil: Aufgabenstellung vollständig übernommen, jede Teilaufgabe ausführlich kommentiert
//============================================================================

//Diese Datei enthält die vollständige Lösung der Klausur "Pruefung_PiJ2_2019ss.pdf"
//inklusive der originalen Aufgabenstellungen als Kommentarblöcke über dem jeweiligen Code.
//Jede Lösung wurde ausführlich kommentiert und entspricht exakt dem Aufbau der Aufgaben.

//============================================
//Aufgabe 1 (Verschiedene Fragen: ca. 25%)
//============================================

//Teilaufgabe a) Streams und Lambdas
//Gegeben seien folgende Anweisungen:
//Student[] liste = { new Student("Anna", 29, 4711), new Student("Maria", 17, 5012),  
//  new Student("Peter", 25, 9876) };
//Arrays.stream(liste)
//.filter(s -> s.getAlter() >= 18)
//.map(s -> new Person(s.getName(), s.getAlter()))
//.sorted()
//.forEach(s -> System.out.println(s));
//
//Formulieren Sie obige Anweisung (*) ohne Lambda-Expressions bzw. Streams:

//Lösung:
Student[] liste = {
 new Student("Anna", 29, 4711),
 new Student("Maria", 17, 5012),
 new Student("Peter", 25, 9876)
};

List<Person> personen = new ArrayList<Person>();
for (int i = 0; i < liste.length; i++) {
 Student s = liste[i];
 if (s.getAlter() >= 18) {
     personen.add(new Person(s.getName(), s.getAlter()));
 }
}
Collections.sort(personen);
for (Person p : personen) {
 System.out.println(p);
}

//--------------------------------------------
//Teilaufgabe b) Exception-Handling
//Ziel: Ergänzen Sie das folgende Klassenfragment durch geeignetes Exception-Handling,
//sodass folgende Ausgabe erzeugt wird:
//Fehler: Ungueltige Farbe gelb
//Fehler: Ungueltiger Quotient! y = 0!
//Wert zu Index -20: 13

static public void setzeFarbe(String farbe) {
 try {
     if (!farbe.equals("rot") && !farbe.equals("blau"))
         throw new Exception("Ungueltige Farbe " + farbe);
     System.out.println("Setze Farbe " + farbe + "!");
 } catch (Exception e) {
     System.out.println("Fehler: " + e.getMessage());
 }
}

static public double berechneQuotient(double x, int y) {
 if (y == 0)
     throw new RuntimeException("Ungueltiger Quotient! y = 0!");
 return x / y;
}

static int[] werte = { 13, 14, 15 };

//Liefert den Wert zu index. Ist index ungültig, wird der Wert an Index 0 geliefert.
static int gibWertZuIndex(int index) {
 int ergebnis;
 try {
     ergebnis = werte[index];
 } catch (Exception e) {
     ergebnis = werte[0];
 }
 return ergebnis;
}

public static void main(String[] args) {
 setzeFarbe("gelb");
 try {
     double q = berechneQuotient(100.0, 0);
 } catch (RuntimeException e) {
     System.out.println("Fehler: " + e.getMessage());
 }
 System.out.println("Wert zu Index -20: " + gibWertZuIndex(-20));
}

//============================================
//Aufgabe 2 (Collections: ca. 25%)
//============================================

//Teilaufgabe a) Methode dateiEinlesen()
//Ziel: Wandelt CSV-Zeilen (außer erster Kopfzeile) in Mitarbeiterobjekte und speichert diese in Map<Integer, Mitarbeiter>

private static Map<Integer, Mitarbeiter> dateiEinlesen(String[] csvDatei) {
 Map<Integer, Mitarbeiter> result = new HashMap<>();
 for (int i = 1; i < csvDatei.length; i++) {
     String[] parts = csvDatei[i].split(";");
     int nr = Integer.parseInt(parts[0]);
     String name = parts[1];
     int vorgesetzterNr = Integer.parseInt(parts[2]);
     double gehalt = Double.parseDouble(parts[3]);
     String ort = parts[4];
     int plz = Integer.parseInt(parts[5]);
     String strasse = parts[6];
     int hausNr = Integer.parseInt(parts[7]);

     Adresse adresse = new Adresse(ort, plz, strasse, hausNr);
     Mitarbeiter mitarbeiter = new Mitarbeiter(nr, name, vorgesetzterNr, gehalt, adresse);
     result.put(nr, mitarbeiter);
 }
 return result;
}

//--------------------------------------------
//Teilaufgabe b) Methode mitarbeiterAusgeben()
//Gibt alle Mitarbeiter aus – entweder in natürlicher Ordnung (nach Nr) oder sortiert nach Ort/Strasse

private static void mitarbeiterAusgeben(Map<Integer, Mitarbeiter> mitarbeiter, String sortierung) {
 List<Mitarbeiter> liste = new ArrayList<>(mitarbeiter.values());
 if (sortierung.equals("ort")) {
     Collections.sort(liste, new Comparator<Mitarbeiter>() {
         public int compare(Mitarbeiter m1, Mitarbeiter m2) {
             int cmp = m1.getAdresse().getOrt().compareTo(m2.getAdresse().getOrt());
             if (cmp != 0) return cmp;
             return m1.getAdresse().getStrasse().compareTo(m2.getAdresse().getStrasse());
         }
     });
 } else {
     Collections.sort(liste); // natürliche Ordnung
 }

 for (Mitarbeiter m : liste) {
     System.out.println(m);
 }
}

//============================================
//Aufgabe 3 (Interfaces / Iteratoren: ca. 25%)
//============================================

//Ziel: Eine Range-Klasse, die als Iterable<Integer> arbeitet und auch Iterator ist

class Range implements Iterable<Integer>, Iterator<Integer> {
 private int current, end, step;

 public Range(int init, int end, int step) {
     this.current = init;
     this.end = end;
     this.step = step;
 }

 public Range(int end) {
     this(0, end, 1);
 }

 public Range(int init, int end) {
     this(init, end, 1);
 }

 @Override
 public Iterator<Integer> iterator() {
     return this;
 }

 @Override
 public boolean hasNext() {
     return (step > 0 && current < end) || (step < 0 && current > end);
 }

 @Override
 public Integer next() {
     int result = current;
     current += step;
     return result;
 }
}

//============================================
//Aufgabe 4 (GUI: ca. 25%)
//============================================

//Ziel: GUI zur Verkehrszählung (nur PKW-Knöpfe erforderlich)

public class GuiAufgabe extends Application {
 private int pkwZaehler = 0;
 private int lkwZaehler = 0;
 private Label pkwLabel, lkwLabel, summeLabel;

 public static void main(String[] args) {
     launch(args);
 }

 @Override
 public void start(Stage stage) throws Exception {
     Button pkwPlus = new Button("+");
     Button pkwClear = new Button("clear");
     pkwLabel = new Label("0");
     lkwLabel = new Label("0");
     summeLabel = new Label("Summe: 0");

     pkwPlus.setOnAction(e -> {
         pkwZaehler++;
         aktualisieren();
     });

     pkwClear.setOnAction(e -> {
         pkwZaehler = 0;
         aktualisieren();
     });

     VBox root = new VBox(10, new Label("PKW"), pkwLabel, pkwPlus, pkwClear,
                               new Label("LKW"), lkwLabel, new Label(""), summeLabel);

     Scene scene = new Scene(root, 200, 300);
     stage.setScene(scene);
     stage.setTitle("Verkehrszählung");
     stage.show();
 }

 private void aktualisieren() {
     pkwLabel.setText(Integer.toString(pkwZaehler));
     summeLabel.setText("Summe: " + (pkwZaehler + lkwZaehler));
 }
}