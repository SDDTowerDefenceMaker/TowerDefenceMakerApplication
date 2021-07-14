package frontEnd;

import java.awt.*;
import backEnd.Map;
import backEnd.Material;
import backEnd.Tile;

public class Menu {
	private static int itemNum = 8;
	private static int itemSize = 64;
	private int worldWidth = Scene.room.worldWidth;
	private int worldHeight = Scene.room.worldHeight;
	private int tileSize = Scene.room.tileSize;
	private int currentX, currentY;
	
	public static int hold = -1;
	
	public Rectangle[] items = new Rectangle[itemNum];
	public Tile[] itemList = {new Tile(new Material("material"), "resource/grass.jpg"), new Tile(new Material("material"), "resource/road.jpg")};
	
	public int flag = -1;
	
	public Menu() {
		define();
	}
	
	public void define() {
		for(int i = 0; i < itemNum; i++) {
			if (Room.tileSize != 96) {itemSize = Room.tileSize*2/3;}
			items[i] = new Rectangle(Scene.Width - itemSize - 2, (itemSize + 2)*i + 2, itemSize, itemSize);
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
							Material tmp = (Material)(itemList[hold].getObject());
							//if(!Scene.room.block[i][j].material.getTexture().equals(tmp.getTexture())){
								Scene.map.addMaterial(i, j, itemList[hold].getType());
								Scene.room = new Room(Scene.map.getMap());
								currentX = i;
								currentY = j;
								flag = 0;
								//Scene.room.block[i][j] = new Block((Scene.Width/2 - (worldWidth*tileSize)/2) + j * tileSize, (Scene.Height/2 - (worldHeight*tileSize)/2) +  i * tileSize, tileSize, tileSize, itemList[hold].getType(), itemList[hold].getObject());
							//}
						}
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
		if(flag == 1) {
			if(hold == 0) g.drawImage(Scene.tile_grass, Scene.mse.x - items[0].width/2, Scene.mse.y - items[0].height/2, items[0].width, items[0].height, null);
			if(hold == 1) g.drawImage(Scene.tile_road, Scene.mse.x - items[1].width/2, Scene.mse.y - items[1].height/2, items[1].width, items[1].height, null);
		}
		/*if(flag == 0) {
			Scene.room.block[currentX][currentY].draw(g);
			flag = -1;
		}*/
	}
}
