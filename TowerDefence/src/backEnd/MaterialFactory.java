package backEnd;

import java.util.HashMap;

public class MaterialFactory {
	static HashMap<Material, Material> MaterialMap;
	static public Material getMaterial(String t) {
		Material material = new Material(t);
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
