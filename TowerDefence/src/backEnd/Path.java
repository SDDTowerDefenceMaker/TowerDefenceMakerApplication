package backEnd;

import java.util.ArrayList;

public class Path {
	private Coordinate start;
	private Coordinate end;
	private  ArrayList<Coordinate> paths;
	/**
	 * initialize a path tile with specified x and y
	 * @param x coordinate
	 * @param y coordinate
	 */
	public Path(int x, int y) {
		paths = new ArrayList<Coordinate>();
		paths.add(CoordinatesFactory.getCoordinate(x, y));
		start = CoordinatesFactory.getCoordinate(x, y);
		end = CoordinatesFactory.getCoordinate(x, y);
	}
	private boolean isNeighbor(Coordinate c1, Coordinate c2) {
		if(c1.getX() == c2.getX() && c1.getY() == c2.getY()+1 ) {
			return true;
		}else if (c1.getX() == c2.getX() && c1.getY() == c2.getY()-1) {
			return true;
		}else if (c1.getX() == c2.getX()+1 && c1.getY() == c2.getY()) {
			return true;
		}else if (c1.getX() == c2.getX()-1 && c1.getY() == c2.getY()) {
			return true;
		}else {
			return false;
		}
	}
	public boolean extendPaths(int x, int y) {
		if (isNeighbor(end, CoordinatesFactory.getCoordinate(x, y))) {
			paths.add(CoordinatesFactory.getCoordinate(x, y));
			end = CoordinatesFactory.getCoordinate(x, y);
			return true;
		}else {
			return false;
		}
	}
	public void revokePath() {
		if(start.equals(end)==false) {
			paths.remove(paths.size()-1);
			end = paths.get(paths.size()-1);
		}
	}
	public ArrayList<Coordinate> getPath() {
		return paths;
	}
	@Override
	public int hashCode() {
		int hashCode = 0;
	    hashCode = (hashCode * 397) ^ start.hashCode();
	    hashCode = (hashCode * 397) ^ end.hashCode();
	    hashCode = (hashCode * 397) ^ paths.hashCode();
	    return hashCode;
	}
}
