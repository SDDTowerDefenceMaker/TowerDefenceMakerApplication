package frontEnd;

import java.awt.*;
import java.io.*;
import javax.swing.*;

import backEnd.Map;


public class Load extends JFrame{
	
	public static int width = 1600;
	public static int height = 900;
	private int worldWidth, worldHeight;
	public File file;
	static JFrame frame;
	
	public Load(String filename) {
		setTitle("Tower Defence Maker");
    	setSize(new Dimension(width, height));
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	init(filename);
	}
	
	public void init(String filename) {
		setLayout(new GridLayout(1,1,0,0));
    	Scene screen = new Scene(this, filename);
    	add(screen);
		setVisible(true);
	}
	
	/*public Load() {
		setTitle("Tower Defence Maker");
    	setSize(new Dimension(width, height));
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	init();
	}
	
	public void init() {
		setLayout(new GridLayout(1,1,0,0));
		
		String filename = "map.txt";
    	Scene screen = new Scene(this, filename);
    	add(screen);
    	
		setVisible(true);
	}*/
	
	
}
