
/**
 * This is the main interface for the LibraryTesterSutter, Link, LinkList,
 * ViewLibrary, CheckOutBook, ReturnBook, and Book classes. When launched, the
 * user can select on of 4 commands, which are Access, Check Out, Return, or
 * View.
 * 
 * Then if needed, more instructions or windows will appear and then execute
 * necessary methods to complete request.
 * 
 * @author Annika Sutter
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Library {
	private JFrame frame;
	private JTextField textField;
	private int bookNumber;
	public static Book library[] = new Book[30]; // new array of books

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
		int j; // loop counter

		// create new book for every spot in the array
		for (j = 0; j < library.length; j++) {
			library[j] = new Book();
		}
		// set all info for all the books
		// book 1
		library[0].setInfo(0, "The Hunger Games", "Suzanne Collins", "Science Fiction", true);
		// book 2
		library[1].setInfo(1, "Catching Fire", "Suzanne Collins", "Science Fiction", true);
		// book 3
		library[2].setInfo(2, "Mockingjay", "Suzanne Collins", "Science Fiction", true);
		// book 4
		library[3].setInfo(3, "Hush, Hush", "Becca Fitzpatrick", "Romance", true);
		// book 5
		library[4].setInfo(4, "Crecendo", "Becca Fitzpatrick", "Romance", true);
		// book 6
		library[5].setInfo(5, "Silence", "Becca Fitzpatrick", "Romance", true);
		// book 7
		library[6].setInfo(6, "Finale", "Becca Fitzpatrick", "Romance", true);
		// book 8
		library[7].setInfo(7, "The Fault In Our Stars", "John Green", "Fiction", true);
		// book 9
		library[8].setInfo(8, "Les Miserables", "Victor Hugo", "Histroical Fiction", true);
		// book 10
		library[9].setInfo(9, "The Thousandth Floor", "Katherine McGee", "Science Fiction", true);
		// book 11
		library[10].setInfo(10, "Cinder", "Marissa Meyer", "Science Fiction", true);
		// book 12
		library[11].setInfo(11, "Scarlet", "Marissa Meyer", "Science Fiction", true);
		// book 13
		library[12].setInfo(12, "Cress", "Marissa Meyer", "Science Fiction", true);
		// book 14
		library[13].setInfo(13, "The Golden Compass", "Philip Pullman", "Fantasy", true);
		// book 15
		library[14].setInfo(14, "The Lost Hero", "Rick Riordan", "Fantasy", true);
		// book 16
		library[15].setInfo(15, "The Son of Neptune", "Rick Riordan", "Fantasy", true);
		// book 17
		library[16].setInfo(16, "The Mark of Athena", "Rick Riordan", "Fantasy", true);
		// book 18
		library[17].setInfo(17, "The House of Hades", "Rick Riordan", "Fantasy", true);
		// book 19
		library[18].setInfo(18, "The Blood of Olympus", "Rick Riordan", "Fantasy", true);
		// book 20
		library[19].setInfo(19, "Divergent", "Veronica Roth", "Science Fiction", true);
		// book 21
		library[20].setInfo(20, "Insurgent", "Veronica Roth", "Science Fiction", true);
		// book 22
		library[21].setInfo(21, "Allegiant", "Veronica Roth", "Science Fiction", true);
		// book 23
		library[22].setInfo(22, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", true);
		// book 24
		library[23].setInfo(23, "Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Fantasy", true);
		// book 25
		library[24].setInfo(24, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "Fantasy", true);
		// book 26
		library[25].setInfo(25, "Harry Potter and the Goblet of Fire", "J.K. Rowling", "Fantasy", true);
		// book 27
		library[26].setInfo(26, "Harry Potter and the Order of the Pheonix", "J.K. Rowling", "Fantasy", true);
		// book 28
		library[27].setInfo(27, "Harry Potter and the Half-Blood Prince", "J.K. Rowling", "Fantasy", true);
		// book 29
		library[28].setInfo(28, "Harry Potter and the Deathly Hallows", "J.K. Rowling", "Fantasy", true);
		// book 30
		library[29].setInfo(29, "The Book Theif", "Markus Zusak", "Fiction", true);

		// create frame
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY); // change color
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// create initial instructions panel
		JTextPane txtpnWelcome = new JTextPane();
		txtpnWelcome.setBounds(125, 6, 196, 86);
		txtpnWelcome.setBackground(Color.LIGHT_GRAY);
		txtpnWelcome.setEditable(false);
		txtpnWelcome
				.setText("--------WELCOME--------\nInstructions:\nSelect a button. \nThen follow additional prompts.");
		frame.getContentPane().add(txtpnWelcome);

		// create label for extra instructions
		JTextPane label = new JTextPane();
		label.setEnabled(false);
		label.setEditable(false);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(25, 120, 415, 78);
		frame.getContentPane().add(label);

		// create text field for input
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setToolTipText("Enter book number here");
		textField.setBounds(112, 218, 235, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(textField.getText());

		// view button and listeners
		JButton btnView = new JButton("View");
		btnView.setToolTipText("View entire library");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent v) {
				ViewLibrary.newWindow(); // open view library window
			}
		});
		btnView.setBounds(6, 96, 117, 29);
		frame.getContentPane().add(btnView);

		// create btnClick
		JButton btnClick = new JButton("Click to enter");
		btnClick.setEnabled(false);
		btnClick.setToolTipText("Click to enter number");
		btnClick.setBounds(170, 243, 117, 29);
		frame.getContentPane().add(btnClick);

		// access button and button listeners
		JButton btnAc = new JButton("Access");
		btnAc.setToolTipText("View a Single Book");
		btnAc.setBounds(327, 96, 117, 29);
		frame.getContentPane().add(btnAc);
		btnAc.addActionListener(new ActionListener() { // create listener
			public void actionPerformed(ActionEvent a) { // button pushed
				label.setEnabled(true); // enable label
				textField.setEnabled(true); // enable text field
				btnClick.setEnabled(true); // enable button
				label.setText("Enter the book number you want to access."); // change label

				// btnClick access listener
				btnClick.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent b) {
						textField.setText(textField.getText()); // set new text
						bookNumber = Integer.parseInt(textField.getText()); // parse into an integer
						if (bookNumber <= 30) {
							label.setText(library[bookNumber].toString()); // print book requested
						} else {
							label.setText("Error, please try again.");
							actionPerformed(b);
						}
					}
				});
			}
		});

		// Check Out button and button listener
		JButton btnChO = new JButton("Check Out");
		btnChO.setToolTipText("Check out a book");
		btnChO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				CheckOutBook.newWindow(); // open check out book window
			}
		});
		btnChO.setBounds(112, 96, 117, 29);
		frame.getContentPane().add(btnChO);

		// return button
		JButton btnRtn = new JButton("Return");
		btnRtn.setToolTipText("Return a book");
		btnRtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent r) {
				ReturnBook.newWindow(); // open return book window
			}
		});
		btnRtn.setBounds(220, 96, 117, 29);
		frame.getContentPane().add(btnRtn);
	}
}
