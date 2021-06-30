package frontEnd;
import java.awt.*;

public class Room {
	private int worldWidth;
	private int worldHeight;
	public int tileSize = 96;
	
	public Block[][] tile;
	
	public Room(int x, int y) {
		worldWidth = x;
		worldHeight = y;
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
