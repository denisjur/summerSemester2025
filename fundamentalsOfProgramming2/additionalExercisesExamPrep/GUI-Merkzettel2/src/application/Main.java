package application;

//MegaCode-Sammlung für Prüfungsrelevante JavaFX-GUIs
//Enthält 4 Programme: TicTacToe, Sortieranzeige, Suchfeld mit Filterung, Formular
//Jedes Teilprogramm ist kommentiert und enthält ASCII-Layout zur visuellen Strukturierung

import javafx.application.Application;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
 public static void main(String[] args) { launch(args); }

 @Override
 public void start(Stage stage) {
     // ╔════════════════════════════════════╗
     // ║              MegaProgramme         ║
     // ║  ┌────────────┬────────────────┐  ║
     // ║  │ TicTacToe │ Sortieren ...  │  ║ ← TabPane
     // ╚════════════════════════════════════╝

     TabPane tabs = new TabPane();

     tabs.getTabs().add(new Tab("TicTacToe", buildTicTacToe()));
     tabs.getTabs().add(new Tab("Sortieren", buildSortTable()));
     tabs.getTabs().add(new Tab("Suche", buildFilterList()));
     tabs.getTabs().add(new Tab("Formular", buildFormular()));

     tabs.getTabs().forEach(t -> t.setClosable(false)); // Tabs fixiert

     stage.setScene(new Scene(tabs, 600, 500));
     stage.setTitle("MegaProgramme GUI");
     stage.show();
 }

 // ===================================
 // 1. TicTacToe Spiel (3x3 Feld)
 // ===================================
 private GridPane buildTicTacToe() {
     // Visuelles Layout:
     // ┌───┬───┬───┐
     // │ X │ O │ X │
     // ├───┼───┼───┤
     // │ O │ X │   │
     // ├───┼───┼───┤
     // │   │ O │ X │
     // └───────────┘
     // Status: Spieler X hat gewonnen!

     GridPane grid = new GridPane();
     grid.setPadding(new Insets(10));
     grid.setHgap(5);
     grid.setVgap(5);

     char[] current = {'X'}; // X beginnt
     Label status = new Label("Spieler X beginnt"); // Statusanzeige unten

     Button[][] buttons = new Button[3][3]; // 3x3 Buttonfeld
     for (int row = 0; row < 3; row++) {
         for (int col = 0; col < 3; col++) {
             Button b = new Button(" ");
             b.setPrefSize(80, 80); // Quadratische Felder
             int r = row, c = col;
             b.setOnAction(e -> {
                 if (b.getText().equals(" ")) {
                     b.setText(String.valueOf(current[0])); // Setze X oder O
                     if (checkWin(buttons, current[0])) {
                         status.setText("Spieler " + current[0] + " hat gewonnen!");
                         disableAll(buttons);
                     } else {
                         current[0] = (current[0] == 'X') ? 'O' : 'X'; // Wechsle Spieler
                         status.setText("Spieler " + current[0] + " ist am Zug");
                     }
                 }
             });
             buttons[row][col] = b;
             grid.add(b, col, row);
         }
     }
     grid.add(status, 0, 3, 3, 1); // Status unterhalb des Spielfelds
     return grid;
 }

 private boolean checkWin(Button[][] b, char p) {
     String s = String.valueOf(p);
     for (int i = 0; i < 3; i++) {
         if (b[i][0].getText().equals(s) && b[i][1].getText().equals(s) && b[i][2].getText().equals(s)) return true;
         if (b[0][i].getText().equals(s) && b[1][i].getText().equals(s) && b[2][i].getText().equals(s)) return true;
     }
     return (b[0][0].getText().equals(s) && b[1][1].getText().equals(s) && b[2][2].getText().equals(s)) ||
            (b[0][2].getText().equals(s) && b[1][1].getText().equals(s) && b[2][0].getText().equals(s));
 }

 private void disableAll(Button[][] buttons) {
     for (Button[] row : buttons)
         for (Button b : row)
             b.setDisable(true); // Spielende: alle Felder deaktivieren
 }

 // ===================================
 // 2. Sortieranzeige (Tabelle mit Personen)
 // ===================================
 private VBox buildSortTable() {
     // Layout:
     // ┌───────────────────────────────┐
     // │ Name       | Alter            │
     // │-------------------------------│
     // │ Anna       | 25               │
     // │ Bernd      | 19               │
     // └───────────────────────────────┘

     VBox box = new VBox(10);
     box.setPadding(new Insets(10));

     TableView<Person> table = new TableView<>();
     ObservableList<Person> daten = FXCollections.observableArrayList(
         new Person("Anna", 25), new Person("Bernd", 19), new Person("Clara", 30)
     );

     TableColumn<Person, String> nameCol = new TableColumn<>("Name");
     nameCol.setCellValueFactory(p -> p.getValue().nameProperty());

     TableColumn<Person, Number> ageCol = new TableColumn<>("Alter");
     ageCol.setCellValueFactory(p -> p.getValue().ageProperty());

     table.setItems(daten);
     table.getColumns().addAll(nameCol, ageCol);
     table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

     box.getChildren().addAll(new Label("Personentabelle (sortierbar):"), table);
     return box;
 }

 // ===================================
 // 3. Suchfeld mit Filterung (Live-Filter)
 // ===================================
 private VBox buildFilterList() {
     // Layout:
     // ┌────────────────────────────┐
     // │ TextField: Suchbegriff     │
     // │ ListView: Gefilterte Liste │
     // └────────────────────────────┘

     VBox box = new VBox(10);
     box.setPadding(new Insets(10));

     TextField suchfeld = new TextField();
     suchfeld.setPromptText("Suchbegriff eingeben");

     ObservableList<String> original = FXCollections.observableArrayList("Apfel", "Banane", "Birne", "Beere", "Ananas");
     FilteredList<String> gefiltert = new FilteredList<>(original, s -> true);
     ListView<String> listView = new ListView<>(gefiltert);

     suchfeld.textProperty().addListener((obs, old, neu) -> {
         gefiltert.setPredicate(item -> item.toLowerCase().contains(neu.toLowerCase()));
     });

     box.getChildren().addAll(new Label("Suchliste:"), suchfeld, listView);
     return box;
 }

 // ===================================
 // 4. Formular (Dateneingabe + Prüfung)
 // ===================================
 private VBox buildFormular() {
     // Layout:
     // ┌────────────────────────────┐
     // │ Name: [___________]        │
     // │ Alter: [_____]             │
     // │ Geschlecht: [Dropdown]     │
     // │ [Absenden]                 │
     // │ Label: Ergebnis / Fehler   │
     // └────────────────────────────┘

     VBox box = new VBox(10);
     box.setPadding(new Insets(10));

     TextField name = new TextField();
     name.setPromptText("Name");

     TextField alter = new TextField();
     alter.setPromptText("Alter (Zahl)");

     ChoiceBox<String> geschlecht = new ChoiceBox<>(FXCollections.observableArrayList("Männlich", "Weiblich", "Divers"));
     geschlecht.getSelectionModel().selectFirst();

     Button absenden = new Button("Absenden");
     Label ausgabe = new Label();

     absenden.setOnAction(e -> {
         try {
             String n = name.getText();
             int a = Integer.parseInt(alter.getText());
             String g = geschlecht.getValue();
             ausgabe.setText("Name: " + n + ", Alter: " + a + ", Geschlecht: " + g);
         } catch (Exception ex) {
             ausgabe.setText("Fehlerhafte Eingabe!");
         }
     });

     box.getChildren().addAll(new Label("Formular"), name, alter, geschlecht, absenden, ausgabe);
     return box;
 }
}

//Unterstützende Klasse für Tabelle
import javafx.beans.property.*;
class Person {
 private final StringProperty name;
 private final IntegerProperty age;

 public Person(String name, int age) {
     this.name = new SimpleStringProperty(name);
     this.age = new SimpleIntegerProperty(age);
 }

 public StringProperty nameProperty() { return name; }
 public IntegerProperty ageProperty() { return age; }
}
