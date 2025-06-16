package aggregation;

public class Library {
	
	String name;
	int year;
	Book[] books;
	
	Library(String name, int year, Book[] books) {
		this.name = name;
		this.year = year;
		this.books = books;
	}
	
	void displayInfo() {
		System.out.println("The " + this.year + " " + this.name);
		System.out.println("Books Available: ");
		//Display each book independently: Use the for loop
				for(Book book : books) {
					System.out.println(book.displayInfo());
				}
				//Output of for loop: 
				// The Fellow of the Ring (432 pages)
				// The Two Towers (352 pages)
				// The Return of the King (416 pages)
	}
	
}
