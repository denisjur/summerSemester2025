package interfaces;

public class Fish implements Predator, Prey{
	@Override
	public void hunt() { // <- becausae it is a public accesible method
		System.out.println("The fish is attacking!");
	}
	
	@Override
	public void flee() { // <- becausae it is a public accesible method
		System.out.println("The fish is swimming away!");
	}
}
