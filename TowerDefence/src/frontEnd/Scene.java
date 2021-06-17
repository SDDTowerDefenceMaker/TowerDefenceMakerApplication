package frontEnd;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Scene extends JPanel{

	private JPanel panel, mg;
	
	
	public Scene() {

		panel = new JPanel();
		panel.setLayout(null);
		JButton startButton = new JButton("Start");
		startButton.setBounds(650, 350, 300, 100); //Let the start button locate at the middle of the screen
    	panel.setBackground(Color.black);
        panel.add(startButton);
        startButton.addActionListener(new ActionListener(){
      		public void actionPerformed(ActionEvent e) {
      			mainGame();
      		}
      	});
	}
	
	public void mainGame() {
		mg = new JPanel();
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
