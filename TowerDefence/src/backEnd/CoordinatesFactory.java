package backEnd;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CoordinatesFactory {
	static private HashMap<Coordinate, Coordinate> coordinateMap;
	/**
	 * 
	 * @param x coordinate
	 * @param y coordinate
	 * @return a coordinate obj with specified x and y
	 */
	static public Coordinate getCoordinate(int x, int y) {
		Coordinate coordinate = new Coordinate(x, y);
		if (coordinateMap==null) {
			coordinateMap=new HashMap<Coordinate, Coordinate>();
			coordinateMap.put(coordinate, coordinate);
			return coordinate;
		}else {
			if (coordinateMap.containsKey(coordinate)) {
				return coordinateMap.get(coordinate);
			}else {
				coordinateMap.put(coordinate, coordinate);
				return coordinate;
			}
		}
	}
}
