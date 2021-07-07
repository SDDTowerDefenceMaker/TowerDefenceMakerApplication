package backEnd;

public class Tile {
	Coordinate locationCoordinate;
	Object object;
	String objectType;
	//material (name+color)
	public Tile(Object o, String t) {
		locationCoordinate = CoordinatesFactory.getCoordinate(0, 0);
		object=o;
		objectType=t;
	}
	public Tile(Object o, String t, int x, int y) {
		locationCoordinate = CoordinatesFactory.getCoordinate(x, y);
		object=o;
		objectType=t;
	}
	
	public void changeCoordinate(int x, int y) {
		locationCoordinate = CoordinatesFactory.getCoordinate(x, y);
	}
	
	public String getType() {
		return objectType;
	}
	public Object getObject() {
		return object;
	}
}
