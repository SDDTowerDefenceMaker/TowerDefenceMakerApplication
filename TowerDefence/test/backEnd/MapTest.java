package backEnd;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

public class MapTest {

	@Test
	public void testEmpty() {
		Map map = new Map(5, 5);
		map.export("map.txt");
		map.importing("map.txt");
		map.simulateNext();
	}
	@Test
	public void testAddMaterial() {
		Map map = new Map(5, 5);
		map.addMaterial(0, 0, "AAA");
		assertTrue(((Material)map.getMap()[0][0].getObject()).getTexture()=="AAA");
	}
	@Test
	public void testAddMonsterCave() {
		Map map = new Map(5, 5);
		map.addMonsterCave(0, 0, "aa");
		assertFalse(map.addPathToCave(2, 0, 0));
		assertFalse(map.addPathToCave(1, 0, 1));
		assertTrue(map.addPathToCave(1, 0, 0));
		MonsterCave m = (MonsterCave)map.getMap()[0][0].getObject();
		assertTrue(m.getMonsterPath().getPath().get(1).getX()==1&&m.getMonsterPath().getPath().get(1).getY()==0);
		assertFalse(map.revokePath(1));
		assertTrue(map.revokePath(0));
		m = (MonsterCave)map.getMap()[0][0].getObject();
		assertTrue(m.getMonsterPath().getPath().get(0).getX()==0&&m.getMonsterPath().getPath().get(0).getY()==0);
		
	}

	
}
