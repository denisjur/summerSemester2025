package GettersSetters;

public class Car {

	// Here in the car objects, all the atributes are public accesible. Meaning, we can
	// change them easily. Daca scriem in main-java-file car.model = "Corvette", lam
	// schimbat in corvette.
	// Dar daca scriem private inainte de variable nu mai le putem schimba.

	private final String model; // <-- Daca chair nu vrei sa poata nimeni schimba, scrii final
	private String color;
	private int price;

	Car(String model, String color, int price) {
		this.model = model;
		this.color = color;
		this.price = price;
	}

	// Dar prin Getters si Setters putem sa umgehen sperrele de private. Normal nu
	// leam putea accesa.
	// Acum cream Getter ca sa putem umgehen private si sa citim ce scrie inauntu:
	String getModel() {
		return this.model;
	}

	String getColor() {
		return this.color;
	}

	// Daca vrem sa primim un Sring in loc de integer, scriem asa:
	String getPrice() {
		return String.valueOf(this.price);
	}

	// Acum cream niste functii, ca sa putem sa le ändern, modelul ramane aber
	// unveränderbar.
	void setColor(String color) {
		this.color = color;
	}

	void setPrice(int price) {
		this.price = price;
	}

}
