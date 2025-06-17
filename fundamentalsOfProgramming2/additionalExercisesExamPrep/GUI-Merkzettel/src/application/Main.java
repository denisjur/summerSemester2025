package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MegaTool extends Application {

    @Override
    public void start(Stage stage) {
        // Struktur: TabPane (2 Tabs)
        // ├── Übersetzer-Tab
        // └── Rechner-Tab

        TabPane tabs = new TabPane();

        // === Tab 1: Übersetzer ===
        Tab translatorTab = new Tab("Übersetzer");
        translatorTab.setContent(buildTranslatorUI()); // → separate Methode
        translatorTab.setClosable(false); // User kann Tab nicht schließen

        // === Tab 2: Rechner ===
        Tab calculatorTab = new Tab("Taschenrechner");
        calculatorTab.setContent(buildCalculatorUI()); // → separate Methode
        calculatorTab.setClosable(false);

        // Tabs hinzufügen
        tabs.getTabs().addAll(translatorTab, calculatorTab);

        // Szene erzeugen und anzeigen
        Scene scene = new Scene(tabs, 600, 400);
        stage.setTitle("MegaTool: Übersetzer & Rechner");
        stage.setScene(scene);
        stage.show();
    }

    // ====================================================================================
    // 1. UI für Übersetzer
    // ====================================================================================
    private VBox buildTranslatorUI() {
        // Struktur:
        // VBox (senkrecht):
        // ├── Label: "Von Sprache:"
        // ├── ChoiceBox: von
        // ├── Label: "Nach Sprache:"
        // ├── ChoiceBox: nach
        // ├── TextArea: Eingabetext
        // ├── Button: Übersetzen
        // └── Label: Ergebnis

        VBox layout = new VBox(10);
        layout.setPadding(new javafx.geometry.Insets(10));

        // Texteingabe
        TextArea inputText = new TextArea();
        inputText.setPromptText("Text eingeben...");
        inputText.setWrapText(true);

        // Sprachauswahl (ChoiceBox)
        ChoiceBox<String> fromLang = new ChoiceBox<>();
        ChoiceBox<String> toLang = new ChoiceBox<>();

        ObservableList<String> allLanguages = FXCollections.observableArrayList(
            "Deutsch", "Englisch", "Französisch", "Spanisch"
        );
        fromLang.setItems(allLanguages);
        fromLang.getSelectionModel().selectFirst(); // Default: Deutsch

        // Zielsprachen initial belegen
        toLang.setItems(allLanguages.filtered(lang -> !lang.equals("Deutsch")));
        toLang.getSelectionModel().selectFirst();

        // Ereignis: Wenn von-Sprache geändert wird, Ziel neu setzen
        fromLang.setOnAction(e -> {
            String selected = fromLang.getSelectionModel().getSelectedItem();
            toLang.setItems(allLanguages.filtered(lang -> !lang.equals(selected)));
            toLang.getSelectionModel().selectFirst();
        });

        // Übersetzen-Button
        Button translateBtn = new Button("Übersetzen");

        // Ergebnisanzeige
        Label outputLabel = new Label("Übersetzter Text erscheint hier.");

        // Aktion: Übersetzen (hier simuliert)
        translateBtn.setOnAction(e -> {
            String input = inputText.getText();
            String source = fromLang.getValue();
            String target = toLang.getValue();
            outputLabel.setText("[" + target + "] " + input.toUpperCase());
        });

        // UI zusammenbauen
        layout.getChildren().addAll(
            new Label("Von Sprache:"), fromLang,
            new Label("Nach Sprache:"), toLang,
            inputText,
            translateBtn,
            outputLabel
        );

        return layout;
    }

    // ====================================================================================
    // 2. UI für Taschenrechner
    // ====================================================================================
    private VBox buildCalculatorUI() {
        // Struktur:
        // VBox (senkrecht):
        // ├── Label: "Zahl 1"
        // ├── TextField: Zahl 1
        // ├── Label: "Zahl 2"
        // ├── TextField: Zahl 2
        // ├── HBox: Buttons + - * /
        // └── Label: Ergebnis

        VBox layout = new VBox(10);
        layout.setPadding(new javafx.geometry.Insets(10));

        // Zwei Eingabefelder
        TextField zahl1 = new TextField();
        zahl1.setPromptText("Zahl 1");

        TextField zahl2 = new TextField();
        zahl2.setPromptText("Zahl 2");

        // Ergebnisanzeige
        Label resultLabel = new Label("Ergebnis:");

        // Rechen-Buttons
        Button addBtn = new Button("+");
        Button subBtn = new Button("-");
        Button mulBtn = new Button("*");
        Button divBtn = new Button("/");

        // Buttons nebeneinander in HBox
        HBox buttons = new HBox(10, addBtn, subBtn, mulBtn, divBtn);

        // Aktionen zuweisen
        addBtn.setOnAction(e -> calculate(zahl1, zahl2, resultLabel, "+"));
        subBtn.setOnAction(e -> calculate(zahl1, zahl2, resultLabel, "-"));
        mulBtn.setOnAction(e -> calculate(zahl1, zahl2, resultLabel, "*"));
        divBtn.setOnAction(e -> calculate(zahl1, zahl2, resultLabel, "/"));

        // UI zusammenbauen
        layout.getChildren().addAll(
            new Label("Zahl 1:"), zahl1,
            new Label("Zahl 2:"), zahl2,
            buttons,
            resultLabel
        );

        return layout;
    }

    // ====================================================================================
    // Berechnungslogik für den Rechner
    // ====================================================================================
    private void calculate(TextField n1, TextField n2, Label result, String op) {
        try {
            // Eingabe aus den Textfeldern holen
            double a = Double.parseDouble(n1.getText());
            double b = Double.parseDouble(n2.getText());

            // Moderner Switch-Ausdruck mit Rückgabewert
            double r = switch (op) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> {
                    if (b == 0) {
                        throw new ArithmeticException("Division durch 0!");
                    }
                    yield a / b; // yield gibt den Wert zurück
                }
                default -> 0;
            };

            // Ergebnis anzeigen
            result.setText("Ergebnis: " + r);
        } catch (NumberFormatException e) {
            result.setText("Fehler: Bitte gültige Zahlen eingeben.");
        } catch (ArithmeticException e) {
            result.setText("Fehler: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        launch(args);

    
    }
    
    // Output:
	//    ╔═════════════════════════════════════╗
	//    ║             MegaTool                ║
	//    ╠═════════════════════════════════════╣
	//    ║ [Übersetzer] [Taschenrechner]       ║ ← TabPane mit zwei Tabs
	//    ╠═════════════════════════════════════╣
	//    ║        (Tab: Übersetzer)            ║
	//    ║ ┌───────────────────────────────┐   ║
	//    ║ │ Label: "Von Sprache"          │   ║
	//    ║ │ ChoiceBox: Deutsch            │   ║
	//    ║ │ Label: "Nach Sprache"         │   ║
	//    ║ │ ChoiceBox: Englisch           │   ║
	//    ║ │ TextArea: „Hallo Welt“        │   ║
	//    ║ │ Button: [Übersetzen]          │   ║
	//    ║ │ Label: "[Englisch] HELLO..."  │   ║
	//    ║ └───────────────────────────────┘   ║
	//    ║                                     ║
	//    ║        (Tab: Rechner)               ║
	//    ║ ┌───────────────────────────────┐   ║
	//    ║ │ Label: "Zahl 1"               │   ║
	//    ║ │ TextField: 42                 │   ║
	//    ║ │ Label: "Zahl 2"               │   ║
	//    ║ │ TextField: 7                  │   ║ 
	//    ║ │ [ + ] [ - ] [ * ] [ / ]       │   ║
	//    ║ │ Label: Ergebnis: 49           │   ║
	//    ║ └───────────────────────────────┘   ║
	//    ╚═════════════════════════════════════╝

    
    
    
    
    
}

