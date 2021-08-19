package backEnd;

import java.util.ArrayList;

public class MonsterCave extends MapOBJ {
	private  int row, column;
	private String texture;
	private  ArrayList<Integer> r = new ArrayList<>();
	private  ArrayList<Integer> c = new ArrayList<>();
	private  Path monsterPaths;
	private Coordinate coordinate;
	private Monster monsterCreated;
	public ArrayList<Integer> getR() {
		return r;
	}
	public ArrayList<Integer> getC() {
		return c;
	}
	public Path getMonsterPath() {
		return monsterPaths;
	}
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public MonsterCave(String t, int x, int y) {
		texture = t;
		row = x;
		column = y;
		monsterPaths = new Path(x, y);
		coordinate = CoordinatesFactory.getCoordinate(x, y);
		monsterCreated = new Monster(x, y);
	}
	public String getTexture() {
		return texture;
	}
	
	public boolean addPath(int x, int y) {
		r.add(x);
		c.add(y);
		return monsterPaths.extendPaths(x, y);
	}
	public void revokePath() {
		monsterPaths.revokePath();
	}
	public Monster getMonster() {
		return monsterCreated;
	}
	public void MonsterMove() {
		monsterCreated.increaseSteps();
		Coordinate nextMCoordinate = monsterPaths.getPath().get(monsterCreated.getStepsTook());
		monsterCreated.changeCoordinate(nextMCoordinate.getX(), nextMCoordinate.getY());
	}
	@Override
	public int hashCode() {
		return coordinate.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass().equals(this.getClass())) {
			MonsterCave c = (MonsterCave) obj;
			return c.coordinate.getX()==this.coordinate.getX()&&c.coordinate.getY()==this.coordinate.getY();
		}else {
			return false;
		}
	}
}
