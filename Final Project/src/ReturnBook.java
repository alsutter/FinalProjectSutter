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

		JTextPane txtWhatBook = new JTextPane();
		txtWhatBook.setEditable(false);
		txtWhatBook.setBackground(Color.LIGHT_GRAY);
		txtWhatBook.setToolTipText("");
		txtWhatBook.setText("What book is being returned?");
		txtWhatBook.setBounds(125, 17, 191, 16);
		frame.getContentPane().add(txtWhatBook);

		txtBook = new JTextField();
		txtBook.setToolTipText("Type book number");
		txtBook.setText("Book Number");
		txtBook.setBounds(38, 45, 130, 26);
		frame.getContentPane().add(txtBook);
		txtBook.setColumns(10);

		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBook.setText(txtBook.getText()); // set new text
				int bookNumber;
				bookNumber = Integer.parseInt(txtBook.getText()); // parse into an integer
				Library.library[bookNumber].setStatus(true);
			}
		});
		btnEnter.setToolTipText("Enter Data");
		btnEnter.setBounds(280, 45, 117, 29);
		frame.getContentPane().add(btnEnter);

		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setEditable(false);
		textPane.setBounds(43, 130, 354, 118);
		frame.getContentPane().add(textPane);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
