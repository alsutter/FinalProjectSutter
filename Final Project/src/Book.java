
public class Book {
	private String title;
	private String author;
	private String genre;
	private boolean status = true; //where true means in, and false means out
	
	//constructors
	//Empty book constructor
	public Book() {
		super();
	}
	
	//full book constructor
	/**
	 * @param title of the book
	 * @param author of the book
	 * @param genre of the book
	 * @param status true if in, false if out
	 */
	public Book(String title, String author, String genre, boolean status) {
		super();
		this.setTitle(title);
		this.author = author;
		this.genre = genre;
		this.status = status;
	}
	
	/**
	 * Used to set all the info of a new book
	 * @param title of the book
	 * @param author of the book
	 * @param genre of the book
	 * @param status true if in, false if out
	 */
	public void setInfo(String title, String author, String genre, boolean status){
		this.setTitle(title);
		this.author = author;
		this.genre = genre;
		this.status = status;
	}
	
	/**
	 * Set the status of the book
	 * @param status true if in, false if out
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * Check status of the book
	 * @return status true if in, false if out
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * Get the title of the book
	 * @return title the title of the book
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title of the book
	 * @param title the title of the book
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Book [Title = " + getTitle() + ", Author = " + author + ", Genre = " + genre + ", Status = " + status + "]";
	}

}