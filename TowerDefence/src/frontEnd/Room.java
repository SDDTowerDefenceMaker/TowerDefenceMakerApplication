package frontEnd;
import java.awt.*;

public class Room {
	private int worldWidth = 24;
	private int worldHeight = 13;
	public int tileSize = 64;
	
	public Block[][] tile;
	
	public Room() {
		define();
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < tile.length; i++) {
			for(int j = 0; j < tile[0].length; j++) {
				tile[i][j].draw(g);
			}
		}
	}
	
	public void define() {
		tile = new Block[worldHeight][worldWidth];
		for(int i = 0; i < tile.length; i++) {
			for(int j = 0; j < tile[0].length; j++) {
				tile[i][j] = new Block((Scene.Width/2 - (worldWidth*tileSize)/2) + j * tileSize, (Scene.Height/2 - (worldHeight*tileSize)/2) +  i * tileSize, tileSize, tileSize, 0, 0);
			}
		}
	}	
	
	public void physics() {
		
	}
}
