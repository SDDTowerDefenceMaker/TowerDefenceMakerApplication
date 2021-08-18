package frontEnd;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import backEnd.Map;
import backEnd.Material;
import backEnd.MonsterCave;
import backEnd.Tile;
import backEnd.Path;

public class Menu {
	private static int itemNum = 8;
	private static int itemSize = 64;
	private static int iconSize = 48;
	private int worldWidth = Scene.room.worldWidth;
	private int worldHeight = Scene.room.worldHeight;
	private int tileSize = Scene.room.tileSize;
	private int currentX[] = new int[worldWidth*worldHeight];
	private int currentY[] = new int[worldWidth*worldHeight];
	private int M = 0;
	private int base = 1;
	private MonsterCave cave;
	
	public static int hold = -1;
	
	public Path monster_path;
	public int path_num = 0;
	
	public Rectangle[] items = new Rectangle[itemNum];
	public Rectangle[] health = new Rectangle[3];
	public int max_health = health.length;
	public Tile[] itemList = {new Tile(new Material("material"), "resource/grass.jpg"), new Tile(new Material("material"), "resource/road.jpg"), new Tile(new Material("base"), "resource/base.png")
			, new Tile(new Material("monstercave"), "resource/cave.png"), new Tile(new Material("material"), "resource/M.png"),  new Tile(new Material("material"), "resource/heart.png")};
	
	public int flag = 0;
	
	public Menu() {
		define();
	}
	
	public void define() {
		for(int i = 0; i < itemNum; i++) {
			if (Scene.room.tileSize != 96) {itemSize = Scene.room.tileSize*2/3;}
			items[i] = new Rectangle(Scene.Width - itemSize - 2, (itemSize + 2)*i + 2, itemSize, itemSize);
		}
		for(int i = 0; i < health.length; i++) {
			health[i] = new Rectangle((iconSize + 2)*i+2, Scene.Height - iconSize - 2, iconSize, iconSize);
		}
		
	}
	

	public void click(int item) {
		if(item == 1) {
			for(int i = 0; i< itemNum; i++) {
				if(items[i].contains(Scene.mse)) {
					hold = i;
					flag = 1;
				}
			}
			if(hold != -1) {
				for(int i = 0; i < Scene.room.block.length; i++) {
					for(int j = 0; j < Scene.room.block[0].length; j++) {
						if(Scene.room.block[i][j].contains(Scene.mse)) {
							if(hold == 1) {
								try{
									if(Scene.map.addPathToCave(i, j, 0)) path_num++;
									else continue;
								}catch(Exception e) {
									JOptionPane.showMessageDialog(Scene.frame, "ERROR: Please place a monster cave first!");
									continue;
								}
							}
							if(hold == 2) {
								
							}
							if(hold == 3) {
								Scene.map.addMonsterCave(i, j, itemList[hold].getType());
								Scene.map.addPathToCave(i, j, 0);
							}else{
								Scene.map.addMaterial(i, j, itemList[hold].getType());
							}
							Scene.room = new Room(Scene.map.getMap());
							flag = 0;
							hold = -1;
						}
					}
				}
			}
		}else{
			for(int i = 0; i < Scene.room.square.length; i++) {
				for(int j = 0; j < Scene.room.square[0].length; j++) {
					if(Scene.room.square[i][j].contains(Scene.mse)) {
						currentX[M] = i;
						currentY[M] = j;
						M++;
					}
				}
			}
		}
	}
	
	
	public void draw(Graphics g) {
		
	}
	
	public void draw(Graphics g, Map map) {
		for(int i = 0; i < itemNum; i++) {
			if(items[i].contains(Scene.mse)) {
				g.setColor(new Color(255, 255, 255, 100));
				g.fillRect(items[i].x, items[i].y, items[i].width, items[i].height);
			}
			
		}
		g.drawImage(Scene.tile_grass, items[0].x, items[0].y, items[0].width, items[0].height, null); //First item -- grass
		g.drawImage(Scene.tile_road, items[1].x, items[1].y, items[1].width, items[1].height, null); //Second item -- road
		g.drawImage(Scene.tile_base, items[2].x, items[2].y, items[2].width, items[2].height, null); //Third item -- base
		g.drawImage(Scene.tile_cave, items[3].x, items[3].y, items[3].width, items[3].height, null); //Fourth item -- cave
		g.drawImage(Scene.tile_M, items[4].x, items[4].y, items[4].width, items[4].height, null); //Fifth item -- simulate
		
		for(int i = 0; i < max_health; i++) g.drawImage(Scene.tile_heart, health[i].x, health[i].y, health[i].width, health[i].height, null); //Health
		
		if(flag == 1) {
			if(hold == 0) g.drawImage(Scene.tile_grass, Scene.mse.x - items[0].width/2, Scene.mse.y - items[0].height/2, items[0].width, items[0].height, null);
			if(hold == 1) g.drawImage(Scene.tile_road, Scene.mse.x - items[1].width/2, Scene.mse.y - items[1].height/2, items[1].width, items[1].height, null);
			if(hold == 2) g.drawImage(Scene.tile_base, Scene.mse.x - items[2].width/2, Scene.mse.y - items[2].height/2, items[2].width, items[2].height, null);
			if(hold == 3) g.drawImage(Scene.tile_cave, Scene.mse.x - items[3].width/2, Scene.mse.y - items[3].height/2, items[3].width, items[3].height, null);
			if(hold == 4) {
				Scene.simulate = true;
			}
		}
		for(int k = 0; k < M; k++) {
			g.drawImage(Scene.tile_M, (Scene.Width/2 - (worldWidth*tileSize)/2) + currentY[k] * tileSize, (Scene.Height/2 - (worldHeight*tileSize)/2) +  currentX[k] * tileSize, tileSize/3, tileSize/3, null);
		}
	}
}
