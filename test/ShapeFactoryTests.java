import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ShapeFactoryTests {
	
	@Test
	public void createLineTest() {
		Shape shape = ShapeFactory.createShape("L", 1, 2, 10, 2);
		boolean isLine = shape instanceof Line;
		assertTrue(isLine);
	}
	
	@Test
	public void createRectangleTest() {
		Shape shape = ShapeFactory.createShape("R", 1, 2, 10, 2);
		boolean isRect = shape instanceof Rectangle;
		assertTrue(isRect);
	}
}
