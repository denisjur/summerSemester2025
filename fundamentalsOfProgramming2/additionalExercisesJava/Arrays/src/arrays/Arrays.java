package arrays;

public class Arrays {
	public static void main(String[] args) {
		
		// Array = used to store multiple values in a single variable
			String car = "Camaro";
			String[] cars =  {"Camaro", "Tesla", "Lamborghini", "BMW"}; //IMPORTANT Data Types need to be equal!!!
			
			//How to acces elements?
			
			cars[0] ="Bumble-Bee"; // Camaro geändert zu Bumble-Bee
			System.out.println(cars[1]);
			
			
				// Additional way of writing arrays:
				String[] planes = new String[3];	//IMPORTANT Aici spunem cate arrays vrem sa avem
				
				planes[0] = "Flughansa";
				planes[1] = "Airbus";
				planes[2] = "WizzAir";
				
				// This is how we can itterate through all the elements of an array:
				for(int i = 0;  i<planes.length; i++) { //IMPORTANT .length spune cat de lung e array-ul
					System.out.println(cars[i]);
		
		
		
		// 2D-Arrays = an array of arrays. It is like having lines and columns
			String[][] cars2 = new String [3][3];
			
			cars2 [0][0]    = "Camaro";
			cars2 [0][1]	= "BMW";
			cars2 [0][2]	= "Lamborghini";
			cars2 [1][0]	= "Ferrari";
			cars2 [1][1]	= "Audi";
			cars2 [1][2]	= "Mustang";
			cars2 [2][0]	= "Tumbler";
			cars2 [2][1]	= "Ranger";
			cars2 [2][2]	= "Raptor";
		
		// Now let us list everything using nested loops
			for(int k = 0; k < cars2.length; k++) {
				System.out.println();
				for(int l = 0; l < cars2[k].length ; l++) {
					System.out.print(cars2[k][l] + "\t");
					
				}
				
			}
			
		
		
		
		
		
		
		
		}
		
		
	}
}
