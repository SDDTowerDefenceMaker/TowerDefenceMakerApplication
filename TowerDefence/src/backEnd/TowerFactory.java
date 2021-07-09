package backEnd;

import java.util.HashMap;

public class TowerFactory {
	static HashMap<Tower, Tower> TowerBaseMap;
	static public Tower getTowerBase(String texture, float attack, float s_interval, int range) {
		Tower towerBase = new Tower(texture, attack, s_interval, range);
		if (TowerBaseMap==null) {
			TowerBaseMap=new HashMap<Tower, Tower>();
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