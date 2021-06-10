package backEnd;

public class Coordinate {
	private int x, y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	@Override
	public int hashCode() {
		int tmp = ( y +  ((x+1)/2));
        return x +  (tmp * tmp);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass().equals(this.getClass())) {
			Coordinate c = (Coordinate) obj;
			return c.x==this.x&&c.y==this.y;
		}else {
			return false;
		}
	}
}
