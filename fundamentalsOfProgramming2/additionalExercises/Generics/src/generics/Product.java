package generics;

public class Product<T, U> {
	
	T item;
	U price;
	
	Product(T item, U price) {
	    this.item = item;
	    this.price = price;
	}
	
	
	  // Getter für das Produkt
    public T getItem() {
        return this.item;
    }

    // Getter für den Preis
    public U getPrice() {
        return this.price;
    }

}
