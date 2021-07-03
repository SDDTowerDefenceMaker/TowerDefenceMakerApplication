package backEnd;

import java.io.IOException;

import org.junit.Test;

public class MapTest {

	@Test
	public void test() {
		Map map = new Map("map.txt");
		map.export("map2.txt");
//		map.importing("map.txt");
//		map.export("map2.txt");
	}

}
