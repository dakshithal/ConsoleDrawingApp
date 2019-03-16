package main.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LineTests {
	
	Line line;

	@Test
	public void testHorizontalLinePoints() {
		line = new Line(new Point(5, 3), new Point(9, 3));
		List<Point> points = line.getPoints();
		
		List<Point> expectedPoints = new ArrayList<>();
		expectedPoints.add(new Point(5,3));
		expectedPoints.add(new Point(6,3));
		expectedPoints.add(new Point(7,3));
		expectedPoints.add(new Point(8,3));
		expectedPoints.add(new Point(9,3));
		
		assertEquals(expectedPoints.size(), points.size());
		
		for (int i = 0; i < expectedPoints.size(); i++) {
			assertEquals(expectedPoints.get(i).getX(), points.get(i).getX());
			assertEquals(expectedPoints.get(i).getY(), points.get(i).getY());
		}
	}
	
	@Test
	public void testVerticalLinePoints() {
		line = new Line(new Point(3, 3), new Point(3, 8));
		List<Point> points = line.getPoints();
		
		List<Point> expectedPoints = new ArrayList<>();
		expectedPoints.add(new Point(3,3));
		expectedPoints.add(new Point(3,4));
		expectedPoints.add(new Point(3,5));
		expectedPoints.add(new Point(3,6));
		expectedPoints.add(new Point(3,7));
		expectedPoints.add(new Point(3,8));
		
		assertEquals(expectedPoints.size(), points.size());
		
		for (int i = 0; i < expectedPoints.size(); i++) {
			assertEquals(expectedPoints.get(i).getX(), points.get(i).getX());
			assertEquals(expectedPoints.get(i).getY(), points.get(i).getY());
		}
	}
}
