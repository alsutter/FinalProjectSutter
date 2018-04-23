
public class Link {
	public String id; //key
	public long dd; //data item
	public Link next; //next link in list
	public String theBook;
	
	/**
	 * @param patron who has the book
	 * @param title of the book
	 * @param date for January 22, 2018, format as 12218 (month, day, year)
	 */
	public Link(String patron, String title, long date) { //constructor
		id = patron; //initialize data
		theBook = title;
		dd = date;//('next is automatically
	} //set to null')
	
	/**
	 * Display links
	 */
	public void displayLink() { //display ourself
		System.out.println("{" + id + ", " + theBook + ", " + dd + "}");
	}
}