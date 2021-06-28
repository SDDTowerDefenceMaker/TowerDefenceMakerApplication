package frontEnd;

import java.awt.*;

public class Block extends Rectangle{
	public int road;
	public int grass;
	
	public Block(int x, int y, int width, int height, int road, int grass) {
		setBounds(x, y, width, height);
		this.road = road;
		this.grass = grass;
	}
	
	public void draw(Graphics g) {
		g.drawImage(Scene.tile_grass[grass],x,y,width,height,null);
	}
}
