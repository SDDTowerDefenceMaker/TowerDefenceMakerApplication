package frontEnd;
import java.awt.*;

import backEnd.Tile;

public class Room {
	private int worldWidth;
	private int worldHeight;
	public int tileSize = 96;
	
	public Tile[][] tile;
	public Block[][] block;
	
	public Room(Tile[][] t) {
		tile = t;
		worldWidth = tile.length;
		worldHeight = tile[0].length;
		define();
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < block.length; i++) {
			for(int j = 0; j < block[0].length; j++) {
				block[i][j].draw(g);
			}
		}
	}
	
	public void define() {
		block = new Block[worldHeight][worldWidth];
		for(int i = 0; i < block.length; i++) {
			for(int j = 0; j < block[0].length; j++) {
				block[i][j] = new Block((Scene.Width/2 - (worldWidth*tileSize)/2) + j * tileSize, (Scene.Height/2 - (worldHeight*tileSize)/2) +  i * tileSize, tileSize, tileSize, 0, 0);
			}
		}
	}	
	
	public void physics() {
		
	}
}
