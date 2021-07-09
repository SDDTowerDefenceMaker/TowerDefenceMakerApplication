package backEnd;

public class MonsterCave {
	String texture;
	public MonsterCave(String t) {
		texture = t;
	}
	public String getTexture() {
		return texture;
	}
	@Override
	public int hashCode() {
		return texture.hashCode();
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
