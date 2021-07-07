package frontEnd;

import java.awt.*;

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
			if(material.getTexture().equals("resource/grass.jpg")) {
				g.drawImage(Scene.tile_grass[0],x,y,width,height,null);
			}else if(material.getTexture().equals("resource/road.jpg")) {
				g.drawImage(Scene.tile_road[0],x,y,width,height,null);
			}
		}
		
	}
}
