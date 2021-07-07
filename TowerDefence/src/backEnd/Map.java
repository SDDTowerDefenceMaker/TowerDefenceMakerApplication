package backEnd;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import backEnd.Monster.MonsterCave;
import backEnd.Monster.MonsterType;

public class Map {
	Tile[][] Tiles;
	int x;
	int y;
	ArrayList<MonsterCave> monsterCaves;
	public Map(int x, int y) {
		Tiles=new Tile[x][y];
		this.x = x;
		this.y = y;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				Tiles[i][j]=new Tile(MaterialFactory.getMaterial("resource/grass.jpg"),"material");//material, towerbase, monstercave
			}
		}
	}
	public Map(String fName) {
		importing(fName);
	}
	public boolean addTowerBase(String type, Coordinate c) {
		return false; 
	}
	public boolean defineMonsterCave(int waveNumber, MonsterType mType, int monstersNumber) {
		return false;
	}
	
	public boolean changetile(int x, int y, Tile t) {
		if(t==null) {
			return false;
		}
		t.changeCoordinate(x, y);
		Tiles[x][y] = t;
		return true;
	}
	
	public Tile[][] getMap(){
		return Tiles;
	}
	
	public int getMaxX() {
		return x;
	}
	
	public int getMaxY() {
		return y;
	}
	
	public boolean export(String fName) {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(fName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.printf("%d %d\n", x, y);
	    
	    for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				printWriter.printf("%d %d ", i, j);
				Tile t = Tiles[i][j];
				if(t.getType().equals("material")) {
					printWriter.printf("material %s\n", ((Material)t.getObject()).getTexture());
				}
			}
		}
	    printWriter.close();
	    return true;
	}
	
	public boolean importing(String fName) {
	    Scanner sc2 = null;
	    try {
	        sc2 = new Scanner(new File(fName));
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();  
	    }
	    Scanner s = new Scanner(sc2.nextLine());
	    x = Integer.parseInt(s.next());
	    y = Integer.parseInt(s.next());
	    Tiles = new Tile[x][y];
	    while (sc2.hasNextLine()) {
	            Scanner s2 = new Scanner(sc2.nextLine());
	        
	            int tileX = Integer.parseInt(s2.next());
	            int tileY = Integer.parseInt(s2.next());
	            String tileType = s2.next();
	            String tileTexture = s2.next();
	    		Tiles[tileX][tileY] = new Tile(MaterialFactory.getMaterial(tileTexture), tileType);

	        
	    }
	    return true;
	}
	
}
