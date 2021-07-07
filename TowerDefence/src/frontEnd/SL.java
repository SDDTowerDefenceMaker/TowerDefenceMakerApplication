package frontEnd;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

import backEnd.Map;
import backEnd.Tile;

public class SL extends JPanel implements Runnable{
	public static int Width, Height;
	public Tile[][] tile;
	public static Room room;
	public String filename;
	public Menu menu;
	private Thread thread = new Thread(this);
	
	private static Boolean isFirst = true;
	

	public SL(Load frame, String f) {
		filename = f;
		
		frame.addMouseListener(new MseListener());
		frame.addMouseMotionListener(new MseListener());
		
		thread.start();
	}
	
	
	public void loadGame(String f) {
	}
	
	public void define() {
		Map map = new Map(filename);
		tile = map.getMap();
		room = new Room(tile);
		menu = new Menu();
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
