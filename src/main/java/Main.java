package main.java;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.print("enter command: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		while(!input.trim().equalsIgnoreCase("Q")) {
			System.out.print("enter command: ");
			input = scanner.nextLine();
		}
	}

}
