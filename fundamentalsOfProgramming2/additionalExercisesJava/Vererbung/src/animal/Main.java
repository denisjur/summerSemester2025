package animal;

public class Main {
	 public static void main(String[] args) {

	        // Inheritance = One class inherits the attributes and methods
	        //               from another class.
	        //               Child <- Parent.
		 	
			// Dabei haben Kindklassen unterschiedliche Eigenschaften, 
			// aber sie teilen sich alle die Eigenschaften der Elternklassen.
			// Die Elternklassen erben wiederum von Großelternklassen usw.

	        Dog dog = new Dog();
	        Cat cat = new Cat();

	        System.out.println(dog.isAlive); 
			// Acum, deși în clasa Dog sau Cat nu e scris nimic,
			// totuși ne arată "true", pentru că a moștenit TOTUL de la clasa Animal (părinți)

	        System.out.println(cat.isAlive); 
			// Iar clasa Animal – adică părintele – a moștenit totul de la clasa Organism (bunici)

	        System.out.println(dog.lives);
	        System.out.println(cat.lives);
	        
	        dog.speak();
	        cat.speak();
	        
	        /* OUTPUT: --------------------------------------------------------------------------------------
	        
	         	true
        		true
        		
        		1
        		9
        		
        		The dog goes *woof*
        		The cat goes *meow*
	         
	         -----------------------------------------------------------------------------------------------*/
	 
	 }
}
