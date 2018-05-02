
/**
 * The ReturnBook class is meant to be used with the Book, Library, 
 * Link, LinkList, CheckOutBook, and ViewLibrary classes. This features 2 text boxes and 2 enter buttons. 
 * The second one will be grayed out until appropriate input is in the first one. 
 * Enter the information prompted for and the status of the book requested will change.
 * 
 * @author Annika Sutter
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnBook {

	private JFrame frame;
	private JTextField txtItem;
	int bookNumber;
	private JTextField txtBookNumber;

	/**
	 * Launch the application.
	 */
	public static void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook window = new ReturnBook();
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
	public ReturnBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);

		// results text box
		JTextPane txtReturn = new JTextPane();
		txtReturn.setBackground(Color.LIGHT_GRAY);
		txtReturn.setEditable(false);
		txtReturn.setBounds(43, 164, 354, 84);
		frame.getContentPane().add(txtReturn);

		// Book number text box
		JTextPane txtBook = new JTextPane();
		txtBook.setBackground(Color.LIGHT_GRAY);
		txtBook.setEditable(false);
		txtBook.setText("What is the book number?");
		txtBook.setBounds(145, 83, 179, 16);
		frame.getContentPane().add(txtBook);

		// book number button and listener
		JButton btnNumberEnter = new JButton("Enter");
		btnNumberEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookNumber = Integer.parseInt(txtBookNumber.getText()); // parse into an integer
				Library.library[bookNumber].setStatus(true);
				txtReturn.setText("Book '" + Library.library[bookNumber].getTitle() + "' was successfully returned.");
			}
		});

		// create bookNumber field
		txtBookNumber = new JTextField();
		txtBookNumber.setEnabled(false);
		txtBookNumber.setToolTipText("Number of the book that is being returned");
		txtBookNumber.setText("Book Number");
		txtBookNumber.setBounds(6, 113, 130, 26);
		frame.getContentPane().add(txtBookNumber);
		txtBookNumber.setColumns(10);
		btnNumberEnter.setEnabled(false);
		btnNumberEnter.setBounds(327, 111, 117, 29);
		frame.getContentPane().add(btnNumberEnter);

		// instructions for what book
		JTextPane txtWhatBook = new JTextPane();
		txtWhatBook.setEditable(false);
		txtWhatBook.setBackground(Color.LIGHT_GRAY);
		txtWhatBook.setToolTipText("");
		txtWhatBook.setText("Enter the due date list position that is being returned");
		txtWhatBook.setBounds(65, 17, 343, 16);
		frame.getContentPane().add(txtWhatBook);

		// text box for entry
		txtItem = new JTextField();
		txtItem.setToolTipText("Type book number");
		txtItem.setText("Position (1, 2, 3... etc)");
		txtItem.setBounds(6, 45, 169, 26);
		frame.getContentPane().add(txtItem);
		txtItem.setColumns(10);

		// button and listeners
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtItem.setText(txtItem.getText()); // set new text
				int linkNumber;
				linkNumber = Integer.parseInt(txtItem.getText()); // parse into an integer
				CheckOutBook.dueDateList.deleteItem(linkNumber);
				btnNumberEnter.setEnabled(true);
				txtBookNumber.setEnabled(true);
			}
		});
		btnEnter.setToolTipText("Enter Data");
		btnEnter.setBounds(327, 45, 117, 29);
		frame.getContentPane().add(btnEnter);

		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
