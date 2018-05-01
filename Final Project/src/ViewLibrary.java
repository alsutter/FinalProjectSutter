
/**
 * This is class is for viewing the entire library. This is only called if the user 
 * presses the view button in the Library class. The class features a method print() 
 * that turns the entire library into a single string
 * @author Annika Sutter
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;

public class ViewLibrary {
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
		frame.setBounds(100, 100, 822, 584);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea txtAreaView = new JTextArea();
		txtAreaView.setBackground(Color.LIGHT_GRAY);
		txtAreaView.setEditable(false);
		txtAreaView.setBounds(0, 0, 822, 556);
		frame.getContentPane().add(txtAreaView);
		txtAreaView.setText(print());
	}

	/**
	 * Creates a string that has all of the library's information on it
	 * 
	 * @return fullView a string of all the information
	 */
	public String print() {
		int j;
		int nElems = 30;
		String view = "";
		String viewFull = "Entire Library:";

		for (j = 0; j < nElems; j++) {
			view = Library.library[j].toString();
			viewFull = viewFull + "\n" + view;
		}
		return viewFull;
	}
}
