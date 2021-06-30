package backEnd;

import java.io.IOException;

import org.junit.Test;

public class MapTest {

	@Test
	public void test() {
		Map map = new Map(5, 5);
		//map.export("map.txt");
		map.importing("map.txt");
		map.export("map2.txt");
	}

}
