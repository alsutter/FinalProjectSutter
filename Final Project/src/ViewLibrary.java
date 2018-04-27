import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.Caret;

import java.awt.Color;
import javax.swing.JTextArea;

public class ViewLibrary {

	private int i;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLibrary window = new ViewLibrary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewLibrary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea txtAreaView = new JTextArea();
		txtAreaView.setEditable(false);
		txtAreaView.setBounds(0, 0, 450, 278);
		frame.getContentPane().add(txtAreaView);
		//problem
		txtAreaView.setText(print());
	}
	//problem
	public Book print() {
		// first, create all books and enter information
		Book library[] = new Book[30]; // new array of books
		LinkList dueDateList = new LinkList(); // make new list
		int j; // loop counter
		int nElems; // number of books in array

		// create new book for every spot in the array
		for (j = 0; j < library.length; j++) {
			library[j] = new Book();
		}

		// set all info for all the books
		// book 1
		library[0].setInfo("The Hunger Games", "Suzanne Collins", "Science Fiction", true);
		// book 2
		library[1].setInfo("Catching Fire", "Suzanne Collins", "Science Fiction", true);
		// book 3
		library[2].setInfo("Mockingjay", "Suzanne Collins", "Science Fiction", true);
		// book 4
		library[3].setInfo("Hush, Hush", "Becca Fitzpatrick", "Romance", true);
		// book 5
		library[4].setInfo("Crecendo", "Becca Fitzpatrick", "Romance", true);
		// book 6
		library[5].setInfo("Silence", "Becca Fitzpatrick", "Romance", true);
		// book 7
		library[6].setInfo("Finale", "Becca Fitzpatrick", "Romance", true);
		// book 8
		library[7].setInfo("The Fault In Our Stars", "John Green", "Fiction", true);
		// book 9
		library[8].setInfo("Les Miserables", "Victor Hugo", "Histroical Fiction", true);
		// book 10
		library[9].setInfo("The Thousandth Floor", "Katherine McGee", "Science Fiction", true);
		// book 11
		library[10].setInfo("Cinder", "Marissa Meyer", "Science Fiction", true);
		// book 12
		library[11].setInfo("Scarlet", "Marissa Meyer", "Science Fiction", true);
		// book 13
		library[12].setInfo("Cress", "Marissa Meyer", "Science Fiction", true);
		// book 14
		library[13].setInfo("The Golden Compass", "Philip Pullman", "Fantasy", true);
		// book 15
		library[14].setInfo("The Lost Hero", "Rick Riordan", "Fantasy", true);
		// book 16
		library[15].setInfo("The Son of Neptune", "Rick Riordan", "Fantasy", true);
		// book 17
		library[16].setInfo("The Mark of Athena", "Rick Riordan", "Fantasy", true);
		// book 18
		library[17].setInfo("The House of Hades", "Rick Riordan", "Fantasy", true);
		// book 19
		library[18].setInfo("The Blood of Olympus", "Rick Riordan", "Fantasy", true);
		// book 20
		library[19].setInfo("Divergent", "Veronica Roth", "Science Fiction", true);
		// book 21
		library[20].setInfo("Insurgent", "Veronica Roth", "Science Fiction", true);
		// book 22
		library[21].setInfo("Allegiant", "Veronica Roth", "Science Fiction", true);
		// book 23
		library[22].setInfo("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", true);
		// book 24
		library[23].setInfo("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Fantasy", true);
		// book 25
		library[24].setInfo("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "Fantasy", true);
		// book 26
		library[25].setInfo("Harry Potter and the Goblet of Fire", "J.K. Rowling", "Fantasy", true);
		// book 27
		library[26].setInfo("Harry Potter and the Order of the Pheonix", "J.K. Rowling", "Fantasy", true);
		// book 28
		library[27].setInfo("Harry Potter and the Half-Blood Prince", "J.K. Rowling", "Fantasy", true);
		// book 29
		library[28].setInfo("Harry Potter and the Deathly Hallows", "J.K. Rowling", "Fantasy", true);
		// book 30
		library[29].setInfo("The Book Theif", "Markus Zusak", "Fiction", true);

		nElems = 30;

		for (j = 0; j < nElems; j++) {
			return (library[j]);
		}
	}
}
