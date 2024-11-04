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
	
	public static int promptUserForNumber(Scanner input, String promptText, Integer... maximumNumber) {
		while (true) {
			try {
				System.out.print(promptText);
				int number = input.nextInt();
				input.nextLine();
				if (number <= 0) {
				    System.out.println("Please provide a positive number!");
				    continue;
				}
				else if (maximumNumber.length != 0 && number > maximumNumber[0]) {
					System.out.println("You can't provide a number higher than " + maximumNumber[0] + "!");
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
	
	public static void pressEnterToContinue(Scanner input) {
		System.out.print("\n[press enter to continue]");
		input.nextLine();
	}
}
