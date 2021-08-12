package frontEnd;
import java.awt.*;
import backEnd.Map;

import backEnd.Tile;

public class Room {
	public int worldWidth;
	public int worldHeight;
	public int tileSize = 96;
	
	public Tile[][] tile;
	public Block[][] block;
	public Rectangle[][] square;
	
	public Room(Tile[][] t) {
		tile = t;
		worldWidth = tile[0].length;
		worldHeight = tile.length;
		tileSize = (Math.min(GUI.height, Load.height)*5/6)/(Math.max(worldWidth,worldHeight));
		define();
	}
	
	public void draw(Graphics g, Map map) {
		tile = map.getMap();
		for(int i = 0; i < block.length; i++) {
			for(int j = 0; j < block[0].length; j++) {
				block[i][j].draw(g);
			}
		}
	}
	
	public void define() {
		block = new Block[worldHeight][worldWidth];
		square = new Rectangle[block.length][block[0].length];
		for(int i = 0; i < block.length; i++) {
			for(int j = 0; j < block[0].length; j++) {
				block[i][j] = new Block((Scene.Width/2 - (worldWidth*tileSize)/2) + j * tileSize, (Scene.Height/2 - (worldHeight*tileSize)/2) +  i * tileSize, tileSize, tileSize, tile[i][j].getType(), tile[i][j].getObject());
				square[i][j] = new Rectangle((Scene.Width/2 - (worldWidth*tileSize)/2) + j * tileSize, (Scene.Height/2 - (worldHeight*tileSize)/2) +  i * tileSize, tileSize, tileSize);
			}
		}
	}	
	
}
