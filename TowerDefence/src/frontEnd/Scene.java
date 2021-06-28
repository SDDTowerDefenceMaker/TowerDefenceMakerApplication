package frontEnd;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;

import javax.swing.*;

public class Scene extends JPanel implements Runnable{

	private JPanel panel, mg;
	private Thread thread = new Thread(this);
	
	private int worldWidth, worldHeight;
	public static int Width, Height;
	public static Image[] tile_grass = new Image[100]; 
	private static Boolean isFirst = true;
	private static Room room;
	
	public Scene(int x, int y) {
		
		worldWidth = x;
		worldHeight = y;
		
		thread.start();
		
		/*panel = new JPanel();
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
	}*/
	}
	
	public void define() {
		room = new Room(worldWidth, worldHeight);
		
		for(int i = 0; i < tile_grass.length; i++) {
			tile_grass[i] = new ImageIcon("resource/grass.jpg").getImage();
		}
	}
	
	public void paintComponent( Graphics g ) {
		if(isFirst) {
			Width = getWidth();
			Height = getHeight();
			define();
			
			isFirst = false;
		}
		
		g.clearRect(0, 0, Width, Height);
		
		room.draw(g);
	}
	
		
	public static int fpsFrame = 0, fps = 1000000;
		
	public void run() {
		while(true) {
				if(!isFirst) {
					
				}
				repaint();
				
				try { 
					Thread.sleep(1);
				}catch(Exception e) {
			}
		}
	}
}
