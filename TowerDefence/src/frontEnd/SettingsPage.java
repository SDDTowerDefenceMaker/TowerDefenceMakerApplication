package frontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SettingsPage {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettingsPage window = new SettingsPage();
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
	public SettingsPage() {
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
		
		JLabel vol = new JLabel("Music Volume");
		vol.setBounds(69, 113, 109, 26);
		frame.getContentPane().add(vol);
		
		JSlider slider = new JSlider();
		slider.setMinimum(-96);
		slider.setMaximum(6);
		slider.setBounds(168, 113, 200, 26);
		slider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
	              Scene.volume = slider.getValue();
	    }});
		frame.getContentPane().add(slider);
		
		JButton CfmBtn = new JButton("Confirm");
		CfmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					ModeSelectionPage window = new ModeSelectionPage();
					window.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		CfmBtn.setBounds(168, 181, 93, 23);
		frame.getContentPane().add(CfmBtn);
	}
}
