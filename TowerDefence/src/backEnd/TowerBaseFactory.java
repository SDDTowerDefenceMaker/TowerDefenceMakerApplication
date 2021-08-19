package backEnd;

import java.util.HashMap;

public class TowerBaseFactory {
	static private HashMap<TowerBase, TowerBase> TowerBaseMap;
	static public TowerBase getTowerBase(String texture) {
		TowerBase towerBase = new TowerBase(texture);
		if (TowerBaseMap==null) {
			TowerBaseMap=new HashMap<TowerBase, TowerBase>();
			TowerBaseMap.put(towerBase, towerBase);
			return towerBase;
		}else {
			if (TowerBaseMap.containsKey(towerBase)) {
				return TowerBaseMap.get(towerBase);
			}else {
				TowerBaseMap.put(towerBase, towerBase);
				return towerBase;
			}
		}
	}
}
