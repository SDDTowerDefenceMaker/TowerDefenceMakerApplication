package frontEnd;

import java.awt.*;

import javax.swing.ImageIcon;

import backEnd.Material;
import backEnd.MonsterCave;

public class Block extends Rectangle{
	public String type;
	public Object material;
	
	public Block(int x, int y, int width, int height, String type, Object material) {
		setBounds(x, y, width, height);
		this.type = type;
		this.material = material;
	}

	
	public void draw(Graphics g) {
		if(type.equals("material")) {
			Image d = new ImageIcon(((Material)material).getTexture()).getImage();
			g.drawImage(d,x,y,width,height,null);
		}else if(type.equals("monstercave")) {
			Image d = new ImageIcon(((MonsterCave)material).getTexture()).getImage();
			g.drawImage(d,x,y,width,height,null);
		}
	}
}
