package frontEnd;

import java.awt.Graphics;

import backEnd.Map;
import backEnd.Tile;

public class SaveButton {
	public int worldWidth;
	public int worldHeight;

	public SaveButton() {
		worldWidth = Scene.Width;
		worldHeight = Scene.Height;
	}
	
	public void draw(Graphics g) {
		g.drawImage(Scene.tile_grass, worldWidth-50, worldHeight-50, 50, 50, null);
		
	}
	
	public void define() {
		
	}	
}
