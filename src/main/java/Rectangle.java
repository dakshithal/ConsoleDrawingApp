package main.java;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape {

	private Point leftTop, rightTop, leftBottom, rightBottom;
	private Line top, bottom, left, right;
	
	@SuppressWarnings("unused")
	private Rectangle() {}
	
	public Rectangle(Point leftTop, Point rightBottom) {
		this.leftTop = leftTop;
		this.rightBottom = rightBottom;
		this.rightTop = new Point(rightBottom.getX(), leftTop.getY());
		this.leftBottom = new Point(leftTop.getX(), rightBottom.getY());
		
		top = new Line(this.leftTop, this.rightTop);
		bottom = new Line(this.leftBottom, this.rightBottom);
		left = new Line(this.leftTop, this.leftBottom);
		right = new Line(this.rightTop, this.rightBottom);
	}
	
	@Override
	public List<Point> getPoints() {
		List<Point> points = new ArrayList<>();
		points.addAll(top.getPoints());
		points.addAll(bottom.getPoints());
		points.addAll(left.getPoints());
		points.addAll(right.getPoints());
		
		return points;
	}

}
