package backEnd;

import java.util.HashMap;

public class MaterialFactory {
	static private  HashMap<Material, Material> MaterialMap;
	static public Material getMaterial(String texture) {
		Material material = new Material(texture);
		if (MaterialMap==null) {
			MaterialMap=new HashMap<Material, Material>();
			MaterialMap.put(material, material);
			return material;
		}else {
			if (MaterialMap.containsKey(material)) {
				return MaterialMap.get(material);
			}else {
				MaterialMap.put(material, material);
				return material;
			}
		}
	}
}
