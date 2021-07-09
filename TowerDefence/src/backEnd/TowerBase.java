package backEnd;

public class TowerBase {
	String texture;
	public TowerBase(String texture) {
		// TODO Auto-generated constructor stub
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
			TowerBase c = (TowerBase) obj;
			return c.texture.equals(this.texture);
		}else {
			return false;
		}
	}
}
