package objectsOOP;

public class objectOOP {

	public static void main(String[] args) {
		// object = an instance of a class that may contain attributes(characteristics that an object has) and 
		//			methods(actions an object can perform)
		// example: (phone, desk, computer, coffee cup)

			
				//example of an attributes of a coffee cup(object).
		
		//		Coffee Cup = object
		//		So the the characteristics = attributes:			
		//		+---------------------------------------+			
		//		|               ( (                     |
		//		|                ) )                    |
		//		|             ........                  |
		//		|             |      |]                 |
		//		|             \      /                  |
		//		|              `----'                   |
		//		|                                       |
		//		|   String  color = "white";            |
		//		|   double  temp  = 20.0;               |
		//		|   boolean empty = true;               |
		//		+---------------------------------------+


		
				// example of methods of a coffe cup
		
		// 		So what actions can this perform:
		//		+---------------------------------------------------+
		//		|                   ( (                         	|
		//		|                    ) )                        	|
		//		|                 ........                      	|
		//		|                 |      |]                     	|
		//		|                 \      /                      	|
		//		|                  `----'                       	|
		//		|                                               	|
		//		|   void drink() {                              	|
		//		|       System.out.print("you drink the coffee");	|
		//		|   }                                           	|
		//		|                                               	|
		//		|   void spill() {                              	|
		//		|       System.out.print("you spill the coffee :(");|
		//		|   }                                           	|
		//		+---------------------------------------------------+
		
		
		 	Car myCar = new Car(); // <-- Das echte Objekt wird erstellt
		    myCar.drive();
		    myCar.brake();
		    System.out.println(myCar.model); //Wir listen hier beispielsweise einen Attribut
		    
		    
		    //Haide sa mai facem o masina, al doilea objekt adevarat
		    Car myCar2 = new Car();
		    System.out.println(myCar2.make);
		    
	}
	
	

}
