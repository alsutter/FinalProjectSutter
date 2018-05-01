/**
 * This is the Book class that is needed for the LibraryTesterSutter, Link,
 * LinkList and Library classes This includes a constructor for an empty book, a
 * constructor for a book with all the information, a method to enter the
 * information, a method to change the in/out status of the book, a method to
 * see the status, a method to get the title of a book, a method to change the
 * title of a book, and finally, a toString method to print all of the
 * information
 * 
 * @author Annika Sutter
 */
public class Book {
	private int number;
	private String title;
	private String author;
	private String genre;
	private boolean status = true; // where true means in, and false means out

	// constructors
	// Empty book constructor
	public Book() {
		super();
	}

	// full book constructor
	/**
	 * @param number
	 *            of the book
	 * @param title
	 *            of the book
	 * @param author
	 *            of the book
	 * @param genre
	 *            of the book
	 * @param status
	 *            true if in, false if out
	 */
	public Book(int number, String title, String author, String genre, boolean status) {
		super();
		this.number = number;
		this.setTitle(title);
		this.author = author;
		this.genre = genre;
		this.status = status;
	}

	/**
	 * Used to set all the info of a new book
	 * 
	 * @param number
	 *            of the book
	 * @param title
	 *            of the book
	 * @param author
	 *            of the book
	 * @param genre
	 *            of the book
	 * @param status
	 *            true if in, false if out
	 */
	public void setInfo(int number, String title, String author, String genre, boolean status) {
		this.number = number;
		this.setTitle(title);
		this.author = author;
		this.genre = genre;
		this.status = status;
	}

	/**
	 * Set the status of the book
	 * 
	 * @param status
	 *            true if in, false if out
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * Check status of the book
	 * 
	 * @return status true if in, false if out
	 */
	public boolean getStatus() {
		return status;
	}

	/**
	 * Get the title of the book
	 * 
	 * @return title the title of the book
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title of the book
	 * 
	 * @param title
	 *            the title of the book
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [Number = " + number + ", Title = " + getTitle() + ", Author = " + author + ", Genre = " + genre
				+ ", Status = " + status + "]";
	}

}
