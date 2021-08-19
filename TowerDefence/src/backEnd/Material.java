package backEnd;

public class Material extends MapOBJ{
	private String texture;
	public Material(String t) {
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
			Material c = (Material) obj;
			return c.texture.equals(this.texture);
		}else {
			return false;
		}
	}
}
