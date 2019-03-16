package main.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RectangleTests {

	Rectangle rect;
	
	@Test
	public void testNormalRectangle() {
		rect = new Rectangle(new Point(1, 3), new Point(5, 6));
		List<Point> points = rect.getPoints();
		
		Point[] topPoints = {new Point(1,3), new Point(2,3), new Point(3,3), new Point(4,3), new Point(5,3)};
		Point[] bottomPoints = {new Point(1,6), new Point(2,6), new Point(3,6), new Point(4,6), new Point(5,6)};
		Point[] leftPoints = {new Point(1,3), new Point(1,4), new Point(1,5), new Point(1,6)};
		Point[] rightPoints = {new Point(5,3), new Point(5,4), new Point(5,5), new Point(5,6)};
		
		List<Point> expectedPoints = new ArrayList<>();
		expectedPoints.addAll(Arrays.asList(topPoints));
		expectedPoints.addAll(Arrays.asList(bottomPoints));
		expectedPoints.addAll(Arrays.asList(leftPoints));
		expectedPoints.addAll(Arrays.asList(rightPoints));
		
		assertEquals(expectedPoints.size(), points.size());
		
		for (int i = 0; i < expectedPoints.size(); i++) {
			assertEquals(expectedPoints.get(i).getX(), points.get(i).getX());
			assertEquals(expectedPoints.get(i).getY(), points.get(i).getY());
		}
	}
}
