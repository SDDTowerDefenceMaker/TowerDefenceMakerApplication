package backEnd;

public class Tower {	
	String texture;
	float attack;
	float s_interval;
	int range;
	public Tower(String t, float a, float i, int r) {
		texture = t;
		attack = a;
		s_interval = i;
		range = r;
	}
	public String getTexture() {
		return texture;
	}
	public float getAttack() {
		return attack;
	}
	public float getS_interval() {
		return s_interval;
	}
	public int getRange() {
		return range;
	}
	@Override
	public int hashCode() {
		int hash = 1;
		hash *= (1779033703 + 2*texture.hashCode());
		hash*= (1779033703 + 2*Float.valueOf(attack).hashCode());
		hash*= (1779033703 + 2*Float.valueOf(s_interval).hashCode());
		hash*= (1779033703 + 2*range);
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass().equals(this.getClass())) {
			Tower c = (Tower) obj;
			return c.texture.equals(this.texture)&&c.attack==this.attack&&c.s_interval==this.s_interval&&c.range==this.range;
		}else {
			return false;
		}
	}
}
