package frontEnd;

import java.awt.*;

public class Block extends Rectangle{
	public int ground;
	public int air;
	
	public Block(int x, int y, int width, int height, int ground, int air) {
		setBounds(x, y, width, height);
		this.ground = ground;
		this.air = air;
	}
	
	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}
}
