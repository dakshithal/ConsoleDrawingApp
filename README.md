# ConsoleDrawingApp
A console drawing app developed in java

Pre-Requisites:
- Java 1.8 or above

How to run:
- Extract ConsoleDrawingApp.zip file
- Navigate inside the extracted folder
- Find DrawingApp.jar file inside the folder
- Open a command prompt and navigate to DrawingApp.jar location
- Execute command "java -jar .\DrawingApp.jar"
- Program will start. You can continue to drawing using below commands.

Supported Commands:
C <w> <h> 				: Creates a new canvas of width w and height h
L <x1> <y1> <x2> <y2> 	: Creates a new line from (x1,y1) to (x2,y2)
R <x1> <y1> <x2> <y2> 	: Creates a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2)
B <x> <y> <c>			: Bucket fill colour <c> strating from point <x,y>
D 						: Delete drawings on current canvas
Q 						: Quits the program

Assumptions/Improvements Made:
- Maximum canvas size of 100 x 32 is supported.
- Commands will be validated before execution for below scenarios:
	- Trying to create canvas beyond max size
	- Non Positive input values for coordinates/canvas size
	- Input values violating supported command formats
	- Input values residing outside the current canvas
	- Line end coordinates should be greater than line start coordinates
	- Rectangle right bottom corner coordinate values should be greater than left top corner coordinate values
- A command to clear the drawings on current canvas was also implemented.

Source Code:
ConsoleDrawingApp\src

Test Code:
ConsoleDrawingApp\test