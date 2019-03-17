public class InputProcessor {
	
	Canvas canvas;
	
	public boolean validateInputFormat(String input) {
		String[] commandValues = input.split(" ");
		
		if(commandValues.length == 0)
			return false;
		
		String command = commandValues[0];
		
		try {
			if(command.trim().equalsIgnoreCase("C")) {
				if(!(commandValues.length == 3))
					return false;
				
				int w = Integer.parseInt(commandValues[1]);
				int h = Integer.parseInt(commandValues[2]);
				
				if (w <= 0 || h <= 0)
					return false;
				
			} else if(command.trim().equalsIgnoreCase("L")) {
				if(!(commandValues.length == 5)) 
					return false;
				
				int x1 = Integer.parseInt(commandValues[1]);
				int y1 = Integer.parseInt(commandValues[2]);
				int x2 = Integer.parseInt(commandValues[3]);
				int y2 = Integer.parseInt(commandValues[4]);
				
				if (x1 <= 0 || y1 <= 0 || x2 <= 0 || y2 <= 0)
					return false;
	
			} else if(command.trim().equalsIgnoreCase("R")) {
				if(!(commandValues.length == 5))
					return false;
				
				int x1 = Integer.parseInt(commandValues[1]);
				int y1 = Integer.parseInt(commandValues[2]);
				int x2 = Integer.parseInt(commandValues[3]);
				int y2 = Integer.parseInt(commandValues[4]);
				
				if (x1 <= 0 || y1 <= 0 || x2 <= 0 || y2 <= 0)
					return false;
	
			} else if(command.trim().equalsIgnoreCase("B")) {
				if(!(commandValues.length == 4)) 
					return false;
				
				int x = Integer.parseInt(commandValues[1]);
				int y = Integer.parseInt(commandValues[2]);
				
				if (x <= 0 || y <= 0)
					return false;
				
				if (commandValues[3].length() != 1)
					return false;
	
			} else if(command.trim().equalsIgnoreCase("D")) {
				if(!(commandValues.length == 1)) 
					return false;
				
			} else if(command.trim().equalsIgnoreCase("Q")) {
				if(!(commandValues.length == 1)) 
					return false;
				
			} else {
				return false;
			}
		} catch (NumberFormatException ex) {
			return false;
		}
		
		return true;
	}
	
	public void printInvalidInputFormatMsg() {
		System.out.println("Error : Invalid input format!");
		System.out.println("Valid commands		: ");
		System.out.println("C <w> <h> 		: Creates a new canvas of width w and height h");
		System.out.println("L <x1> <y1> <x2> <y2> 	: Creates a new line from (x1,y1) to (x2,y2)");
		System.out.println("R <x1> <y1> <x2> <y2> 	: Creates a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2)");
		System.out.println("B <x> <y> <c>		: Bucket fill colour <c> strating from point <x,y>");
		System.out.println("D 			: Delete drawings on current canvas");
		System.out.println("Q 			: Quits the program\n");
	}
	
	public String validateInputValues(String input) {
		String[] commandValues = input.split(" ");
		
		String command = commandValues[0];
		int width = 0;
		int height = 0;
		
		if((command.trim().equalsIgnoreCase("C"))) {
			int w = Integer.parseInt(commandValues[1]);
			int h = Integer.parseInt(commandValues[2]);
			if (w > 100 || h > 32)
				return "Error : Maximum canvas size supported is 100x32\n";
			
		} else {
			if(canvas == null)
				return "Error : Please create a canvas first.\n";
			else {
				width = canvas.getWidth();
				height = canvas.getHeight();
			}
		}
		
		if(command.trim().equalsIgnoreCase("L")) {
			int x1 = Integer.parseInt(commandValues[1]);
			int y1 = Integer.parseInt(commandValues[2]);
			int x2 = Integer.parseInt(commandValues[3]);
			int y2 = Integer.parseInt(commandValues[4]);
			
			if (x1 > width || y1 > height || x2 > width || y2 > height)
				return "Error : Input values exceed canvas size!\n";
			
			if (x1 > x2 || y1 > y2)
				return "Error : Line end coordinates should have a higher values than line start coordinates!\n";

		} else if(command.trim().equalsIgnoreCase("R")) {
			int x1 = Integer.parseInt(commandValues[1]);
			int y1 = Integer.parseInt(commandValues[2]);
			int x2 = Integer.parseInt(commandValues[3]);
			int y2 = Integer.parseInt(commandValues[4]);
			
			if (x1 > width || y1 > height || x2 > width || y2 > height)
				return "Error : Input values exceed canvas size!\n";
			
			if (x1 > x2 || y1 > y2)
				return "Error : Right bottom corner cordinates should be higher than left top corner coordinates!\n";

		} else if(command.trim().equalsIgnoreCase("B")) {			
			int x = Integer.parseInt(commandValues[1]);
			int y = Integer.parseInt(commandValues[2]);
			
			if (x > width || y > height)
				return "Error : Input values exceed canvas size!\n";
		} 
		
		return "";		
	}

	public void processInput(String input) {
		String[] commandValues = input.split(" ");
		String command = commandValues[0];
		Shape shape;
		
		if(command.trim().equalsIgnoreCase("C")) {		
			int w = Integer.parseInt(commandValues[1]);
			int h = Integer.parseInt(commandValues[2]);
			canvas = new Canvas(w, h);
			
		} else if(command.trim().equalsIgnoreCase("L")) {
			int x1 = Integer.parseInt(commandValues[1]);
			int y1 = Integer.parseInt(commandValues[2]);
			int x2 = Integer.parseInt(commandValues[3]);
			int y2 = Integer.parseInt(commandValues[4]);
			shape = ShapeFactory.createShape("L", x1, y1, x2, y2);
			canvas.draw(shape);

		} else if(command.trim().equalsIgnoreCase("R")) {			
			int x1 = Integer.parseInt(commandValues[1]);
			int y1 = Integer.parseInt(commandValues[2]);
			int x2 = Integer.parseInt(commandValues[3]);
			int y2 = Integer.parseInt(commandValues[4]);
			shape = ShapeFactory.createShape("R", x1, y1, x2, y2);
			canvas.draw(shape);

		} else if(command.trim().equalsIgnoreCase("B")) {
			int x = Integer.parseInt(commandValues[1]);
			int y = Integer.parseInt(commandValues[2]);
			canvas.floodFill(new Point(x,y), ' ', commandValues[3].charAt(0));

		} else if(command.trim().equalsIgnoreCase("D")) {
			canvas.clear();

		}
		
		System.out.println(canvas);
	}
}
