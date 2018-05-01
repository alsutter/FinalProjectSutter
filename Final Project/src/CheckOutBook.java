import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckOutBook {

	private JFrame frame;
	private JTextField txtPatron;
	private JTextField txtBook;
	private JTextField txtDue;
	private String patron = null;
	private int bookNumber;
	private long date;

	/**
	 * Launch the application.
	 */
	public static void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOutBook window = new CheckOutBook();
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
	public CheckOutBook() {
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
		
		//GUI
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		//results label
		JTextPane results = new JTextPane();
		results.setEditable(false);
		results.setBackground(Color.LIGHT_GRAY);
		results.setBounds(6, 156, 438, 116);
		frame.getContentPane().add(results);
		
		// Instructions for third text box
		JTextPane instDue = new JTextPane();
		instDue.setBackground(Color.LIGHT_GRAY);
		instDue.setEditable(false);
		instDue.setText("Enter Due Date (formatted 012518 for January 25, 2018)");
		instDue.setBounds(6, 106, 369, 16);
		frame.getContentPane().add(instDue);
		
		//Due text box
		txtDue = new JTextField();
		txtDue.setEnabled(false);
		txtDue.setText("Type Here");
		txtDue.setBounds(6, 123, 204, 26);
		frame.getContentPane().add(txtDue);
		txtDue.setColumns(10);
		
		//Due enter button
		JButton btnDue = new JButton("Enter");
		btnDue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent t) {
				txtDue.setText(txtDue.getText()); // set new text
				date = Long.parseLong(txtDue.getText()); // parse into an integer
				if (date >= 0 || date <= 123199) {
					dueDateList.insertFirst(patron, library[bookNumber].getTitle(), date);
					results.setText(dueDateList.displayList());
				} else {
					results.setText("Error, please try again.");
					actionPerformed(t);
				}
			}
		});
		btnDue.setEnabled(false);
		btnDue.setBounds(238, 123, 117, 29);
		frame.getContentPane().add(btnDue);
		
		//Instructions for second text box
		JTextPane instBook = new JTextPane();
		instBook.setEditable(false);
		instBook.setBackground(Color.LIGHT_GRAY);
		instBook.setText("Enter the book number:");
		instBook.setBounds(6, 56, 174, 16);
		frame.getContentPane().add(instBook);
		
		//Book text box
		txtBook = new JTextField();
		txtBook.setEnabled(false);
		txtBook.setBackground(Color.WHITE);
		txtBook.setToolTipText("The number of the book being checked out");
		txtBook.setText("Type Here");
		txtBook.setBounds(6, 73, 204, 26);
		frame.getContentPane().add(txtBook);
		txtBook.setColumns(10);
		
		//book enter button
		JButton btnBook = new JButton("Enter");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent r) {
				txtBook.setText(txtBook.getText()); // set new text
				bookNumber = Integer.parseInt(txtBook.getText()); // parse into an integer
				if (bookNumber <= 30) {
					library[bookNumber].setStatus(false);
					txtDue.setEnabled(true);
					btnDue.setEnabled(true);
				} else {
					results.setText("Error, please try again.");
					actionPerformed(r);
				}
			}
		});
		btnBook.setEnabled(false);
		btnBook.setToolTipText("Enter data");
		btnBook.setBounds(238, 73, 117, 29);
		frame.getContentPane().add(btnBook);
		
		//Instructions for first text box
		JTextPane instPatron = new JTextPane();
		instPatron.setBackground(Color.LIGHT_GRAY);
		instPatron.setToolTipText("Name of who is checking the book out");
		instPatron.setText("Enter name of patron:");
		instPatron.setEditable(false);
		instPatron.setBounds(6, 6, 137, 16);
		frame.getContentPane().add(instPatron);
		
		//first text box
		txtPatron = new JTextField();
		txtPatron.setText("Type Here");
		txtPatron.setToolTipText("Enter name here");
		txtPatron.setBounds(6, 23, 204, 26);
		frame.getContentPane().add(txtPatron);
		txtPatron.setColumns(10);
		
		//patron enter button
		JButton btnPatron = new JButton("Enter");
		btnPatron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPatron.setText(btnPatron.getText()); // set new text
				patron = btnPatron.getText();
				txtBook.setEnabled(true);
				btnBook.setEnabled(true);
			}
		});
		btnPatron.setToolTipText("Enter data");
		btnPatron.setBounds(238, 23, 117, 29);
		
		frame.getContentPane().add(btnPatron);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
