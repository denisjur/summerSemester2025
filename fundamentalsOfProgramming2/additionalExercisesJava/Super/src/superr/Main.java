package superr;

public class Main {
	public static void main(String[] args) {

		// super = verweist auf die Elternklasse (Subklasse <- Superklasse)
		// Super inseamna doar Parent
		// Wird in Konstruktoren und beim Überschreiben von Methoden verwendet
		// Warum nutzen wir es?
		// Ruft den Konstruktor der Elternklasse auf, um Attribute zu initialisieren

		Person person = new Person("Bruce", "Wayne");
		person.showName();
		// Output: -------------------------------------------------------------------
		// Bruce Wayne
		// ---------------------------------------------------------------------------
		
		
		Student student = new Student("Alfred", "Pennyworth", 1.0);
		// System.out.println(student.first + " " + student.last);
		student.showName();
		System.out.println(student.Notendurchschnitt);
	}
}
