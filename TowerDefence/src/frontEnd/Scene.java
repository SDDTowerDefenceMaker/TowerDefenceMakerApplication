package frontEnd;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;

import javax.swing.*;

import backEnd.*;

public class Scene extends JPanel implements Runnable{

	private JPanel panel, mg;
	private Thread thread = new Thread(this);
	
	private int worldWidth, worldHeight;
	private String filename;
	public static int Width, Height;
	public static Point mse = new Point(0, 0);
	
	public static Image[] tile_grass = new Image[100]; 
	public static Image[] tile_road = new Image[100];
	
	private static Boolean isFirst = true;
	public static Room room;
	public static Map map;
	Tile[][] tiles;
	public static SL sl;
	public static Menu menu;
	
	public Scene(GUI frame, int x, int y) {
		
		worldWidth = x;
		worldHeight = y;
		
		frame.addMouseListener(new MseListener());
		frame.addMouseMotionListener(new MseListener());
		
		thread.start();
		
	}
	
	public Scene(Load frame, String f) {
		
		filename = f;
		
		frame.addMouseListener(new MseListener());
		frame.addMouseMotionListener(new MseListener());
		
		thread.start();
	}
	
	
	public void define() {
		try {
			map = new Map(worldWidth, worldHeight);
		}catch(Exception e) {
			map = new Map(filename);
		}
		
		tiles = map.getMap();
		room = new Room(tiles);
		menu = new Menu();
		
		for(int i = 0; i < tile_grass.length; i++) {
			tile_grass[i] = new ImageIcon("resource/grass.jpg").getImage();
		}
		
		for(int i = 0; i < tile_road.length; i++) {
			tile_road[i] = new ImageIcon("resource/road.jpg").getImage();
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
		menu.draw(g);
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
