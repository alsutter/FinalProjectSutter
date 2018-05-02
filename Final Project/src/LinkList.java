/**
 * This is meant to be used with the Book, Library, LibraryTesterSutter and Link
 * classes This is used to insert due dates, patrons, and books and print all
 * information
 * 
 * @author Annika Sutter
 */
public class LinkList {
	private Link first; // reference to first link on list
	private String fullDueDate = "Checked Out: " + "\n";

	public LinkList() { // constructor
		first = null; // no items on list yet
	}

	public boolean isEmpty() { // true if list is empty
		return (first == null);
	}

	public void insertFirst(String patron, String title, long date) {// insert at start of list
		Link newLink = new Link(patron, title, date); // make new link
		newLink.next = first; // newLink --> old first
		first = newLink; // first --> newLink
	}

	public Link deleteFirst() { // delete first item (assumes list isn't empty)
		Link temp = first; // save reference to link
		first = first.next; // delete it: first--> old next
		return temp; // return deleted link
	}

	public String displayList() {
		Link current = first; // start at beginning of list
		fullDueDate = "";
		while (current != null) { // until end of list
			fullDueDate = fullDueDate + current.toString();
			current = current.next; // move to next link
		}
		return fullDueDate;
	}

}
