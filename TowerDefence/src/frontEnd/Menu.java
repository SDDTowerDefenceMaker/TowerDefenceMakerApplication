package frontEnd;

import java.awt.*;

public class Menu {
	private static int itemNum = 8;
	private static int itemSize = 64;
	
	public static int hold = -1;
	
	public Rectangle[] items = new Rectangle[itemNum];
	
	public boolean flag = false;
	
	public Menu() {
		define();
	}
	
	public void define() {
		for(int i = 0; i < itemNum; i++) {
			items[i] = new Rectangle(Scene.Width - itemSize - 2, (itemSize + 2)*i + 2, itemSize, itemSize);
		}
	}
	
	public void click(int item) {
		if(item == 1) {
			for(int i = 0; i< itemNum; i++) {
				if(items[i].contains(Scene.mse)) {
					hold = i;
					flag = true;
				}
			}
		}
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < itemNum; i++) {
			if(items[i].contains(Scene.mse)) {
				g.setColor(new Color(255, 255, 255, 100));
				g.fillRect(items[i].x, items[i].y, items[i].width, items[i].height);
			}
			
		}
		if(items[0].contains(Scene.mse)) {
			
		}
		g.drawImage(Scene.tile_grass[0], items[0].x, items[0].y, items[0].width, items[0].height, null); //First item -- grass
		if(items[1].contains(Scene.mse)) {
			
		}
		g.drawImage(Scene.tile_road[0], items[1].x, items[1].y, items[1].width, items[1].height, null); //Second item -- road
		if(flag) {
			if(hold == 0) g.drawImage(Scene.tile_grass[0], Scene.mse.x - items[0].width/2, Scene.mse.y - items[0].height/2, items[0].width, items[0].height, null);
		}
	}
}
