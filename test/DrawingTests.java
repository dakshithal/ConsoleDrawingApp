import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DrawingTests {

	int w = 0;
	int h = 0;
	Canvas canvas;
	
	@BeforeEach
	public void initializeCanvas() {
		w = 20;
		h = 4;
		canvas = new Canvas(w, h);
	}
	
	@Test
	public void floodFillFullTest() {
		canvas.floodFill(new Point(10, 3), ' ', 'o');
		System.out.println(canvas);
		
		for (int x = 1; x <= 20; x++) {
			for (int y = 1; y <= 4; y++) {
				assertEquals('o', canvas.getValue(x, y));
			}
		}
	}
	
	@Test
	public void drawHorizontalLineTest() {
		Line line = new Line(new Point(1, 2), new Point(6, 2));
		canvas.draw(line);
		System.out.println(canvas);
		
		for (int x = 1; x <= 20; x++) {
			for (int y = 1; y <= 4; y++) {
				if (y==2 && (x >=1 && x <= 6))
					assertEquals('x', canvas.getValue(x, y));
				else
					assertEquals(' ', canvas.getValue(x, y));
			}
		}
	}
	
	@Test
	public void drawHorizontalLineAndFloodFillTest() {
		Line line = new Line(new Point(1, 2), new Point(6, 2));
		canvas.draw(line);
		canvas.floodFill(new Point(10, 3), ' ', 'o');
		System.out.println(canvas);
		
		for (int x = 1; x <= 20; x++) {
			for (int y = 1; y <= 4; y++) {
				if (y==2 && (x >=1 && x <= 6))
					assertEquals('x', canvas.getValue(x, y));
				else
					assertEquals('o', canvas.getValue(x, y));
			}
		}
	}
	
	@Test
	public void drawVerticalLineTest() {
		Line line = new Line(new Point(6, 3), new Point(6, 4));
		canvas.draw(line);
		System.out.println(canvas);
		
		for (int x = 1; x <= 20; x++) {
			for (int y = 1; y <= 4; y++) {
				if (x==6 && (y >=3 && y <= 4))
					assertEquals('x', canvas.getValue(x, y));
				else
					assertEquals(' ', canvas.getValue(x, y));
			}
		}
	}
	
	@Test
	public void drawVerticalLineAndFloodFillTest() {
		Line line = new Line(new Point(6, 3), new Point(6, 4));
		canvas.draw(line);
		canvas.floodFill(new Point(10, 3), ' ', 'o');
		System.out.println(canvas);
		
		for (int x = 1; x <= 20; x++) {
			for (int y = 1; y <= 4; y++) {
				if (x==6 && (y >=3 && y <= 4))
					assertEquals('x', canvas.getValue(x, y));
				else
					assertEquals('o', canvas.getValue(x, y));
			}
		}
	}
	
	@Test
	public void drawRectangleTest() {
		Rectangle rect = new Rectangle(new Point(14, 1), new Point(18, 3));
		canvas.draw(rect);
		System.out.println(canvas);
		
		for (int x = 1; x <= 20; x++) {
			for (int y = 1; y <= 4; y++) {
				if ((y==1 || y==3) && (x >=14 && x <= 18))
					assertEquals('x', canvas.getValue(x, y));
				else if ((x==14 || x==18) && (y >=1 && y <= 3))
					assertEquals('x', canvas.getValue(x, y));
				else
					assertEquals(' ', canvas.getValue(x, y));
			}
		}
	}
	
	@Test
	public void drawRectAndFloodFillInTest() {
		Rectangle rect = new Rectangle(new Point(14, 1), new Point(18, 3));
		canvas.draw(rect);
		canvas.floodFill(new Point(15, 2), ' ', 'o');	
		System.out.println(canvas);
		
		for (int x = 1; x <= 20; x++) {
			for (int y = 1; y <= 4; y++) {
				if ((y==1 || y==3) && (x >=14 && x <= 18))
					assertEquals('x', canvas.getValue(x, y));
				else if ((x==14 || x==18) && (y >=1 && y <= 3))
					assertEquals('x', canvas.getValue(x, y));
				else if (y==2 && (x >=15 && x <= 17))
					assertEquals('o', canvas.getValue(x, y));
				else
					assertEquals(' ', canvas.getValue(x, y));
			}
		}
	}
	
	@Test
	public void drawRectAndFloodFillOutTest() {
		Rectangle rect = new Rectangle(new Point(14, 1), new Point(18, 3));
		canvas.draw(rect);
		canvas.floodFill(new Point(10, 3), ' ', 'o');	
		System.out.println(canvas);
		
		for (int x = 1; x <= 20; x++) {
			for (int y = 1; y <= 4; y++) {
				if ((y==1 || y==3) && (x >=14 && x <= 18))
					assertEquals('x', canvas.getValue(x, y));
				else if ((x==14 || x==18) && (y >=1 && y <= 3))
					assertEquals('x', canvas.getValue(x, y));
				else if (y==2 && (x >=15 && x <= 17))
					assertEquals(' ', canvas.getValue(x, y));
				else
					assertEquals('o', canvas.getValue(x, y));
			}
		}
	}
}
