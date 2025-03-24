package constructorsoop;

public class Human {

	String name;
	int age;
	double weight;
	
	Human(String name, int age, double weight) { // <- Constructor
			// name = name; // Here we can assign the name we recieve from our main method, and add it to the variable name in this Human class
							// dar name = name nu merge, ca el nu stie ce nume, deci trebe sa folosim this. IMPORTANT
		this.name = name;	//IMPORTANT This se refera la ACESTE VARIABLE DIN CLASA
		this.age = age;
		this.weight = weight;
	}
	
	void eat() {
		System.out.println(this.name + " is eating Tiramisu!🔥");
	}
	
	void drinks() {
		System.out.println(this.name + " drinks soda");
	}
}
