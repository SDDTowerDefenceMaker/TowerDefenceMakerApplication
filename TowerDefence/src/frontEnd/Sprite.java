package frontEnd;

import java.awt.*;

public class Sprite extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int index = 1;
	public int xC, yC;
	public int sprite_size = 52;
	public int direct = 0;
	public int walkCount = 0;
	public boolean start = false;
	
	/**
	 * @effect create monsters
	 */
	public Sprite() {
		
	}
	
	/**
	 * @effect initialize each monster
	 */
	public void spawn() {
		for(int i = 0; i < Scene.room.block.length; i++) {
			setBounds(Scene.room.block[i][0].x, Scene.room.block[i][0].y, sprite_size, sprite_size);
			
			xC = Scene.map.monsterCaves.get(0).getRow();
			yC = Scene.map.monsterCaves.get(0).getColumn();
		}
		start = true;
		x = Scene.room.block[Scene.map.monsterCaves.get(0).getRow()][Scene.map.monsterCaves.get(0).getColumn()].x + sprite_size/2;
		y = Scene.room.block[Scene.map.monsterCaves.get(0).getRow()][Scene.map.monsterCaves.get(0).getColumn()].y + sprite_size/2;
	}
	
	public int walkFrame = 0, walkSpeed = 30;
	
	/**
	 * @effect let monsters move
	 */
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
			if(Scene.map.monsterCaves.get(0).getR().get(index) - xC != 0) {
				direct = Scene.map.monsterCaves.get(0).getR().get(index)- xC;
				xC = Scene.map.monsterCaves.get(0).getR().get(index);
				if(direct > 0) direct = 2; //down
				else direct = 3; //up
			}else if(Scene.map.monsterCaves.get(0).getC().get(index) - yC != 0){
				direct = Scene.map.monsterCaves.get(0).getC().get(index)- yC;
				yC = Scene.map.monsterCaves.get(0).getC().get(index);
				if(direct > 0) direct = 0; //right
				else direct = 1; //left
			}
			
			walkCount++;
			if(walkCount == Scene.room.tileSize) {
				
				if(index < Scene.map.monsterCaves.get(0).getMonsterPath().getPath().size()) {
					index++;
				}
				
				if(index == Scene.map.monsterCaves.get(0).getMonsterPath().getPath().size()) {
					start = false;
					Scene.menu.max_health--;
					index --;
				}
				walkCount = 0;
			}
			
			walkFrame = 0;
		}else{
			walkFrame+=1;
		}
		
	}
	
	/**
	 * 
	 * @effect draw monsters
	 */
	public void draw(Graphics g) {
		if(start) g.drawImage(Scene.tile_M, x, y, width, height, null);
		//Scene.map.monsterCaves.get(0).getRow()
	}
}
