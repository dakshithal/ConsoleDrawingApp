package main.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Canvas {
	private Point[][] canvas;
	private int width = 0;	
	private int height = 0;
	
	@SuppressWarnings("unused")
	private Canvas() {};
	
	public Canvas(int width, int height) {
		this.width = width;
		this.height = height;		
		this.canvas = new Point[width + 2][height + 2];

		for (int x = 0; x < width + 2; x++) {
			for (int y = 0; y < height + 2; y++) {
				canvas[x][y] = new Point(x, y, ' ');
			}
		}
		
		for(int x = 0; x < width + 2; x++) {
			canvas[x][0].setValue('-');
			canvas[x][height + 1].setValue('-');
		}
		
		for(int y = 1; y < height + 1; y++) {
			canvas[0][y].setValue('|');
			canvas[ width + 1][y].setValue('|');
		}
	}
	
	public char getValue(int x, int y) {
		return canvas[x][y].getValue();
	}
	
	public void markPoint(Point p) {
		canvas[p.getX()][p.getY()].setValue(p.getValue());
	}
	
	public void clear() {
		for (int x = 1; x <= width; x++) {
			for (int y = 1; y <= height; y++) {
				canvas[x][y].setValue(' ');
			}
		}
	}
	
	public void draw(Shape shape) {
		List<Point> points = shape.getPoints();
		points.forEach(p -> markPoint(p));
	}
	
	public void floodFill(Point point, char targetValue, char replacementValue) {
		if (targetValue == replacementValue)
			return;
		
		if (point.getValue() != targetValue)
			return;
		
		point.setValue(replacementValue);
		
		Queue<Point> points = new LinkedList<>();
		
		points.add(point);
		
		while (points.size() > 0) {
			Point p = points.remove();
			int x = p.getX();
			int y = p.getY();
			
			Point west = canvas[x-1][y];
			Point east = canvas[x+1][y];
			Point north = canvas[x][y-1];
			Point south = canvas[x][y+1];
			
			if (west.getValue() == targetValue) {
				west.setValue(replacementValue);
				points.add(west);
			}
			if (east.getValue() == targetValue) {
				east.setValue(replacementValue);
				points.add(east);
			}
			if (north.getValue() == targetValue) {
				north.setValue(replacementValue);
				points.add(north);
			}
			if (south.getValue() == targetValue) {
				south.setValue(replacementValue);
				points.add(south);
			}
		}
	}
	
	@Override
	public String toString() {
		String drawing = "";
		for (int y = 0; y < height + 2; y++) {
			for (int x = 0; x < width + 2; x++) {
				drawing = drawing + canvas[x][y];
			}
			drawing = drawing + "\n";
		}
		
		return drawing;
	}
	
}
