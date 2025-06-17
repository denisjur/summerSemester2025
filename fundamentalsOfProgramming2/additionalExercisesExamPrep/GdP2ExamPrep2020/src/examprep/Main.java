package examprep;

import java.util.Arrays;
import java.util.List;
import java.util.*;


public class Main {
	// Aufgabe 1 (Verschiedene Fragen: ca. 25%) *************************************************************************************

	// a) Gegeben sei der Quelltext „Hello.java“ der Klasse Hello, die „Hello World!“ auf die 
	// Konsole ausgibt. Beschreiben Sie, welche Programme genutzt werden und 
	// welche Dateien genutzt bzw. im Vorfeld erzeugt werden müssen, um die 
	// Anwendung auszuführen. Was bietet sich für große Programme mit sehr vielen 
	// Klassen an, um das Programm schnell auf anderen Rechnern zu installieren? 
	// (6 Pkt.)

	/*
	Antwort:
	- Notwendig ist ein Texteditor oder eine integrierte Entwicklungsumgebung (IDE) wie IntelliJ, Eclipse oder VSCode.
	- Um den Code auszuführen, wird der Java Compiler (javac) benötigt, der aus „Hello.java“ die Datei „Hello.class“ erzeugt (Bytecode).
	- Zur Ausführung dient die Java Virtual Machine (JVM), gestartet mit „java Hello“.
	- Für große Programme empfiehlt sich das Erzeugen eines JAR (Java ARchive)-Pakets. Dieses enthält alle Klassen und Ressourcen gebündelt und kann einfach transportiert und gestartet werden (z.B. mit „java -jar programm.jar“).
	*/

	// b) Gegeben sei folgende main-Funktion:
	/*
	01 public static void main(String[] args) {
	02     Predicate<String> validFilename = s -> {
	03         int point = s.lastIndexOf(".");
	04         if (point > 0) {
	05             String name = s.substring(0, point);
	06             String ext = s.substring(point+1);
	07             if (name.length() > 0 && ext.length() > 0) {
	08                 return true;
	09             }
	10         }
	11         return false;
	12     };
	13     Consumer<String> output = s -> {
	14         String f = s.substring(0,s.lastIndexOf("."));
	15         String e = s.substring(s.lastIndexOf(".")+1);
	16         System.out.println("file=" + f + ", ext=" + e);
	17     };
	18     Stream.of("file.mp3", ".mp3", "b.c", "a.", "abc", "42.txt")
	19         .filter(validFilename)
	20         .forEach(output);
	21 }
	*/

	// b.1) Welche Ausgabe erzeugt main() bei Ausführung? (6 Pkt.)
	/*
	Antwort:
	- Nur gültige Dateinamen mit einem Punkt, Name und Extension > 0 Länge werden ausgegeben.
	- Aus "file.mp3", ".mp3", "b.c", "a.", "abc", "42.txt" sind gültig:
	  - "file.mp3"
	  - "b.c"
	  - "42.txt"
	Ausgabe:
	file=file, ext=mp3
	file=b, ext=c
	file=42, ext=txt
	*/

	// b.2) Ergänzen Sie das folgende Codefragment so, dass es ohne Lambdas und 
	// Streams die oben gegebene Funktionalität abbildet und dieselbe Ausgabe erzeugt. 
	// (13 Pkt.)

	public static void main(String[] args) {
	    List<String> strings = Arrays.asList("file.mp3", ".mp3", "b.c", "a.", "abc", "42.txt");
	    for (int i = 0; i < strings.size(); i++) {
	        String s = strings.get(i);
	        int point = s.lastIndexOf(".");
	        if (point > 0) {
	            String name = s.substring(0, point);
	            String ext = s.substring(point + 1);
	            if (name.length() > 0 && ext.length() > 0) {
	                String f = name;
	                String e = ext;
	                System.out.println("file=" + f + ", ext=" + e);
	            }
	        }
	    }
	}

	/*
	Kommentar:
	- Anstelle von Predicate und Stream-Filter wird eine klassische Schleife genutzt.
	- Die Bedingungen zur Prüfung der Gültigkeit wurden übernommen.
	- Ausgabeformatierung bleibt gleich.
	*/


	
	// Aufgabe 2 (Vererbung und Interfaces: ca. 25%) *******************************************************************************

	// a.) Gegeben ist die Implementierung für die Schnittstellen Schalter, Lampe und 
	// TemperaturSensor sowie die Klasse Geraet. Implementieren Sie die Klassen 
	// LampeMitSchalter und SmartGummiEnte. Das Ergebnis der Methode 
	// getWerte soll dabei den Zustand des jeweiligen Objekts beschreiben. (15 Pkt.)

	// Interface für schaltbare Geräte: stellt eine Methode zum Abfragen des Schaltstatus bereit
	interface Schalter {
	    double getStatus();
	}

	// Interface für Lampen: ermöglicht das Setzen von Status (Helligkeit) und Farbe
	interface Lampe {
	    void setStatus(double value);
	    void setFarbe(int value);
	}

	// Interface für Temperatursensoren: liefert Temperaturwert
	interface TemperaturSensor {
	    double getTemperatur();
	}

	// Abstrakte Basisklasse für alle Geräte: besitzt einen Namen und eine abstrakte Methode zur Rückgabe von Zustandswerten
	abstract class Geraet {
	    private String name;

	    public Geraet(String name) {
	        this.name = name; // Gerätebezeichnung setzen
	    }

	    public String getName() {
	        return name; // liefert den Namen des Geräts zurück
	    }

	    public abstract double[] getWerte(); // abstrakte Methode für Gerätezustand
	}

	// Konkrete Klasse LampeMitSchalter implementiert Lampe + Schalter, erbt von Geraet
	class LampeMitSchalter extends Geraet implements Lampe, Schalter {
	    private double status; // z.B. Helligkeit oder Ein/Aus Zustand
	    private int farbe;     // Farbwert (als int, z.B. RGB hex)

	    // Konstruktor initialisiert Name, Status und Farbe
	    public LampeMitSchalter(String name, double status, int farbe) {
	        super(name);           // Aufruf des Konstruktors von Geraet
	        this.status = status; // interner Schaltstatus
	        this.farbe = farbe;   // interne Farbvariable
	    }

	    // Rückgabe des aktuellen Status
	    public double getStatus() {
	        return status;
	    }

	    // Setzen des Statuswerts
	    public void setStatus(double value) {
	        this.status = value;
	    }

	    // Setzen des Farbwerts
	    public void setFarbe(int value) {
	        this.farbe = value;
	    }

	    // Hilfsmethode zur Abfrage der aktuellen Farbe (nicht im Interface, aber nützlich)
	    public int getFarbe() {
	        return farbe;
	    }

	    // Zustandsrückgabe als double-Array: Status + Farbwert (als double gecastet)
	    public double[] getWerte() {
	        return new double[] { status, (double) farbe };
	    }
	}

	// Klasse SmartGummiEnte implementiert TemperaturSensor, erbt ebenfalls von Geraet
	class SmartGummiEnte extends Geraet implements TemperaturSensor {
	    private double status;       // z.B. Schaltstatus
	    private int farbe;           // aktuelle Farbe
	    private double temperatur;   // Temperaturwert

	    // Konstruktor mit Initialisierung aller relevanten Felder
	    public SmartGummiEnte(String name, double status, int farbe, double temperatur) {
	        super(name);
	        this.status = status;
	        this.farbe = farbe;
	        this.temperatur = temperatur;
	    }

	    // Implementierung aus TemperaturSensor
	    public double getTemperatur() {
	        return temperatur;
	    }

	    // Rückgabe des vollständigen Gerätezustands als Array
	    public double[] getWerte() {
	        return new double[] { status, (double) farbe, temperatur };
	    }
	}


	/*
	Kommentar:
	- Alle Methoden sind so implementiert, dass sie mit den Interface-Spezifikationen übereinstimmen.
	- Die Klassendesigns spiegeln die Vererbung aus der Aufgabenstellung wider (siehe UML-Diagramm).
	- Bei getWerte() wurde beachtet, dass Farbwerte (int) als double gewandelt werden, da Rückgabetyp double[] ist.
	*/
	
	
	
	
	// Aufgabe 3 (Collections: ca. 25%) **************************************************************************************

	// a.) Realisieren Sie die statische Methode verarbeiten. Verarbeiten Sie das 
	// vorgegebene String-Array so, dass entsprechende Instanzen der Klasse Farbe 
	// erzeugt werden. Fügen Sie diese Instanzen als Schlüssel und den zugehörigen 
	// Namen als Wert in eine neu zu erzeugende HashMap ein.



	// Klasse zur Darstellung einer Farbe durch RGB-Werte
	class Farbe {
	    private int rot;
	    private int gruen;
	    private int blau;

	    public Farbe(int rot, int gruen, int blau) {
	        this.rot = rot;
	        this.gruen = gruen;
	        this.blau = blau;
	    }

	    public int getRot() { return rot; }
	    public int getGruen() { return gruen; }
	    public int getBlau() { return blau; }

	    // Zwei Farbobjekte sind gleich, wenn ihre RGB-Werte gleich sind
	    public boolean equals(Object o) {
	        if (!(o instanceof Farbe)) return false;
	        Farbe f = (Farbe) o;
	        return rot == f.rot && gruen == f.gruen && blau == f.blau;
	    }

	    // Passender HashCode, damit Farbe als Schlüssel in HashMap funktioniert
	    public int hashCode() {
	        return Objects.hash(rot, gruen, blau);
	    }

	    // Statische Methode zur Verarbeitung der tokens (Name + RGB als Gruppen)
	    public static Map<Farbe, String> verarbeiten(String[] tokens) {
	        Map<Farbe, String> map = new HashMap<>(); // Neue HashMap
	        for (int i = 0; i < tokens.length; i += 4) {
	            String name = tokens[i]; // Farbname
	            int r = Integer.parseInt(tokens[i + 1]); // R-Wert parsen
	            int g = Integer.parseInt(tokens[i + 2]); // G-Wert parsen
	            int b = Integer.parseInt(tokens[i + 3]); // B-Wert parsen
	            Farbe f = new Farbe(r, g, b); // neues Farbe-Objekt
	            map.put(f, name); // in Map einfügen
	        }
	        return map;
	    }

	    // b.) Comparator zur Sortierung nach R, dann G, dann B
	    public static Comparator<Farbe> getComparator() {
	        return (f1, f2) -> {
	            if (f1 == null) return -1;
	            if (f2 == null) return 1;
	            int cmp = Integer.compare(f1.getRot(), f2.getRot());
	            if (cmp != 0) return cmp;
	            cmp = Integer.compare(f1.getGruen(), f2.getGruen());
	            if (cmp != 0) return cmp;
	            return Integer.compare(f1.getBlau(), f2.getBlau());
	        };
	    }

	    // c.) Ausgabe der Map-Einträge, sortiert nach Farbe
	    public static void ausgeben(Map<Farbe, String> map) {
	        List<Farbe> farben = new ArrayList<>(map.keySet()); // Schlüssel extrahieren
	        farben.sort(Farbe.getComparator()); // sortieren nach RGB
	        for (Farbe f : farben) {
	            String name = map.get(f);
	            System.out.println(f.getRot() + "," + f.getGruen() + "," + f.getBlau() + " = " + name);
	        }
	    }

	    // Test über main()
	    public static void main(String[] args) {
	        String[] tokens = new String[] {
	            "rot", "255", "0", "0",
	            "weiss", "255", "255", "255",
	            "türkis", "0", "255", "255",
	            "orange", "255", "165", "0",
	            "grau", "128", "128", "128"
	        };
	        Map<Farbe, String> map = verarbeiten(tokens); // Farben parsen
	        ausgeben(map); // sortierte Ausgabe
	    }
	}

	/*
	Kommentar:
	- In verarbeiten() wird das Eingabe-Array in Viererschritten zerlegt (Name + R + G + B) und in eine Map übertragen.
	- equals und hashCode sind korrekt implementiert, damit Farbe als Schlüssel verwendet werden kann.
	- Der Comparator sortiert nach R, dann G, dann B, wobei null-Checks enthalten sind.
	- ausgeben() listet alle Einträge der Map sortiert nach Farbe auf.
	*/

	
	// Nr. 4 *********************************************************************************************************** 
	
	
	// Aufgabe 4 (GUI: ca. 25%)

	// a) Skizzieren Sie das Dialoglayout mit Hilfe einer Layout-Hierarchie. (6 Pkt.)
	/*
	VBox (Hauptcontainer)
	├── HBox (Auswahlfelder)
	│   ├── ChoiceBox Ausgangssprache
	│   └── ChoiceBox Zielsprache
	├── TextArea für Eingabetext
	├── Button "übersetzen"
	└── Label für Ausgabetext
	
	Layout-Hierarchie als einfache ASCII-Skizze:
	┌──────────────────────────────┐
	│ VBox (mainPane)              │
	│ ┌──────────────────────── ┐  │
	│ │ HBox (languageSelection)│  │
	│ │ ┌────────────┐ ┌──────┐ │  │
	│ │ │ sourceBox  │ │target│ │  │
	│ │ └────────────┘ └──────┘ │  │
	│ └──────────────────────── ┘  │
	│ ┌──────────────────────────┐ │
	│ │ TextArea (inputArea)     │ │
	│ └──────────────────────────┘ │
	│ ┌──────────────────────────┐ │
	│ │ Button (translateButton) │ │
	│ └──────────────────────────┘ │
	│ ┌──────────────────────────┐ │
	│ │ Label (outputLabel)      │ │
	│ └──────────────────────────┘ │
	└──────────────────────────────┘
	*/

	// b + c) Vervollständigung der Methode start(Stage stage) für GUI und Ereignisbehandlung

	//	import javafx.application.Application; // notwendig für JavaFX-Anwendung
	//	import javafx.collections.FXCollections; // um ObservableList zu erstellen
	//	import javafx.collections.ObservableList; // dynamische Liste für GUI-Komponenten
	//	import javafx.scene.Scene; // Repräsentiert das gesamte GUI-Inhaltsfenster
	//	import javafx.scene.control.*; // Importiert alle gängigen Steuerelemente (ChoiceBox, TextArea, etc.)
	//	import javafx.scene.layout.*; // Layout-Manager wie VBox, HBox
	//	import javafx.stage.Stage; // Das Hauptfenster der App
	//	import java.util.*; // für Listenfunktionen und Collections

	// Simulierter Übersetzer, stellt Übersetzlogik zur Verfügung
	class Translator {
	    public Translator() {} // Leerer Konstruktor

	    // Beispielübersetzung als Platzhalter
	    public String translateSentence(String sourceLanguage, String targetLanguage, String text) {
	        return "Übersetzt(" + sourceLanguage + "→" + targetLanguage + "): " + text;
	    }
	}

	// Hauptklasse, startet JavaFX-Anwendung
	public class UebersetzerApp extends Application {
	    public static void main(String[] args) {
	        launch(args); // Startet die JavaFX-App (ruft start(Stage) auf)
	    }

	    // Liefert alle Zielsprachen außer der ausgewählten Ausgangssprache zurück
	    private ObservableList<String> getTargetLanguages(List<String> allLanguages, String sourceLanguage) {
	        List<String> result = new ArrayList<>(allLanguages); // kopiert komplette Liste
	        result.remove(sourceLanguage); // entfernt die aktuelle Ausgangssprache
	        return FXCollections.observableArrayList(result); // liefert als ObservableList zurück
	    }

	    @Override
	    public void start(Stage stage) {
	        // Liste mit allen unterstützten Sprachen definieren
	        List<String> allLanguages = Arrays.asList("Deutsch", "Englisch", "Französisch", "Russisch");
	        ObservableList<String> sprachen = FXCollections.observableList(allLanguages); // in ObservableList umwandeln

	        // Ausgangssprachen-ChoiceBox, initialisiert mit allen Sprachen
	        ChoiceBox<String> sourceBox = new ChoiceBox<>(sprachen);
	        sourceBox.getSelectionModel().selectFirst(); // A1: automatisch erste Sprache auswählen

	        // Zielsprachen-ChoiceBox, berechnet anhand aktueller Auswahl der Ausgangssprache
	        ChoiceBox<String> targetBox = new ChoiceBox<>(getTargetLanguages(allLanguages, sourceBox.getValue())); // A2

	        // A3: aktualisiert Zielsprachen, wenn Benutzer die Ausgangssprache ändert
	        sourceBox.setOnAction(e -> {
	            targetBox.setItems(getTargetLanguages(allLanguages, sourceBox.getValue())); // neue Liste setzen
	            targetBox.getSelectionModel().selectFirst(); // erste Sprache auswählen, damit kein null entsteht
	        });

	        // TextArea: Eingabe für den zu übersetzenden Text
	        TextArea inputArea = new TextArea();

	        // Label zur Anzeige der Übersetzungsausgabe
	        Label outputLabel = new Label("Ergebnis erscheint hier");

	        // Button, der beim Klick die Übersetzung ausführt
	        Button translateButton = new Button("übersetzen");
	        translateButton.setOnAction(e -> {
	            String source = sourceBox.getValue(); // aktuelle Ausgangssprache holen
	            String target = targetBox.getValue(); // aktuelle Zielsprache holen
	            String text = inputArea.getText(); // eingegebener Text
	            Translator translator = new Translator(); // neue Translator-Instanz
	            String result = translator.translateSentence(source, target, text); // Übersetzung simulieren
	            outputLabel.setText(result); // Ausgabe anzeigen
	        });

	        // HBox für die Spracheingabe (nebeneinander)
	        HBox languageSelection = new HBox(10, sourceBox, targetBox); // Abstand 10px zwischen Komponenten

	        // VBox für das Gesamtlayout: alles untereinander angeordnet
	        VBox mainPane = new VBox(10, languageSelection, inputArea, translateButton, outputLabel); // vertikale Anordnung

	        // Scene (GUI-Inhalt), setzt Hauptlayout, Breite und Höhe des Fensters
	        Scene scene = new Scene(mainPane, 300, 250);
	        stage.setScene(scene); // verbindet die Scene mit dem Stage-Fenster
	        stage.setTitle("Übersetzer"); // Fenstertitel setzen
	        stage.show(); // Fenster anzeigen
	    }
	}

	/*
	Kommentar:
	- Die GUI wurde entsprechend der Skizze mit VBox + HBox umgesetzt.
	- ChoiceBoxen für Sprachen, TextArea für Eingabe, Button für Aktion, Label für Ausgabe.
	- Ereignisbehandlung deckt A3 (Neubelegung Zielsprachen) und A4 (Übersetzung) ab.

	====== JavaFX BASISWISSEN ======
	- Application ist die Basisklasse für jede JavaFX-App. Die start(Stage) Methode muss überschrieben werden.
	- Stage ist das Hauptfenster (z. B. ein Fenster mit Titelzeile).
	- Scene ist der Inhalt dieses Fensters (GUI-Elemente wie Buttons, Labels usw.).
	- Layout-Container wie VBox und HBox bestimmen die Anordnung der Elemente:
	  - VBox = vertikal untereinander
	  - HBox = horizontal nebeneinander
	- ChoiceBox = Auswahlfeld (wie Dropdown)
	- TextArea = mehrzeilige Texteingabe
	- Button = klickbares Element zur Ausführung
	- Label = statischer Text (z. B. Ausgabefeld)
	- Ereignisbehandlung wird über .setOnAction(...) gemacht, typischerweise mit Lambda-Ausdruck oder EventHandler
	*/
	
}

