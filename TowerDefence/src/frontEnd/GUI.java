package frontEnd;

import javax.swing.*;


import java.awt.*;

public class GUI extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4942312225590095708L;
	public static int width = 1600;
	public static int height = 900;
	JFrame frame;
	
	/**
	 * create the game window
	 */
    public GUI(int x, int y) {
    	int screen_height = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
    	if (screen_height == 720) {
			height = 540;
			width = 960;
		}
    	if (screen_height == 900) {
			height = 720;
			width = 1280;
		}
    	if (screen_height >= 1080) {
			height = 900;
			width = 1600;
		}
    	setTitle("Tower Defence Maker");
    	setSize(new Dimension(width, height));
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	init(x, y);
    	
    }
    /**
     * 
     * @param x the width of the map
     * @param y the height of the map
     * @effect initialize the game interface
     */
    public void init(int x, int y) {
    	
    	setLayout(new GridLayout(1,1,0,0));
    	
    	Scene scene = new Scene(this, x, y);
    	add(scene);
    	
    	setVisible(true);
    	
    }
    

	

}
