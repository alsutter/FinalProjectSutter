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
	private JTextField txtBook;

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

		//results text box
		JTextPane txtReturn = new JTextPane();
		txtReturn.setBackground(Color.LIGHT_GRAY);
		txtReturn.setEditable(false);
		txtReturn.setBounds(43, 130, 354, 118);
		frame.getContentPane().add(txtReturn);
		
		//instructions for what book
		JTextPane txtWhatBook = new JTextPane();
		txtWhatBook.setEditable(false);
		txtWhatBook.setBackground(Color.LIGHT_GRAY);
		txtWhatBook.setToolTipText("");
		txtWhatBook.setText("Enter the due date list position that is being returned");
		txtWhatBook.setBounds(65, 17, 343, 16);
		frame.getContentPane().add(txtWhatBook);
		
		//text box for entry
		txtBook = new JTextField();
		txtBook.setToolTipText("Type book number");
		txtBook.setText("Position (1, 2, 3... etc)");
		txtBook.setBounds(6, 45, 169, 26);
		frame.getContentPane().add(txtBook);
		txtBook.setColumns(10);

		//button and listeners
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBook.setText(txtBook.getText()); // set new text
				int linkNumber;
				linkNumber = Integer.parseInt(txtBook.getText()); // parse into an integer
				//Library.library[bookNumber].setStatus(true);
				CheckedOutBook.dueDateList.deleteItem(linkNumber);
				txtReturn.setText("Book " + Library.library[bookNumber].getTitle() + " was successfully returned.");
			}
		});
		btnEnter.setToolTipText("Enter Data");
		btnEnter.setBounds(327, 45, 117, 29);
		frame.getContentPane().add(btnEnter);
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
