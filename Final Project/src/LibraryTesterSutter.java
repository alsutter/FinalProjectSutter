/**
 * This project is to keep track of my personal library of books
 * These books are available for rent just like a real library
 * The books are symbolized by an object, and they are stored in an array.
 * There are 30 total books.
 * The use of a list signifies the due dates when someone has a book.
 * @author Annika Sutter
 *
 */

public class LibraryTesterSutter {
	public static void main(String[] args) {
		Book library[]=new Book[30]; //new array of books
		LinkList dueDateList = new LinkList(); //make new list
		int nElems= 0; //number of items
		int j; //loop counter
		
		//create new book for every spot in the array
		for (j=0; j<library.length; j++){
			library[j]=new Book();
		}
		
		//set all info for all the books
		//book 1
		library[0].setInfo("The Hunger Games", "Suzanne Collins", "Science Fiction", true);
		//book 2
		library[1].setInfo("Catching Fire", "Suzanne Collins", "Science Fiction", true);
		//book 3
		library[2].setInfo("Mockingjay", "Suzanne Collins", "Science Fiction", true);
		//book 4
		library[3].setInfo("Hush, Hush", "Becca Fitzpatrick", "Romance", true);
		//book 5
		library[4].setInfo("Crecendo", "Becca Fitzpatrick", "Romance", true);
		//book 6
		library[5].setInfo("Silence", "Becca Fitzpatrick", "Romance", true);
		//book 7
		library[6].setInfo("Finale", "Becca Fitzpatrick", "Romance", true);
		//book 8
		library[7].setInfo("The Fault In Our Stars", "John Green", "Fiction", true);
		//book 9
		library[8].setInfo("Les Miserables", "Victor Hugo", "Histroical Fiction", true);
		//book 10
		library[9].setInfo("The Thousandth Floor", "Katherine McGee", "Science Fiction", true);
		//book 11
		library[10].setInfo("Cinder", "Marissa Meyer", "Science Fiction", true);
		//book 12
		library[11].setInfo("Scarlet", "Marissa Meyer", "Science Fiction", true);
		//book 13
		library[12].setInfo("Cress",  "Marissa Meyer", "Science Fiction", true);
		//book 14
		library[13].setInfo("The Golden Compass", "Philip Pullman", "Fantasy", true);
		//book 15
		library[14].setInfo("The Lost Hero", "Rick Riordan", "Fantasy", true);
		//book 16
		library[15].setInfo("The Son of Neptune", "Rick Riordan", "Fantasy", true);
		//book 17
		library[16].setInfo("The Mark of Athena", "Rick Riordan", "Fantasy", true);
		//book 18
		library[17].setInfo("The House of Hades", "Rick Riordan", "Fantasy", true);
		//book 19
		library[18].setInfo("The Blood of Olympus", "Rick Riordan", "Fantasy", true);
		//book 20
		library[19].setInfo("Divergent", "Veronica Roth", "Science Fiction", true);
		//book 21
		library[20].setInfo("Insurgent", "Veronica Roth", "Science Fiction", true);
		//book 22
		library[21].setInfo("Allegiant", "Veronica Roth", "Science Fiction", true);
		//book 23
		library[22].setInfo("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", true);
		//book 24
		library[23].setInfo("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Fantasy", true);
		//book 25
		library[24].setInfo("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "Fantasy", true);
		//book 26
		library[25].setInfo("Harry Potter and the Goblet of Fire", "J.K. Rowling", "Fantasy", true);
		//book 27
		library[26].setInfo("Harry Potter and the Order of the Pheonix", "J.K. Rowling", "Fantasy", true);
		//book 28
		library[27].setInfo("Harry Potter and the Half-Blood Prince", "J.K. Rowling", "Fantasy", true);
		//book 29
		library[28].setInfo("Harry Potter and the Deathly Hallows", "J.K. Rowling", "Fantasy", true);
		//book 30
		library[29].setInfo("The Book Theif", "Markus Zusak", "Fiction", true);

		nElems = 30;
	
		
		dueDateList.insertFirst("Stephanie Stocks", library[13].getTitle(), 41718);
		library[13].setStatus(false);
		dueDateList.insertFirst("Grace Riess", library[9].getTitle(), 41318);
		library[9].setStatus(false);
		dueDateList.insertFirst("Becca Cole", library[29].getTitle(), 4418);
		library[29].setStatus(false);
		dueDateList.displayList();
		
		for (j=0; j<nElems; j++){
			System.out.println(library[j]);
			System.out.println();
		}
		
	}
	
	
	
}
