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
	LinkList dueDateList = new LinkList(); // make new list

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

		// GUI
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);

		// results label
		JTextPane results = new JTextPane();
		results.setEditable(false);
		results.setBackground(Color.LIGHT_GRAY);
		results.setBounds(6, 156, 438, 116);
		frame.getContentPane().add(results);

		// Instructions for due text box
		JTextPane instDue = new JTextPane();
		instDue.setBackground(Color.LIGHT_GRAY);
		instDue.setEditable(false);
		instDue.setText("Enter Due Date (formatted 012518 for January 25, 2018)");
		instDue.setBounds(6, 106, 369, 16);
		frame.getContentPane().add(instDue);

		// Due text box
		txtDue = new JTextField();
		txtDue.setEnabled(false);
		txtDue.setText("Type Here");
		txtDue.setBounds(6, 123, 204, 26);
		frame.getContentPane().add(txtDue);
		txtDue.setColumns(10);

		// Due enter button
		JButton btnDue = new JButton("Enter");
		results.setText("");
		btnDue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent t) {
				txtDue.setText(txtDue.getText()); // set new text
				date = Long.parseLong(txtDue.getText()); // parse into an integer
				if (date >= 0 || date <= 123199) {
					dueDateList.insertFirst(patron, Library.library[bookNumber].getTitle(), date);
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

		// Instructions for book number text box
		JTextPane instBook = new JTextPane();
		instBook.setEditable(false);
		instBook.setBackground(Color.LIGHT_GRAY);
		instBook.setText("Enter the book number:");
		instBook.setBounds(6, 56, 174, 16);
		frame.getContentPane().add(instBook);

		// Book text box
		txtBook = new JTextField();
		txtBook.setEnabled(false);
		txtBook.setBackground(Color.WHITE);
		txtBook.setToolTipText("The number of the book being checked out");
		txtBook.setText("Type Here");
		txtBook.setBounds(6, 73, 204, 26);
		frame.getContentPane().add(txtBook);
		txtBook.setColumns(10);

		// book enter button
		JButton btnBook = new JButton("Enter");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent r) {
				txtBook.setText(txtBook.getText()); // set new text
				bookNumber = Integer.parseInt(txtBook.getText()); // parse into an integer
				if (bookNumber <= 30) {
					Library.library[bookNumber].setStatus(false);
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

		// Instructions for patron text box
		JTextPane instPatron = new JTextPane();
		instPatron.setBackground(Color.LIGHT_GRAY);
		instPatron.setToolTipText("Name of who is checking the book out");
		instPatron.setText("Enter name of patron:");
		instPatron.setEditable(false);
		instPatron.setBounds(6, 6, 137, 16);
		frame.getContentPane().add(instPatron);

		// first text box
		txtPatron = new JTextField();
		txtPatron.setText("Type Here");
		txtPatron.setToolTipText("Enter name here");
		txtPatron.setBounds(6, 23, 204, 26);
		frame.getContentPane().add(txtPatron);
		txtPatron.setColumns(10);

		// patron enter button
		JButton btnPatron = new JButton("Enter");
		btnPatron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				results.setText("");
				txtPatron.setText(txtPatron.getText()); // set new text
				patron = txtPatron.getText();
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
