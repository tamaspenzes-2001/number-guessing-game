package numberGuessingGame;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
	public static void clearScreen() {
		if (System.getProperty("os.name").contains("Windows")) {
		    try {
		        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		    } catch (IOException | InterruptedException e) {
		    	e.printStackTrace();
		    }
		} else {
			try {
				new ProcessBuilder("clear").inheritIO().start().waitFor();				
			} catch (IOException | InterruptedException e) {
		    	e.printStackTrace();
		    }
		}
	}
	
	public static int promptUserForNumber(Scanner input) {
		int number;
		while (true) {
			try {
				System.out.print("Guess the correct number between 0 and ");
				number = input.nextInt();
				input.nextLine();
				if (number < 0) {
				   System.out.println("Please provide a non-negative number!");
				   continue;
				}
				return number;
			}
			catch (InputMismatchException e) {
				System.out.println("Please provide a number!");
				input.nextLine();
			}
		}
	}
}
