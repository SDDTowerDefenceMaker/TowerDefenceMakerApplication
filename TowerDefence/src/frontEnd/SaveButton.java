package frontEnd;

import java.awt.Graphics;

import javax.swing.ImageIcon;


public class SaveButton {
	public int worldWidth;
	public int worldHeight;

	public SaveButton() {
		worldWidth = Scene.Width;
		worldHeight = Scene.Height;
	}
	
	public void draw(Graphics g) {
		g.drawImage(new ImageIcon("resource/save.png").getImage(), worldWidth-50, worldHeight-50, 50, 50, null);
		
	}
	
	public void define() {
		
	}	
}
