package backEnd;


import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinatesFactoryTest {

	@Test
	public void test() {
		assertTrue(CoordinatesFacotry.getCoordinate(0, 0).equals(CoordinatesFacotry.getCoordinate(0, 0)));
		assertFalse(CoordinatesFacotry.getCoordinate(0, 0).equals(CoordinatesFacotry.getCoordinate(1, 0)));
		
	}

}
