package lambdas;

import java.awt.event.ActionEvent;         // Importiert das Event-Objekt für Button-Aktionen
import java.awt.event.ActionListener;      // Importiert das Interface für ActionListener (nicht zwingend nötig bei Lambda, aber okay)
import javax.swing.JButton;                // Importiert die Button-Klasse aus Swing
import javax.swing.JFrame;                 // Importiert die Fensterklasse aus Swing

public class MyFrame extends JFrame {      // Klasse MyFrame erbt von JFrame (macht ein eigenes Fenster)

    JButton myButton = new JButton("My BUTTON");  // Erstellt einen Button mit Text "My BUTTON"

    MyFrame() { // Konstruktor der Klasse – wird beim Erzeugen von MyFrame-Objekten aufgerufen

        myButton.setBounds(100, 100, 100, 100); // Setzt Position und Größe des Buttons (x, y, Breite, Höhe)

        myButton.addActionListener((e) ->       // Fügt eine Aktion hinzu, die bei Button-Klick passiert
            System.out.println("You clicked a Button")); // Lambda-Ausdruck: gibt eine Nachricht in der Konsole aus

        this.add(myButton);                     // Fügt den Button zum Fenster (JFrame) hinzu
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fenster schließen, wenn man auf "X" klickt
        this.setSize(420, 420);                 // Fenstergröße auf 420x420 Pixel setzen
        this.setLayout(null);                   // Kein automatisches Layout – man positioniert Komponenten manuell
        this.setVisible(true);                  // Fenster sichtbar machen
    }
}
