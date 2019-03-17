public class ShapeFactory {
	
	public static Shape createShape(String type, int... values) {
		Shape shape = null;
		switch(type) {
			case "L": {
				Point start = new Point(values[0], values[1]);
				Point end = new Point(values[2], values[3]);
				shape = new Line(start, end);
				break;
			}
			case "R": {
				Point leftTop = new Point(values[0], values[1]);
				Point rightBottom = new Point(values[2], values[3]);
				shape = new Rectangle(leftTop, rightBottom);
				break;
			}
			default: {
				shape = null;
				break;
			}
		}
		return shape;
	}
}
