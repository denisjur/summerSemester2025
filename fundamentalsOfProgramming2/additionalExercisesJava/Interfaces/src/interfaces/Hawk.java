package interfaces;

public class Hawk implements Predator {
	@Override
	public void hunt() { // <- becausae it is a public accesible method
		System.out.println("The hawk is hunting!");
	}
}
