package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
/*
If you are using many classes from the same package (e.g., multiple from javafx.scene.shape), you can use a wildcard to simplify:
java
Code kopieren
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
*/


public class Main extends Application { 
    // <- Application ist die Elternklasse, und Main ist die Kindklasse.
    // Main-Klasse erbt alles vom Parent (Application).

    public static void main(String[] args) {
        launch(args); 
        // Startet die JavaFX-Anwendung. LAUNCH-Methode gehört der Application-Klasse.
        // Ai putea scrie și Application.launch(args);
    }

    @Override // Pentru că e moștenit de la clasa Application
    public void start(Stage primaryStage) throws Exception { // Extends Exception, arunca altundeva Exceptia
    	//Instrucțiunea throws Exception în metoda start din Java semnalează că metoda poate genera o excepție
    	// și nu o gestionează direct acolo, ci lasă tratarea ei în altă parte (de obicei în cadrul sistemului 
    	// de rulare al aplicației JavaFX).
        
     // ===================== STRUCTURA VIZUALĂ =======================
     // Stage (fereastra principală)
     // └── Scene (conținutul din fereastră)
	 //          └── Group root (containerul rădăcină)
	 //              ├── Circle (ex: cerc decorativ)
	 //              ├── Rectangle (ex: dreptunghi de fundal)
	 //              ├── Text (ex: titlu sau mesaj pe ecran)
	 //              └── ImageView (ex: imagine afișată)
     //  
     //   Stage (Fereastră)
     //   └── Scene (Ce se vede în fereastră)
     //       └── Group root (Placa de bază / Masa)
     //           ├── Text ("Salut!")
     //           ├── Rectangle (fundal)
     //           └── Circle (decor)
     //   Deci să înțeleg că root este un fel de grupă de bausteine (piese), 
     //   din care se construiește totul pe scenă? Ca și cum ai pune piese Lego pe o masă?
     //  => EXACT, DA ! 
     // ===============================================================

        // Group = einfacher Container, der mehrere Nodes enthalten kann
        Group root = new Group(); 
        // Scene mit Root-Node und schwarzem Hintergrund erstellen
        Scene scene = new Scene(root, Color.BLACK);
        // Stage hinzufügen:
        Stage stage = new Stage();
        
        
        
        // Creează un obiect Text
        Text text = new Text();

        // Setează conținutul textului
        text.setText("WHOOOOA!!");

        // Setează poziția pe scenă (x = 50, y = 50)
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana")); // Font setzen
        text.setFill(Color.GREEN); // Culoarea Textului
        
        // ================== STRUCTURĂ VIZUALĂ ===================
        // Imaginează-ți scena ca un grid (un fel de planșă):
        //
        //            (0,0)  ─────────────────────────────▶ x
        //                  │
        //                  │       "WHOOOOA!!"
        //                  │         ↑ (text apare la coordonata 50,50)
        //                  ▼
        //                  y
        // =========================================================
        
        
        //Add Lines
        Line line = new Line();
        line.setStartX(200);
        line.setStartY(200); //Unde linia incepe
        line.setEndX(500);
        line.setEndY(200); //Unde linia inceteaza
        line.setStrokeWidth(5); //Acum Thickness
        line.setStroke(Color.RED); // Acum culoarea ei
        line.setOpacity(0.5); // Il face Durchsichtlich
        line.setRotate(45); //Drehung um 45°
        

        
        // Creezi un dreptunghi gol și îl configurezi
        Rectangle rectangle = new Rectangle();

        rectangle.setX(100);       // Poziția pe orizontală (stânga)
        rectangle.setY(100);       // Poziția pe verticală (sus)
        rectangle.setWidth(100);   // Lățime
        rectangle.setHeight(100);  // Înălțime
        rectangle.setFill(Color.BLUE);         // Umple dreptunghiul cu albastru
        rectangle.setStrokeWidth(5);          // Lățimea conturului: 5 pixeli
        rectangle.setStroke(Color.BLACK);     // Culoarea conturului: negru


        // ==================== VIZUAL =====================
        // Coordonate scenă (grid):
        //
//             (0,0)
//               ┌──────────────────────────────▶ X
//               │
//               │         ██████████████
//               │         █ Rectangle  █   ← x=100, y=100
//               │         █  100x100   █
//               │         ██████████████
//               ▼
//               Y
        // ================================================

        
        
        // Acum un triunghi:
        Polygon triangle = new Polygon();

        triangle.getPoints().setAll(
            200.0, 200.0,   // Punct 1 (colțul de sus)
            300.0, 300.0,   // Punct 2 (dreapta jos)
            200.0, 300.0    // Punct 3 (stânga jos)
        );

        triangle.setFill(Color.YELLOW);  // Umple triunghiul cu galben

        // *************************************************************
		//        Punct 1 (200,200)
		//        ▲
		//       / \
		//      /   \
		//     /     \
		//    /       \
		//   ◄─────────►
		//Punct 3     Punct 2
		//(200,300)   (300,300)
        // *************************************************************
        
        
        // Acum facem un cerc
        Circle circle = new Circle();            // Creezi cercul

        circle.setCenterX(350);                  // X = coordonata centrului
        circle.setCenterY(350);                  // Y = coordonata centrului
        circle.setRadius(50);                    // Raza = 50 pixeli
        circle.setFill(Color.ORANGE);           // Culoare: portocaliu

		//        y ↑
		//        │
		//        │
		//  (350,350)   ◄── centru cerc
		//     ●
		//  ◜     ◝
		// ◜       ◝       ◄── rază: 50px în toate direcțiile
		//  ◝     ◜
		//     *
		//        └────────────→ x
        
        
        // Iar acum daca am avea o poza png in src folder
        Image image = new Image("pizza.png");                    // Încarcă imaginea
        ImageView imageView = new ImageView(image);              // Creează obiect vizual pentru imagine
        imageView.setX(400);                                     // Poziționează pe axa X
        imageView.setY(400);                                     // Poziționează pe axa Y

        //        (0,0) ─────────────────────────▶ X
		//        │
		//        │
		//        │           🖼️ pizza.png
		//        │           [ imagine aici ]
		//        │             (400, 400)
		//        ▼
		//        Y

        
        
        
        // Group root = new Group();        // Creezi cutia
        // Text text = new Text();          // Creezi o piesă (ex: un text)
        root.getChildren().add(text);    // O pui în cutie = se va vedea pe ecran
        root.getChildren().add(line); //ACUM trebe si Line sa hinzufügen in root, ca sa apara. 
        root.getChildren().add(rectangle);
        root.getChildren().add(triangle);
        root.getChildren().add(circle);
        root.getChildren().add(imageView);
        stage.setScene(scene);
        stage.show();
    }
}
