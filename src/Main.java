import java.util.Scanner;

public class Main {

	Canvas canvas;
	
	public static void main(String[] args) {
		
		InputProcessor processor = new InputProcessor();
		
		System.out.print("enter command: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		while(!input.trim().equalsIgnoreCase("Q")) {
			if(processor.validateInputFormat(input)) {
				String valuesError = processor.validateInputValues(input);
				if (valuesError.equals(""))
					processor.processInput(input);
				else
					System.out.println(valuesError);
			}
			else {
				processor.printInvalidInputFormatMsg();
			}
			
			System.out.print("enter command: ");
			input = scanner.nextLine();
		}
		
		System.out.print("Bye!");
		scanner.close();
	}
	
}
