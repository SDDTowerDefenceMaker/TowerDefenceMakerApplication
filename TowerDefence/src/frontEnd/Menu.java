package frontEnd;

import java.awt.*;

public class Menu {
	private static int itemNum = 8;
	private static int itemSize = 64;
	
	public Rectangle[] items = new Rectangle[itemNum];
	
	public Menu() {
		define();
	}
	
	public void define() {
		for(int i = 0; i < itemNum; i++) {
			items[i] = new Rectangle(Scene.Width - itemSize - 2, (itemSize + 2)*i + 2, itemSize, itemSize);
		}
	}
	
	public void draw(Graphics g) {
		if(items[0].contains(Scene.mse)) {
			
		}
		g.drawImage(Scene.tile_grass[0], items[0].x, items[0].y, items[0].width, items[0].height, null); //First item -- grass
		if(items[1].contains(Scene.mse)) {
			
		}
		g.drawImage(Scene.tile_road[0], items[1].x, items[1].y, items[1].width, items[1].height, null); //Second item -- road
		for(int i = 2; i < itemNum; i++) {
			if(items[i].contains(Scene.mse)) {
				
			}
			g.fillRect(items[i].x, items[i].y, items[i].width, items[i].height);
		}
	}
}
