/**
 * This is meant to be used with the Book, Library, CheckOutBook, ReturnBook,
 * ViewLibrary and Link classes This is used to insert due dates, patrons, and
 * books and print all information
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

	/**
	 * @param patron
	 *            who has the book
	 * @param title
	 *            what book
	 * @param date
	 *            that it is due
	 */
	public void insertFirst(String patron, String title, long date) {// insert at start of list
		Link newLink = new Link(patron, title, date); // make new link
		newLink.next = first; // newLink --> old first
		first = newLink; // first --> newLink
	}

	/**
	 * @param position
	 *            of the item to be deleted
	 * @return temp deleted link
	 */
	public void deleteItem(int position) { // delete specific item
		// If linked list is empty
		if (first == null)
			return;

		// Store head node
		Link temp = first;

		// If head needs to be removed
		if (position == 0) {
			first = temp.next; // Change head
			return;
		}

		// Find previous node of the node to be deleted
		for (int i = 0; temp != null && i < position - 1; i++)
			temp = temp.next;

		// If position is more than number of nodes
		if (temp == null || temp.next == null)
			return;

		// Node temp->next is the node to be deleted
		// Store pointer to the next of node to be deleted
		Link next = temp.next.next;

		temp.next = next; // Unlink the deleted node from list
	}

	/**
	 * @return fullDueDate header for the linked list
	 * 
	 */
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
