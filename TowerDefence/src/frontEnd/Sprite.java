package frontEnd;

import java.awt.*;

public class Sprite extends Rectangle {
	int index = 1;
	public int xC, yC;
	public int sprite_size = 52;
	public int direct = 0;
	public int walkCount = 0;
	public boolean start = false;
	
	public Sprite() {
		
	}
	
	public void spawn() {
		for(int i = 0; i < Scene.room.block.length; i++) {
			setBounds(Scene.room.block[i][0].x, Scene.room.block[i][0].y, sprite_size, sprite_size);
			
			xC = Scene.map.monsterCaves.get(0).row;
			yC = Scene.map.monsterCaves.get(0).column;
		}
		start = true;
		x = Scene.room.block[Scene.map.monsterCaves.get(0).row][Scene.map.monsterCaves.get(0).column].x;
		y = Scene.room.block[Scene.map.monsterCaves.get(0).row][Scene.map.monsterCaves.get(0).column].y;
	}
	
	public int walkFrame = 0, walkSpeed = 30;
	
	public void simulate() {
		if(walkFrame >= walkSpeed) {
			if(direct == 0) {
				x+=1;
			}else if(direct == 1) {
				x-=1;
			}else if(direct == 2) {
				y+=1;
			}else {
				y-=1;
			}
			if(Scene.map.monsterCaves.get(0).r.get(index) - xC != 0) {
				direct = Scene.map.monsterCaves.get(0).r.get(index)- xC;
				xC = Scene.map.monsterCaves.get(0).r.get(index);
				if(direct > 0) direct = 2; //down
				else direct = 3; //up
			}else if(Scene.map.monsterCaves.get(0).c.get(index) - yC != 0){
				direct = Scene.map.monsterCaves.get(0).c.get(index)- yC;
				yC = Scene.map.monsterCaves.get(0).c.get(index);
				if(direct > 0) direct = 0; //right
				else direct = 1; //left
			}
			walkCount++;
			if(walkCount == Scene.room.tileSize) {
				if(index < Scene.map.monsterCaves.get(0).monsterPaths.paths.size()-1) index++;
				walkCount = 0;
			}
			
			walkFrame = 0;
		}else{
			walkFrame+=1;
		}
		
	}
	
	public void draw(Graphics g) {
		if(start) g.drawImage(Scene.tile_M, x, y, width, height, null);
		//Scene.map.monsterCaves.get(0).row
	}
}
