package backEnd;

import java.util.ArrayList;

public class MonsterCave {
	public int row, column;
	String texture;
	public ArrayList<Integer> r = new ArrayList<>();
	public ArrayList<Integer> c = new ArrayList<>();
	public Path monsterPaths;
	Coordinate coordinate;
	Monster monsterCreated;
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
		Coordinate nextMCoordinate = monsterPaths.paths.get(monsterCreated.getStepsTook());
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
