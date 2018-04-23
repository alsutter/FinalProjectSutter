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

public class Library{

	private JFrame frame;
	private JLabel label;
	private JTextField textField;
	private int bookNumber;

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
		//create frame
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY); //change color
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//create label for extra instructions
		JTextPane label = new JTextPane();
		label.setEditable(false);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		label.setBackground(Color.WHITE);
		label.setBounds(144, 194, 158, 66);
		frame.getContentPane().add(label);
		
		//create initial instructions panel
		JTextPane txtpnWelcome = new JTextPane();
		txtpnWelcome.setBounds(114, 6, 235, 101);
		txtpnWelcome.setBackground(Color.LIGHT_GRAY);
		txtpnWelcome.setEditable(false);
		txtpnWelcome.setText("              ---WELCOME--- \n Instructions:\n To access a book, type 'a' \n To check out a book, type 'c' \n To return a book, type 'r' \n To view entire library, type 'v'.");
		frame.getContentPane().add(txtpnWelcome);
		
		//create text field for input
		textField = new JTextField();
		textField.setBounds(124, 127, 206, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(textField.getText());
		
		//create button and button listener for input
		JButton btnClickToEnter = new JButton("Click to enter");
		btnClickToEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("a")) { //if you want to access a book
					label.setText("Please enter the book number"); //print instructions
					textField.setText(""); //clear text box
					textField.setText(textField.getText()); //set new text
					bookNumber = Integer.parseInt(textField.getText()); //parse into an integer
					label.setText(library[bookNumber]); //print book requested
				}
			}
		});
		btnClickToEnter.setBounds(163, 165, 117, 29);
		frame.getContentPane().add(btnClickToEnter);
	}
}
