package backEnd;

public class Monster extends MapOBJ {
	private Coordinate c;
	private String t;
	private int steps;
	public Monster(int x, int y) {
		c = CoordinatesFactory.getCoordinate(x, y);
		steps = 0;
		t="monster";
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
	@Override
	public String getTexture() {
		// TODO Auto-generated method stub
		return t;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return c.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return ((Monster)obj).c.equals(c);
	}
}
