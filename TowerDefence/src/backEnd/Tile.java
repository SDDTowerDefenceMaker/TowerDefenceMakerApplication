package backEnd;

public class Tile {
	private Coordinate locationCoordinate;
	private Object object;
	private String objectType;//material, monstercave, towerbase, monster
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
	
	/**
	 * (Not recommended!)
	 * Change the position of the tile to the given x and y
	 * @param x coordinate
	 * @param y coordinate
	 */
	public void changeCoordinate(int x, int y) {
		locationCoordinate = CoordinatesFactory.getCoordinate(x, y);
	}
	
	/**
	 * get the type of the tile. It can be //material, monstercave, towerbase, monster
	 * @return material, monstercave, towerbase, monster
	 */
	public String getType() {
		return objectType;
	}
	
	/**
	 * get the object in the tile
	 * @return the object in the tile
	 */
	public Object getObject() {
		return object;
	}
}
