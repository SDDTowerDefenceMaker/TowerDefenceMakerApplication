package backEnd;

public class Tile {
	Coordinate locationCoordinate;
	Object object;
	String objectType;
	public Tile(Object o, String t) {
		object=o;
		objectType=t;
	}
}
