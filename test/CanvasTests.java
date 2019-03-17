import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CanvasTests {

	int w = 0;
	int h = 0;
	Canvas canvas;
	
	@BeforeEach
	void initialize() {
		w = 10;
		h = 8;
		canvas = new Canvas(w, h);
	}
	
	@Test
	void testGetSize() {
		assertEquals(canvas.getWidth(), 10);
		assertEquals(canvas.getHeight(), 8);
	}
	
	@Test
	void testHorizontalBorder() {
		for(int x = 0; x < h+2; x++) {
			assertEquals(canvas.getValue(x, 0), '-');
			assertEquals(canvas.getValue(x, h+1), '-');
		}
	}
	
	@Test
	void testVerticalBorder() {
		for(int y = 1; y < h+1; y++) {
			assertEquals(canvas.getValue(0, y), '|');
			assertEquals(canvas.getValue(w+1, y), '|');
		}
	}
	
	@Test
	void testInitialContent() {
		for (int x = 1; x < w; x++) {
			for (int y = 1; y < h; y++) {
				assertEquals(canvas.getValue(x, y), ' ');
			}
		}
	}
	
	@Test
	void testMarkPoints() {
		canvas.markPoint(new Point(1, 1, 'D'));
		canvas.markPoint(new Point(w, 1, 'X'));
		canvas.markPoint(new Point(1, h, '5'));
		canvas.markPoint(new Point(w, h, '*'));
		canvas.markPoint(new Point(2, 3, 'q'));
		
		assertEquals(canvas.getValue(1, 1), 'D');
		assertEquals(canvas.getValue(w, 1), 'X');
		assertEquals(canvas.getValue(1, h), '5');
		assertEquals(canvas.getValue(w, h), '*');
		assertEquals(canvas.getValue(2, 3), 'q');
	}
	
	@Test
	void testClearCanvas() {
		canvas.markPoint(new Point(1, 1, 'D'));
		canvas.markPoint(new Point(w, 1, 'X'));
		canvas.markPoint(new Point(1, h, '5'));
		canvas.markPoint(new Point(w, h, '*'));
		canvas.markPoint(new Point(2, 3, 'q'));
		canvas.clear();
		testInitialContent();
	}
}
