package frontEnd;

import java.awt.*;
import java.io.*;
import javax.swing.*;

import backEnd.Map;


public class Load extends JFrame{
	
	public static int width = 1600;
	public static int height = 900;
	public File file;
	static JFrame frame;
	public SL load;
	
	public Load(String filename) {
		setTitle("Tower Defence Maker");
    	setSize(new Dimension(width, height));
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	init(filename);
	}
	
	public void init(String filename) {
		setLayout(new GridLayout(1,1,0,0));
		Map map = new Map(filename);
		file = new File(filename);
    	Scene screen = new Scene(this, map.getMaxX(), map.getMaxY());
    	screen.define(map);
    	add(screen);
		setVisible(true);
	}
	
	public Load() {
		setTitle("Tower Defence Maker");
    	setSize(new Dimension(width, height));
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	init();
	}
	
	public void init() {
		setLayout(new GridLayout(1,1,0,0));
		file = new File("data/map.txt");
		load = new SL();
		load.loadSize(file);
    	Scene screen = new Scene(this, load.worldWidth, load.worldHeight);
    	add(screen);
    	load.loadGame(file);
		setVisible(true);
	}
	
}
