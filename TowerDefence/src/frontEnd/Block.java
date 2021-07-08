package frontEnd;

import java.awt.*;

import javax.swing.ImageIcon;

import backEnd.Material;

public class Block extends Rectangle{
	public String type;
	public Material material;
	
	public Block(int x, int y, int width, int height, String type, Object material) {
		setBounds(x, y, width, height);
		this.type = type;
		this.material = (Material) material;
	}
	
	public void draw(Graphics g) {
		if(type.equals("material")) {
			Image d = new ImageIcon(material.getTexture()).getImage();
			g.drawImage(d,x,y,width,height,null);
		}
		
	}
}
