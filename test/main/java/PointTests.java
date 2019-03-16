package main.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PointTests {

	Point p;
	
	@Test
	void testNewPointBlankValue() {
		p = new Point(1, 2);
		assertEquals(1, p.getX());
		assertEquals(2, p.getY());
		assertEquals(' ', p.getValue());
	}
	
	@Test
	void testNewPointWithValue() {
		p = new Point(2, 3, 'D');
		assertEquals(2, p.getX());
		assertEquals(3, p.getY());
		assertEquals('D', p.getValue());
	}
	
	@Test
	void testSetValues() {
		p = new Point(2, 3, 'D');
		p.setX(6);
		p.setY(8);
		p.setValue('L');
		
		assertEquals(6, p.getX());
		assertEquals(8, p.getY());
		assertEquals('L', p.getValue());
	}
}
