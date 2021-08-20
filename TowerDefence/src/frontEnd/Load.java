package frontEnd;

import java.awt.*;
import java.io.*;
import javax.swing.*;


public class Load extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7497322639002036607L;
	public static int width = 1600;
	public static int height = 900;
	public File file;
	static JFrame frame;
	
	/**
	 * 
	 * @param filename name of the file needs to be loaded
	 * @effect create the load game interface
	 */
	public Load(String filename) {
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
    	init(filename);
	}
	
	/**
	 * 
	 * @param filename name of the file needs to be loaded
	 * @effect load the map from given file
	 */
	public void init(String filename) {
		setLayout(new GridLayout(1,1,0,0));
		
    	Scene screen = new Scene(this, filename);
    	add(screen);
    	
		setVisible(true);
	}
	
	
}
