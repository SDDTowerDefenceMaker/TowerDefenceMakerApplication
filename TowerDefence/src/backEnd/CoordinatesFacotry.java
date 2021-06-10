package backEnd;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CoordinatesFacotry {
	static HashMap<Coordinate, Coordinate> coordinateMap;
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
