import java.util.ArrayList;
import java.util.List;

public class Line implements Shape {

	private Point start;
	private Point end;
	
	@SuppressWarnings("unused")
	private Line() {}
	
	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public List<Point> getPoints() {	
		if(start.getY() == end.getY()) {
			return getHorizontalLinePoints();
		} else if (start.getX() == end.getX()) {
			return getVerticalLinePoints();
		} else {
			return getInclinedLinePoints();
		}
	}
	
	private List<Point> getHorizontalLinePoints() {
		List<Point> points = new ArrayList<Point>();
		
		for (int x = start.getX(); x <= end.getX(); x++)
			points.add(new Point(x, start.getY(), 'x'));
		
		return points;
	}
	
	private List<Point> getVerticalLinePoints() {
		List<Point> points = new ArrayList<Point>();
		
		for (int y = start.getY(); y <= end.getY(); y++)
			points.add(new Point(start.getX(), y, 'x'));
		
		return points;
	}
	
	private List<Point> getInclinedLinePoints() {
		List<Point> points = new ArrayList<Point>();
		System.out.println("Inclined lines are not supported in this version.");
		return points;
	}
}
