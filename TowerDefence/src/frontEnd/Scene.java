package frontEnd;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import javax.sound.sampled.*;

import backEnd.*;

public class Scene extends JPanel implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4458714366199267285L;
	public Thread thread = new Thread(this);
	public static JFrame frame;
	
	private int worldWidth, worldHeight;
	private String filename;
	private Boolean flag = true;
	public static int Width, Height;
	public static Point mse = new Point(0, 0);
	public static int volume = 0;
	
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
	
	public static Sprite[] monsters = new Sprite[3];
	
	/**
	 * Create the game for New Game
	 * @param frame New Game interface
	 * @param x the width of the map
	 * @param y the height of the map
	 */
	public Scene(GUI frame, int x, int y) {
		Scene.frame = frame;
		worldWidth = x;
		worldHeight = y;
		
		frame.addMouseListener(new MseListener());
		frame.addMouseMotionListener(new MseListener());
		thread.start();
		File audioFile = new File("resource/bgm.wav");
		try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile))
		{
			Clip audioClip = AudioSystem.getClip();
			audioClip.open(audioStream);
			FloatControl gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(volume);
			System.out.println("Audio started");
			audioClip.start();
		}
		catch (IOException | LineUnavailableException | UnsupportedAudioFileException e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Create the game for Load Game
	 * @param frame Load Game interface
	 * @param x the width of the map
	 * @param y the height of the map
	 */
	public Scene(Load frame, String f) {
		Scene.frame = frame;
		filename = f;
		flag = false;
		
		frame.addMouseListener(new MseListener());
		frame.addMouseMotionListener(new MseListener());
		
		thread.start();
		File audioFile = new File("resource/bgm.wav");
		try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile))
		{
			Clip audioClip = AudioSystem.getClip();
			audioClip.open(audioStream);
			FloatControl gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue((volume));
			//System.out.println("Audio started");
			audioClip.start();

		}
		catch (IOException | LineUnavailableException | UnsupportedAudioFileException e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @effect initialize the game elements
	 */
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
		for(int i = 0; i < 3; i++) {
			monsters[i] = new Sprite();
		}
		
		
		tile_grass = new ImageIcon("resource/grass.jpg").getImage();
		tile_road = new ImageIcon("resource/road.jpg").getImage();
		tile_base = new ImageIcon("resource/base.png").getImage();
		tile_cave = new ImageIcon("resource/cave.png").getImage();
		tile_heart = new ImageIcon("resource/heart.png").getImage();
		tile_M = new ImageIcon("resource/M.png").getImage();
		
	}
	
	/**
	 * @effect draw the map, menu, buttons
	 */
	public void paintComponent( Graphics g ) {
		if(isFirst) {
			Width = getWidth();
			Height = getHeight();
			define();
			
			isFirst = false;
		}

		
		g.clearRect(0, 0, Width, Height);
		
		
		room.draw(g, map);
		for(int i = 0; i < 3; i++) {
			if(monsters[i].start) monsters[i].draw(g);
		}
		
		menu.draw(g, map);
		saveButton.draw(g);
	}
	
		
	public static int spawnTime = 1600, spawnFrame = 0;
	
	/**
	 * @effect create monsters
	 */
	public static void monsterCreate() {
		if(spawnFrame >= spawnTime) {
			for(int i = 0; i < 3; i++) {
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
	
	/**
	 * @effect run the thread to keep updating the map
	 */
	public void run() {
		while(true) {
				if(!isFirst) {
					if(simulate) {
						monsterCreate();
						for(int i = 0; i < 3; i++) {
							if(monsters[i].start) monsters[i].simulate();
						}
					}
				}
				repaint();
				
				
				try { 
					Thread.sleep(1);
				}catch(Exception e) {
			}
		}
	}
	
	/**
	 * @effect the save window for save button
	 */
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
