package variableScope;

import java.util.Random;

public class DiceRoller {
	//Ce am face in mod normal:
//	DiceRoller() {
//		Random random = new Random(); // <-- local varibles
//		int number = 0;
//		roll(random, number);
//	}
//	
//	void roll(Random random, int number) {
//		number = random.nextInt(6) +1; // +1 because if we use 6, it only goes from 0 to 5
//		System.out.println(number);
//	}
	
	// Dar acum declaram global:
		
	Random random; // <-- global variables
	int number;
		
	DiceRoller() {
		random = new Random();
		int number = 0;
		roll();
	}
	
	void roll() {
		number = random.nextInt(6) +1; // +1 because if we use 6, it only goes from 0 to 5
		System.out.println(number);
	}
}
