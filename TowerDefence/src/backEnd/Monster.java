package backEnd;

public class Monster {
	private Coordinate c;
	private int steps;
	public Monster(int x, int y) {
		c = CoordinatesFactory.getCoordinate(x, y);
		steps = 0;
	}
	public Coordinate getCoordinate() {
		return c;
	}
	public void changeCoordinate(int x, int y) {
		c = CoordinatesFactory.getCoordinate(x, y);
	}
	public void increaseSteps() {
		++steps;
	}
	public int getStepsTook() {
		return steps;
	}
}
