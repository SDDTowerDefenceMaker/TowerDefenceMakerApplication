package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;

public class LoginPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Tower Defence Maker - Login");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextField UserUsername = new JTextField();
		UserUsername.setBounds(198, 85, 133, 21);
		frame.getContentPane().add(UserUsername);
		UserUsername.setColumns(10);
		
		JLabel Lable_Username = new JLabel("Username");
		Lable_Username.setBounds(110, 88, 70, 15);
		frame.getContentPane().add(Lable_Username);
		
		JLabel Lable_Password = new JLabel("Password");
		Lable_Password.setBounds(110, 126, 70, 15);
		frame.getContentPane().add(Lable_Password);
		
		JPasswordField UserPassword = new JPasswordField();
		UserPassword.setBounds(198, 123, 133, 21);
		frame.getContentPane().add(UserPassword);
		
		JButton Button_Login = new JButton("Login");
		Button_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*************************************************
				 **** uncomment when database is implemented *****
				 *************************************************/
				// String username = UserUsername.getText();
				// @SuppressWarnings("deprecation")
				// String password = UserPassword.getText();
				// if (certified(username,password)) {
				
				
				if (true) {
					frame.dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								ModeSelectionPage window = new ModeSelectionPage();
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				
				//else {
					
				//}
			}
		});
		Button_Login.setBounds(110, 171, 93, 23);
		frame.getContentPane().add(Button_Login);
		
		JButton Button_SignUp = new JButton("Sign Up");
		Button_SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					java.awt.Desktop.getDesktop().browse(new java.net.URI("http://towerdm.com/"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Button_SignUp.setBounds(238, 171, 93, 23);
		frame.getContentPane().add(Button_SignUp);
	}
}
