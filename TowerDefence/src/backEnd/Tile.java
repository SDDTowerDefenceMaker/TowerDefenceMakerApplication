package backEnd;

public class Tile {
	Coordinate locationCoordinate;
	Object object;
	String objectType;
	//material (name+color)
	public Tile(Object o, String t) {
		locationCoordinate = CoordinatesFacotry().getCoordinate(0, 0);
		object=o;
		objectType=t;
	}
	public String getType() {
		return objectType;
	}
	public Object getObject() {
		return object;
	}
}
