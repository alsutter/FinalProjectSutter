/**
 * This is meant to be used with the Book, Library, LibraryTesterSutter and Link
 * classes This is used to insert due dates, patrons, and books and print all
 * information
 * 
 * @author Annika Sutter
 */
public class LinkList {
	private Link first; // reference to first link on list

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

	public void displayList() {
		System.out.println("List (first --> last): ");
		Link current = first; // start at beginning of list
		while (current != null) { // until end of list
			current.displayLink(); // print data
			current = current.next; // move to next link
		}
		System.out.println("");
	}

}
