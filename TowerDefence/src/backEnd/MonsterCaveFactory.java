package backEnd;

import java.util.HashMap;

public class MonsterCaveFactory {
	static private  HashMap<MonsterCave, MonsterCave> MonsterCaveMap;
	static public  MonsterCave getMonsterCave(String texture, int x, int y) {
		MonsterCave monsterCave = new MonsterCave(texture, x, y);
		if (MonsterCaveMap==null) {
			MonsterCaveMap=new HashMap<MonsterCave, MonsterCave>();
			MonsterCaveMap.put(monsterCave, monsterCave);
			return monsterCave;
		}else {
			if (MonsterCaveMap.containsKey(monsterCave)) {
				return MonsterCaveMap.get(monsterCave);
			}else {
				MonsterCaveMap.put(monsterCave, monsterCave);
				return monsterCave;
			}
		}
	}
}
