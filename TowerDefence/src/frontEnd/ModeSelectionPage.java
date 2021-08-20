package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ModeSelectionPage {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public ModeSelectionPage() {
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
		
		JButton Button_New = new JButton("New Game");
		Button_New.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				EnterMapSize MapSize = new EnterMapSize();
				MapSize.frame.setVisible(true);
			}
		});
		Button_New.setBounds(154, 87, 113, 23);
		frame.getContentPane().add(Button_New);
		
		JButton Button_Load = new JButton("Load Game");
		Button_Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
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
		});
		Button_Load.setBounds(154, 120, 113, 23);
		frame.getContentPane().add(Button_Load);
		
		JButton Button_Test = new JButton("Settings");
		Button_Test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {
					SettingsPage window = new SettingsPage();
					window.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		Button_Test.setBounds(154, 153, 113, 23);
		frame.getContentPane().add(Button_Test);
		
		/*JButton Button_Setup = new JButton("Settings");
		Button_Setup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Button_Setup.setBounds(154, 186, 113, 23);
		frame.getContentPane().add(Button_Setup);*/
		
		JLabel ModeSelectionTitle = new JLabel("Tower Defense Maker");
		ModeSelectionTitle.setHorizontalAlignment(SwingConstants.CENTER);
		ModeSelectionTitle.setFont(new Font("SimSun", Font.BOLD, 24));
		ModeSelectionTitle.setForeground(Color.GRAY);
		ModeSelectionTitle.setBounds(54, 27, 322, 50);
		frame.getContentPane().add(ModeSelectionTitle);
	}
}
