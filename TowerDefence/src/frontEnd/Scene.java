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
	private Thread thread = new Thread(this);
	private JFrame frame;
	
	private int worldWidth, worldHeight;
	private String filename;
	private Boolean flag = true;
	public static int Width, Height;
	public static Point mse = new Point(0, 0);
	
	public static Image tile_grass; 
	public static Image tile_road;
	
	private static Boolean isFirst = true;
	public static Room room;
	public static Map map;
	public static SaveButton saveButton;
	Tile[][] tiles;
	public static Menu menu;
	
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
		if(flag) {
			map = new Map(worldWidth, worldHeight);
		}else{
			map = new Map(filename);
		}
		saveButton = new SaveButton();
		tiles = map.getMap();
		room = new Room(tiles);
		menu = new Menu();
		
		tile_grass = new ImageIcon("resource/grass.jpg").getImage();
		
		tile_road = new ImageIcon("resource/road.jpg").getImage();
	}
	
	public void paintComponent( Graphics g ) {
		if(isFirst) {
			Width = getWidth();
			Height = getHeight();
			define();
			
			isFirst = false;
//			@SuppressWarnings("unused")
//			Mouse mouse = new Mouse(this);
			/*addMouseListener(new MouseListener() {
				  public void mousePressed(MouseEvent e) {
				  }

				  public void mouseReleased(MouseEvent e) {
					if (SwingUtilities.isRightMouseButton(e))
				    {
						save();
				  
				    }
				  }
				  public void mouseClicked(MouseEvent e) {
				  }

				  public void mouseEntered(MouseEvent e) {
				  }

				  public void mouseExited(MouseEvent e) {
				  }
				  
				});*/
		}

		
		//save();
		g.clearRect(0, 0, Width, Height);
		
		
		room.draw(g, map);
		menu.draw(g, map);
		saveButton.draw(g);
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
	
	public void save() {
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
