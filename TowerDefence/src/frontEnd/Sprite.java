package frontEnd;

import java.awt.*;

public class Sprite extends Rectangle {
	public int xC, yC;
	public int sprite_size = 52;
	public int direct = 2;
	public int walkCount = 0;
	public boolean start = false;
	
	public Sprite() {
		
	}
	
	public void spawn() {
		for(int i = 0; i < Scene.room.block.length; i++) {
			setBounds(Scene.room.block[i][0].x, Scene.room.block[i][0].y, sprite_size, sprite_size);
			
			xC = 0;
			yC = i;
		}
		start = true;
		x = Scene.room.block[0][0].x;
		y = Scene.room.block[0][0].y;
	}
	
	public int walkFrame = 0, walkSpeed = 40;
	
	public void simulate() {
		if(walkFrame >= walkSpeed) {
			x += 1;
			/*if(direct == 2) { //move right
				x += 1;
			}else if(direct == 0) { //move upward
				y -= 1;
			}else if(direct == 1) { //move downward
				y+=1;
			}
			walkCount++;
			
			if(walkCount == Scene.room.tileSize) {
				if(direct == 2) { 
					xC += 1;
				}else if(direct == 0) { 
					yC -= 1;
				}else if(direct == 1) { 
					yC += 1;
				}
				
				//if(Scene.room.block[yC][xC])
			}
			walkFrame = 0;*/
		}else{
			walkFrame+=1;
		}
		
	}
	
	public void draw(Graphics g) {
		if(start) g.drawImage(Scene.tile_M, x, y, width, height, null);
		//Scene.map.monsterCaves.get(0).row
	}
}
