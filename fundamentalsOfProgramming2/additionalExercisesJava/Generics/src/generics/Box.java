package generics;

public class Box<T> { // <-- T means Type. Dar poti sa te gandest i si la "Thing"
					  // Nu stim cine ce va salva daca String, Integer, Boolean etc.
	T item;
	
	// We put something in out box
	// We put the Thing in the variable item
	public void setItem(T item) {
		this.item = item;
	};
	
	// We now take something out of the box
	public T getItem() {
		return this.item;
	};
}
