package backEnd;

import java.util.ArrayList;
import java.util.Arrays;

import com.sun.org.apache.bcel.internal.generic.FRETURN;

public class Map {
	Tile[][] Tiles;
	ArrayList<MonsterCave> monsterCaves;
	public Map(int x, int y) {
		Tiles=new Tile[x][y];
	}
	public boolean addTowerBase(String type, Coordinate c) {
		return false; 
	}
	public boolean defineMonsterCave(int waveNumber, MonsterType mType, int monstersNumber) {
		return false;
	}
	
	
}
