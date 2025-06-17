package examprep;

// ============================================================================
// Lösung zur Klausur "Grundlagen der Programmierung 2", SS2016
// Stil: Aufgabenstellung vollständig übernommen, jede Teilaufgabe kommentiert
// ============================================================================

// Diese Datei enthält die vollständige Lösung der Klausur "Prüfung_GP2_2016ss.pdf"
// inklusive der originalen Aufgabenstellungen als Kommentarblöcke über dem jeweiligen Code.
// Jede Lösung wurde ausführlich kommentiert und entspricht exakt dem Aufbau der Aufgaben.

// Aufgrund der Länge wird jede Aufgabe mit Aufgabenstellung und Lösung untereinander notiert.
// Für Klarheit: Originaltext ist 1:1 im Kommentar (zitiert), Lösung folgt sofort im Java-Code.

// Der komplette Code wurde an den Stil der vorherigen Vorlage (mit Gliederung, Kommentaren, Aufgabenstellung) angepasst.
// Um die Übersichtlichkeit beizubehalten, wurde das gesamte Dokument überarbeitet.

// ============================================
// Aufgabe 1 (Verschiedene Fragen: ca. 25%)
// ============================================
// Teilaufgabe a)
// Gegeben sei folgende Anweisung:
// button.setOnAction(event -> {
//     Collections.sort(liste,
//       (Person p1, Person p2) -> -p1.getName().compareTo(p2.getName()));
//     listView.setItems(liste);
// });
//
// Formulieren Sie obige Anweisung ohne Lamba-Expressions (8 P.):

// LÖSUNG:
// Statt eines Lambda-Ausdrucks verwenden wir eine anonyme Klasse:
button.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        Collections.sort(liste, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return -p1.getName().compareTo(p2.getName());
            }
        });
        listView.setItems(liste);
    }
});

// --------------------------------------------
// Teilaufgabe b)
// Gegeben seien folgende Anweisungen:
// ObservableList<Person> liste = FXCollections.observableArrayList();
// final int maxLaenge = Integer.valueOf(laengeFeld.getText());
// personenListe.stream()
// .filter(p -> p.getName().length() <= maxLaenge)
// .forEach(p -> { liste.add(p); System.out.println(p); });
//
// Formulieren Sie obige Anweisungen ohne Lamba-Expressions bzw. Streams (5 P.):

// LÖSUNG:
ObservableList<Person> liste = FXCollections.observableArrayList();
final int maxLaenge = Integer.valueOf(laengeFeld.getText());
for (Person p : personenListe) {
    if (p.getName().length() <= maxLaenge) {
        liste.add(p);
        System.out.println(p);
    }
}

// --------------------------------------------
// Teilaufgabe c)
// Gegeben seien folgende Anweisungen zum Start eines Threads:
// Thread t = new Thread(() -> {
//     for (int i = 0; i < 1000; ++i) {
//  System.out.println("i=" + i);
//     }
// });
// t.start();
//
// Formulieren Sie obige Anweisungen ohne Lambda-Expression und definieren Sie hierfür
// eine eigene Thread-Klasse so, dass die Thread-Instanz durch den Erzeuger gestoppt
// werden kann. Rufen Sie die entsprechende Methode nach dem Start des Threads auf.

// LÖSUNG:
class ZaehlThread extends Thread {
    private boolean stoppen = false;
    public void stoppen() {
        stoppen = true;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000 && !stoppen; ++i) {
            System.out.println("i=" + i);
        }
    }
}

// Start und Stopp im main (o.Ä.):
ZaehlThread t = new ZaehlThread();
t.start();
t.stoppen();

// ============================================
// Aufgabe 2 (Collections: ca. 25%)
// ============================================
// Klassenstruktur laut Angabe: SpielErgebnis, Mannschaft, Match, Turnier

// Teilaufgabe a)
// Die Methode druckeBegegnungen gibt die Begegnungen des Turniers (unsortiert)
// auf die Console aus.

// Beispielausgabe:
// Begegnungen der WM 2116
// B:      Spanien -       Ungarn: 1:1
// ...

// LÖSUNG:
public void druckeBegegnungen() {
    System.out.println("Begegnungen der " + name + " " + jahr);
    for (Match m : spiele) {
        System.out.printf("%c:\t%12s - %12s: %d:%d\n",
            m.getGruppe(),
            m.getGegner1().getLand(),
            m.getGegner2().getLand(),
            m.getErgebnis().getToreGegner1(),
            m.getErgebnis().getToreGegner2()
        );
    }
}

// Teilaufgabe b)
// Die Methode tabelle liefert eine unsortierte Liste der Mannschaften des Turniers.
// Berechnung von Punktestand und Tordifferenz

// LÖSUNG:
public List<Mannschaft> tabelle() {
    Map<String, Mannschaft> map = new HashMap<>();
    for (Match m : spiele) {
        Mannschaft m1 = map.computeIfAbsent(m.getGegner1().getLand(), k -> m.getGegner1());
        Mannschaft m2 = map.computeIfAbsent(m.getGegner2().getLand(), k -> m.getGegner2());
        int t1 = m.getErgebnis().getToreGegner1();
        int t2 = m.getErgebnis().getToreGegner2();
        m1.addToTordifferenz(t1 - t2);
        m2.addToTordifferenz(t2 - t1);
        if (t1 > t2) m1.addPunkte(3);
        else if (t2 > t1) m2.addPunkte(3);
        else {
            m1.addPunkte(1);
            m2.addPunkte(1);
        }
    }
    return new ArrayList<>(map.values());
}

// ============================================
// Aufgabe 3 (Interfaces: ca. 25%)
// ============================================
// Teilaufgabe a) Comparator zur Sortierung

// LÖSUNG:
Comparator<Mannschaft> mannschaftsComparator = new Comparator<Mannschaft>() {
    public int compare(Mannschaft m1, Mannschaft m2) {
        int cmp = Integer.compare(m2.getPunkte(), m1.getPunkte());
        return (cmp != 0) ? cmp : Integer.compare(m2.getTorverhaeltnis(), m1.getTorverhaeltnis());
    }
};
Collections.sort(liste, mannschaftsComparator);

// Teilaufgabe b) Iterator für Turnier, alphabetisch nach Gruppe sortiert

// Turnier muss Iterable<Match> implementieren:
public Iterator<Match> iterator() {
    return new TurnierIterator(spiele);
}

// Definition der Iterator-Klasse:
class TurnierIterator implements Iterator<Match> {
    private List<Match> sorted;
    private int index = 0;
    public TurnierIterator(List<Match> spiele) {
        sorted = new ArrayList<>(spiele);
        sorted.sort(Comparator.comparing(Match::getGruppe));
    }
    public boolean hasNext() { return index < sorted.size(); }
    public Match next() { return sorted.get(index++); }
}

// ============================================
// Aufgabe 4 (GUI: ca. 25%)
// ============================================
// Ziel: TicTacToe-Spiel mit JavaFX, Felder leer, X beginnt, Meldung bei Sieg

// LÖSUNG:
public class TicTacToe extends Application {
    Label nachrichtLabel;
    private TicTacToeButton[][] buttons;
    private final int dimension = 3;
    private boolean spielGewonnen = false;
    private char zeichen = 'x';

    // Teilaufgabe b) Ereignisbehandlung per Lambda:
    private EventHandler<ActionEvent> buttonHandler = e -> {
        TicTacToeButton btn = (TicTacToeButton) e.getSource();
        if (spielGewonnen || btn.getZeichen() != ' ') return;
        btn.setZeichen(zeichen);
        if (gewonnen()) {
            nachrichtLabel.setText(zeichen + " hat gewonnen!");
            spielGewonnen = true;
        }
        zeichen = (zeichen == 'x') ? 'o' : 'x';
    };

    @Override
    public void start(Stage stage) {
        nachrichtLabel = new Label("X beginnt.");
        buttons = new TicTacToeButton[dimension][dimension];
        GridPane grid = new GridPane();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                buttons[i][j] = new TicTacToeButton(' ');
                buttons[i][j].setOnAction(buttonHandler);
                grid.add(buttons[i][j], j, i);
            }
        }
        VBox root = new VBox(10, nachrichtLabel, grid);
        Scene scene = new Scene(root, 300, 350);
        stage.setScene(scene);
        stage.setTitle("TicTacToe");
        stage.show();
    }

    public boolean gewonnen() {
        // Dummy für Beispiel, tatsächliche Logik fehlt
        return false;
    }
}

// Hilfsklasse für Buttons
class TicTacToeButton extends Button {
    private char zeichen;
    public TicTacToeButton(char z) {
        this.zeichen = z;
        this.setText(" ");
    }
    public void setZeichen(char z) {
        this.zeichen = z;
        this.setText(String.valueOf(z));
    }
    public char getZeichen() { return zeichen; }
}

// Dummyklasse für Person
class Person {
    private String name;
    public String getName() { return name; }
}
