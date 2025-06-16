package randomnumbers;

import java.util.Random; //IMPORTANT

public class randomNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			// Sagen wir, wir möchten einen Würfel haben mit bis zu 6 Seiten
			Random random = new Random();
			int x = random.nextInt(6)+1; //IMPORTANT Generiert von 0 - 5. Wir wollen aber 1 bis 6, also schreiben wir hier +1 rein
			System.out.println(x);// 
			
			//Haide sa facem asta si cu boolean spre instance:
			boolean z = random.nextBoolean();
			System.out.println(z);
			
			
	}

}
