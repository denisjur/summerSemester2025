package superr;

public class Student extends Person { 
    // ← Această clasă Student a moștenit atributele din clasa părinte Person
    //    Student inherits the attributes of the super class (= parent class)

    double Notendurchschnitt;

    Student(String first, String last, double Notendurchschnitt) {

        // Nu putem scrie aici: 
    	// this.first = first; sau this.last = last;
        // De ce? Pentru că aceste câmpuri (atribute) se află în clasa părinte (Person),
        // iar ele nu sunt accesibile direct în constructorul copilului în acest caz.

        // Clasa Person are un constructor care primește argumentele first și last.
        // Dacă nu îi trimitem aceste argumente, numele nu vor fi inițializate corect.

        // Așadar, trebuie să apelăm constructorul părintelui și să îi trimitem valorile:
        // Pentru asta folosim cuvântul cheie super:

        super(first, last);

        this.Notendurchschnitt = Notendurchschnitt; // ← atribut specific Student
    }
}
