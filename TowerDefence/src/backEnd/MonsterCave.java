package backEnd;

public class MonsterCave {
	String texture;
	Path monsterPaths;
	Coordinate coordinate;
	public MonsterCave(String t, int x, int y) {
		texture = t;
		monsterPaths = new Path(x, y);
		coordinate = CoordinatesFactory.getCoordinate(x, y);
	}
	public String getTexture() {
		return texture;
	}
	@Override
	public int hashCode() {
		int tmp = ( texture.hashCode() +  ((coordinate.hashCode()+1)/2));
        return coordinate.hashCode() +  (tmp * tmp);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass().equals(this.getClass())) {
			MonsterCave c = (MonsterCave) obj;
			return c.texture.equals(this.texture);
		}else {
			return false;
		}
	}
}
