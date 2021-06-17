package backEnd;

public class Coordinate {
	private int x, y;
	
	public Coordinate() {
		this.x = 0;
		this.y = 0;
	}
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Coordinate(Coordinate c) {
		this.x = c.x;
		this.y = c.y;
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
