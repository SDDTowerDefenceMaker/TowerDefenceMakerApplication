package backEnd;


import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinatesFactoryTest {

	@Test
	public void test() {
		assertTrue(CoordinatesFactory.getCoordinate(0, 0).equals(CoordinatesFactory.getCoordinate(0, 0)));
		assertFalse(CoordinatesFactory.getCoordinate(0, 0).equals(CoordinatesFactory.getCoordinate(1, 0)));
	}

}
