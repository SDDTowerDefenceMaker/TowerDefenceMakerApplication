package frontEnd;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SavePage {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SavePage window = new SavePage();
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
	public SavePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Tower Defence Maker - Saving");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextField filename = new JTextField();
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
				// File (or directory) with old name
				File file = new File("save_temp.txt");

				// File (or directory) with new name
				File file2 = new File(UserFilename+".txt");

				if (file2.exists()) {
					file2.delete();
				}
				boolean success = file.renameTo(file2);
				if (!success) {
					JOptionPane.showMessageDialog(frame, "ERROR: File not successfully saved!");
				}

				

				
				
			}
		});
		continueButton.setBounds(168, 146, 93, 23);
		frame.getContentPane().add(continueButton);
	}

}
