package frontEnd;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import java.io.File;

import javax.swing.*;

import backEnd.*;

public class Scene extends JPanel implements Runnable{

	private JPanel panel, mg;
	public Thread thread = new Thread(this);
	public static JFrame frame;
	
	private int worldWidth, worldHeight;
	private String filename;
	private Boolean flag = true;
	public static int Width, Height;
	public static Point mse = new Point(0, 0);
	
	public static Image tile_grass; 
	public static Image tile_road;
	public static Image tile_M;
	public static Image tile_base;
	public static Image tile_cave;
	public static Image tile_heart;
	
	private static Boolean isFirst = true;
	public static Room room;
	public static Map map;
	public static SaveButton saveButton;
	Tile[][] tiles;
	public static Menu menu;
	public static Boolean simulate = false;
	
	public static Sprite[] monsters = new Sprite[10];
	
	public Scene(GUI frame, int x, int y) {
		this.frame = frame;
		worldWidth = x;
		worldHeight = y;
		
		frame.addMouseListener(new MseListener());
		frame.addMouseMotionListener(new MseListener());
		
		thread.start();
		
	}
	
	public Scene(Load frame, String f) {
		this.frame = frame;
		filename = f;
		flag = false;
		
		frame.addMouseListener(new MseListener());
		frame.addMouseMotionListener(new MseListener());
		
		thread.start();
	}
	
	
	public void define() {
		setLayout(new GridLayout(1,1,0,0));
		if(flag) {
			map = new Map(worldWidth, worldHeight);
		}else{
			map = new Map(filename);
		}
		saveButton = new SaveButton();
		tiles = map.getMap();
		room = new Room(tiles);
		menu = new Menu();
		for(int i = 0; i < 10; i++) {
			monsters[i] = new Sprite();
		}
		
		
		tile_grass = new ImageIcon("resource/grass.jpg").getImage();
		tile_road = new ImageIcon("resource/road.jpg").getImage();
		tile_base = new ImageIcon("resource/base.png").getImage();
		tile_cave = new ImageIcon("resource/cave.png").getImage();
		tile_heart = new ImageIcon("resource/heart.png").getImage();
		tile_M = new ImageIcon("resource/M.png").getImage();
	}
	
	public void paintComponent( Graphics g ) {
		if(isFirst) {
			Width = getWidth();
			Height = getHeight();
			define();
			
			isFirst = false;
		}

		
		g.clearRect(0, 0, Width, Height);
		
		
		room.draw(g, map);
		for(int i = 0; i < 10; i++) {
			if(monsters[i].start) monsters[i].draw(g);
		}
		
		menu.draw(g, map);
		saveButton.draw(g);
	}
	
		
	public static int spawnTime = 1600, spawnFrame = 0;
		
	public static void monsterCreate() {
		if(spawnFrame >= spawnTime) {
			for(int i = 0; i < 10; i++) {
				if(!monsters[i].start) {
					monsters[i].spawn();
					break;
				}
			}
			spawnFrame = 0;
		}else {
			spawnFrame += 1;
		}
	}
	
	public void run() {
		while(true) {
				if(!isFirst) {
					if(simulate) {
						monsterCreate();
						for(int i = 0; i < 10; i++) {
							if(monsters[i].start) monsters[i].simulate();
						}
					}
					simulate = false;
				}
				repaint();
				
				
				try { 
					Thread.sleep(1);
				}catch(Exception e) {
			}
		}
	}
	
	public static void save() {
		map.export("save_temp.txt");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SavePage window = new SavePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
