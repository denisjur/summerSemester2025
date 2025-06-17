package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application { 
    // <- Application ist die Elternklasse, und Main ist die Kindklasse.
    // Main-Klasse erbt alles vom Parent (Application).

    // ┌────────────────────────────┐
    // │        Stage (Fenster)     │  ← Hauptfenster (z. B. ein Browserfenster). Wie im Theater.
    // │  ┌──────────────────────┐  │
    // │  │      Scene           │  │  ← Eine "Seite" mit UI-Inhalt. Hier spielt die Szene auf der Stage.
    // │  │  ┌────────────────┐  │  │
    // │  │  │  Root Node     │  │  │  ← Startpunkt des Scene Graphen (z. B. VBox)
    // │  │  │ ┌────────────┐ │  │  │
    // │  │  │ │ Button     │ │  │  │  ← UI-Element
    // │  │  │ └────────────┘ │  │  │
    // │  │  └────────────────┘  │  │
    // │  └──────────────────────┘  │
    // └────────────────────────────┘

    public static void main(String[] args) {
        launch(args); 
        // Startet die JavaFX-Anwendung. LAUNCH-Methode gehört der Application-Klasse.
        // Ai putea scrie și Application.launch(args);
    }

    @Override // Pentru că e moștenit de la clasa Application
    public void start(Stage primaryStage) {

        // **************************************************************************************************
        // Stage = Das Hauptfenster deiner Anwendung (wie ein Rahmen ums Bild)
        //        → Es ist das oberste Fenster, in dem alles andere angezeigt wird.
        //
        // Scene = Der "Inhalt" des Fensters – wie eine Seite in einem Buch.
        //        → Eine Scene enthält den Scene Graph.
        //
        // Root Node = Die Wurzel des Scene Graphen (meist ein Layout-Container, z. B. VBox oder BorderPane)
        // **************************************************************************************************

        // Group = einfacher Container, der mehrere Nodes enthalten kann
        Group root = new Group(); 
        
        // Scene mit Root-Node und schwarzem Hintergrund erstellen
        Scene scene = new Scene(root, Color.BLACK);

        // Titel des Fensters (Stage)
        primaryStage.setTitle("Stage Demo Programm");

        // Bild-Icon oben links setzen (wenn vorhanden)
        // Image icon = new Image("icon.png");
        // primaryStage.getIcons().add(icon);

        // Fenstergröße festlegen
        primaryStage.setWidth(520);
        primaryStage.setHeight(520);

        // Fenstergröße nicht veränderbar machen
        primaryStage.setResizable(false); 

        // Fensterposition setzen (optional)
        // primaryStage.setX(50); 
        // primaryStage.setY(50); 

        // Fenster im Vollbildmodus anzeigen
        primaryStage.setFullScreen(true); 

        // Änderung des Standard-"Escape"-Tastens für Fullscreen-Modus
        primaryStage.setFullScreenExitHint("You can escape this window by pressing q");
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));

        // Szene dem Fenster hinzufügen
        primaryStage.setScene(scene);

        // Fenster anzeigen
        primaryStage.show();
    }
}
