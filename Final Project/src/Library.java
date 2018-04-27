import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * This is the interface for the LibraryTesterSutter, Link, LinkList, and Book
 * classes. When launched, a pop-up window will prompt for input. The input can
 * be 'a' for access 'c' for checkout 'r' for return 'v' for view entire library
 * 
 * Then if needed, more instructions will appear and then execute necessary
 * methods to complete request.
 * 
 * @author Annika Sutter
 */
public class Library {

	private JFrame frame;
	private JFrame newFrame;
	private JTextField textField;
	private int bookNumber;
	private int nElems = 0; // number of items

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library window = new Library();
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
	public Library() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// first, create all books and enter information
		Book library[] = new Book[30]; // new array of books
		LinkList dueDateList = new LinkList(); // make new list
		int j; // loop counter

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

		// create frame
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY); // change color
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// create label for extra instructions
		JTextPane label = new JTextPane();
		label.setEditable(false);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		label.setBackground(Color.WHITE);
		label.setBounds(114, 183, 235, 78);
		frame.getContentPane().add(label);

		// create initial instructions panel
		JTextPane txtpnWelcome = new JTextPane();
		txtpnWelcome.setBounds(125, 6, 196, 101);
		txtpnWelcome.setBackground(Color.LIGHT_GRAY);
		txtpnWelcome.setEditable(false);
		txtpnWelcome.setText(
				"--------WELCOME--------\nInstructions:\nTo access a book, type 'a' \nTo check out a book, type 'c'\nTo return a book, type 'r' \nTo view entire library, type 'v'.");
		frame.getContentPane().add(txtpnWelcome);

		// create text field for input
		textField = new JTextField();
		textField.setToolTipText("Enter command here");
		textField.setBounds(114, 119, 235, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(textField.getText());

		// create button and button listener for input
		JButton btnClickToEnter = new JButton("Click to enter");
		btnClickToEnter.addActionListener(new ActionListener() {
			int i;

			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("a")) { // if you want to access a book
					label.setText("Please enter the book number to access"); // print instructions
					textField.setText(null); // clear text box
					// my problem is the next things are looking at the empty text box.
					// do i delete the clear text box, or work my way around it
					// delete clear text box would be quicker
					// but keeping it is more proper
					actionPerformed(e);
					textField.setText(textField.getText()); // set new text
					bookNumber = Integer.parseInt(textField.getText()); // parse into an integer
					if (bookNumber <= 30) {
						label.setText("TEST"); // print book requested
					} else {
						label.setText("Error, please try again.");
						actionPerformed(e);
					}

				} else if (textField.getText().equals("c")) { // if you want to check out a book
					label.setText("Please enter the book number to check out"); // print instructions
					textField.setText(""); // clear text box
					textField.setText(textField.getText()); // set new text
					bookNumber = Integer.parseInt(textField.getText()); // parse into an integer
					// PROBLEM LINE
					library[bookNumber].setStatus(false);
					label.setText("Book number: " + bookNumber + "successfully checked out."); // print instructions
				} else if (textField.getText().equals("r")) { // if you want to return a book
					label.setText("Please enter the book number to return"); // print instructions
					textField.setText(""); // clear text box
					textField.setText(textField.getText()); // set new text
					bookNumber = Integer.parseInt(textField.getText()); // parse into an integer
					library[bookNumber].setStatus(true);
					label.setText("Book number: " + bookNumber + "successfully returned."); // print instructions
				} else if (textField.getText().equals("v")) { // if you want to check out a book
					// create new pop-up
					ViewLibrary newWindow = new ViewLibrary();
					newWindow.newWindow();
				} else {
					label.setText("Error, please restart and try again.");
					textField.setText(null);
				}
			}
		});
		btnClickToEnter.setBounds(173, 142, 117, 29);
		frame.getContentPane().add(btnClickToEnter);
	}
}
