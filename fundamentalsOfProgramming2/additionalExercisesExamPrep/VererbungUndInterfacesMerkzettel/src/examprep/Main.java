package examprep;

// MegaCode-Sammlung für Vererbung & Interfaces (prüfungsrelevante Szenarien)
// Enthält 3 Programme mit Aufgabenstellung, Strukturzeichnung und vollständiger Erklärung:
// 1. SmartHome-System
// 2. Zoo (Verhalten von Tieren)
// 3. Fahrzeugsteuerung

// =======================================
// 1. SMART HOME SYSTEM (Klausurähnlich)
// =======================================

/*
Aufgabenstellung:
Entwerfen Sie ein SmartHome-System mit folgenden Anforderungen:
- Es gibt eine abstrakte Klasse "Geraet" mit einem Namen und einer abstrakten Methode getStatus().
- Es gibt zwei Interfaces: "Schaltbar" (mit ein/aus) und "Messbar" (liefert Temperatur).
- Konkrete Geräte wie "Lampe" (Schaltbar) und "Thermometer" (Messbar) sollen implementiert werden.
- Erstellen Sie ein Hauptprogramm, das Geräte verwaltet und ausgibt.

Struktur (visuell):
      Geraet (abstrakt)
        /       \
   Lampe     Thermometer
   (Schaltbar)  (Messbar)
*/

// Interface für schaltbare Geräte wie Lampen
interface Schaltbar {
    void einschalten();         // Schaltet das Gerät ein
    void ausschalten();        // Schaltet das Gerät aus
    boolean istAn();           // Prüft, ob das Gerät an ist
}

// Interface für Sensoren, die Temperatur messen können
interface Messbar {
    double getTemperatur();    // Gibt die aktuelle Temperatur zurück
}

// Abstrakte Oberklasse für alle Geräte
abstract class Geraet {
    protected String name; // Der Name des Geräts

    // Konstruktor, setzt den Namen
    public Geraet(String name) {
        this.name = name;
    }

    // Abstrakte Methode, die von allen Unterklassen definiert werden muss
    public abstract void statusAnzeigen();
}

// Konkrete Klasse Lampe, die schaltbar ist
class Lampe extends Geraet implements Schaltbar {
    private boolean an = false; // Zustand: an oder aus

    public Lampe(String name) {
        super(name); // Aufruf des Konstruktors von Geraet
    }

    public void einschalten() {
        an = true;
    }

    public void ausschalten() {
        an = false;
    }

    public boolean istAn() {
        return an;
    }

    public void statusAnzeigen() {
        System.out.println("Lampe '" + name + "' ist " + (an ? "eingeschaltet" : "ausgeschaltet"));
    }
}

// Konkrete Klasse Thermometer, das Temperatur messen kann
class Thermometer extends Geraet implements Messbar {
    private double temperatur; // aktuelle Temperatur

    public Thermometer(String name, double temperatur) {
        super(name);
        this.temperatur = temperatur;
    }

    public double getTemperatur() {
        return temperatur;
    }

    public void statusAnzeigen() {
        System.out.println("Thermometer '" + name + "' zeigt " + temperatur + "°C");
    }
}

// Hauptprogramm zum Testen des SmartHome-Systems
class SmartHome {
    public static void main(String[] args) {
        // Erstellen eines Arrays von verschiedenen Geräten
        Geraet[] geraete = {
            new Lampe("Wohnzimmer"),
            new Thermometer("Balkon", 21.5),
            new Lampe("Bad")
        };

        // Durchlaufen aller Geräte
        for (Geraet g : geraete) {
            g.statusAnzeigen(); // Aufruf der implementierten Methode

            // Wenn das Gerät schaltbar ist → einschalten
            if (g instanceof Schaltbar s) {
                s.einschalten();
                System.out.println(" → " + g.name + " wurde eingeschaltet.");
            }
        }
    }
}

// =======================================
// 2. ZOO (Vererbung & Polymorphie)
// =======================================

/*
Aufgabenstellung:
Erstellen Sie ein Tiermodell mit einer abstrakten Klasse "Tier".
Jedes Tier hat einen Namen und kann ein Geräusch machen (abstrakt).
Es gibt konkrete Klassen "Hund" und "Katze", die Methode "geraeusch()" überschreiben.
Nutzen Sie ein Array von Tierobjekten, das polymorph verarbeitet wird.

Struktur:
         Tier (abstract)
        /              \
     Hund           Katze
*/

// Abstrakte Oberklasse für Tiere
abstract class Tier {
    protected String name;

    public Tier(String name) {
        this.name = name;
    }

    // Jede Tierart macht ein anderes Geräusch
    public abstract void geraeusch();
}

// Hund erbt von Tier und überschreibt die Methode
class Hund extends Tier {
    public Hund(String name) {
        super(name);
    }

    public void geraeusch() {
        System.out.println(name + " sagt: Wuff!");
    }
}

// Katze erbt von Tier und überschreibt die Methode
class Katze extends Tier {
    public Katze(String name) {
        super(name);
    }

    public void geraeusch() {
        System.out.println(name + " sagt: Miau!");
    }
}

// Hauptklasse zur Demonstration der Polymorphie
class ZooMain {
    public static void main(String[] args) {
        Tier[] tiere = {
            new Hund("Rex"),
            new Katze("Miez"),
            new Hund("Fiffi")
        };

        // Polymorpher Aufruf von geraeusch()
        for (Tier t : tiere) {
            t.geraeusch();
        }
    }
}

// =======================================
// 3. FAHRZEUGSTEUERUNG (Interface-Nutzung)
// =======================================

/*
Aufgabenstellung:
Entwickeln Sie ein Interface "Fahrbar" mit den Methoden "beschleunigen" und "bremsen".
Implementieren Sie zwei Klassen "Auto" und "Fahrrad".
Nutzen Sie ein Array von Fahrbar-Objekten, um die Fahrzeuge zu steuern.

Struktur:
      Interface: Fahrbar
        /           \
     Auto         Fahrrad
*/

// Interface für fahrbare Objekte
interface Fahrbar {
    void beschleunigen();
    void bremsen();
}

// Auto implementiert das Interface Fahrbar
class Auto implements Fahrbar {
    public void beschleunigen() {
        System.out.println("Auto beschleunigt auf 100 km/h");
    }

    public void bremsen() {
        System.out.println("Auto bremst auf 0 km/h");
    }
}

// Fahrrad implementiert ebenfalls das Interface Fahrbar
class Fahrrad implements Fahrbar {
    public void beschleunigen() {
        System.out.println("Fahrrad fährt los");
    }

    public void bremsen() {
        System.out.println("Fahrrad hält an");
    }
}

// Hauptklasse zur Steuerung mehrerer Fahrzeuge
class VerkehrMain {
    public static void main(String[] args) {
        Fahrbar[] fahrzeuge = {
            new Auto(),
            new Fahrrad()
        };

        for (Fahrbar f : fahrzeuge) {
            f.beschleunigen();
            f.bremsen();
        }
    }
}