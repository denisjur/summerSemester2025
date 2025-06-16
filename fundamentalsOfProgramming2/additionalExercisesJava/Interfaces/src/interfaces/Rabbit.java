package interfaces;

public class Rabbit implements Prey { // Din cauza ca implementam Prey, trebuie sa implementam si functia lui
		
	@Override
	public void flee() { // <- becausae it is a public accesible method
		System.out.println("The rabbit is running away");
	}

}
