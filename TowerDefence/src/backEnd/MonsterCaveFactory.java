package backEnd;

import java.util.HashMap;

public class MonsterCaveFactory {
	static HashMap<MonsterCave, MonsterCave> MonsterCaveMap;
	static public MonsterCave getMonsterCave(String texture) {
		MonsterCave monsterCave = new MonsterCave(texture);
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
