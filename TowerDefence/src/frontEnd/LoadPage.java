package frontEnd;

import java.io.File;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoadPage {

	JFrame frame;
	private JTextField filename;
	private JLabel ErrorMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadPage window = new LoadPage();
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
	public LoadPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		filename = new JTextField();
		filename.setBounds(126, 115, 174, 21);
		frame.getContentPane().add(filename);
		filename.setColumns(10);
		
		JLabel Instruction = new JLabel("Enter File name below");
		Instruction.setBounds(152, 90, 143, 15);
		frame.getContentPane().add(Instruction);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				String UserFilename = filename.getText();
				boolean fileFound = false;
				File f = new File(UserFilename);
				if (f.exists() && f.isFile()) {
					Load map = new Load(UserFilename);
					map.frame.setVisible(true);
					fileFound = true;
				}
				f = new File(UserFilename+".txt");
				if (f.exists() && f.isFile()) {
					Load map = new Load(UserFilename+".txt");
					map.frame.setVisible(true);
					fileFound = true;
				}
				if (!fileFound) {
					ErrorMessage = new JLabel("ERROR: Please enter a valid file name!");
					ErrorMessage.setForeground(Color.RED);
					ErrorMessage.setBounds(110, 10, 243, 15);
					frame.getContentPane().add(ErrorMessage);
				}
			}
		});
		continueButton.setBounds(168, 146, 93, 23);
		frame.getContentPane().add(continueButton);
		
		
	}
}
