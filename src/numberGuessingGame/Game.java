package numberGuessingGame;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Utils.clearScreen();
		System.out.println("Welcome!");
		while (true) {
			Scanner input = new Scanner(System.in);
			int maximumNumber = Utils.promptUserForNumber(input);
			GameSettings gameSettings = new GameSettings(maximumNumber, 5);
			boolean guessedSuccessfully = round(input, gameSettings);
			if (guessedSuccessfully) {
				System.out.println("Congrats! You got it!");
			}
			else {
				System.out.println("You didn't get it. :(");
				System.out.println("Maybe next time.");			
			}
			System.out.println("Want to guess another number?");
			String quit = input.next();
			if (quit.equalsIgnoreCase("yes")) {
				Utils.clearScreen();
			}
			else {
				System.out.println("Ok bye!");
				return;
			}
		}
	}

	private static boolean round(Scanner input, GameSettings gameSettings) {
		RandomNumber number = new RandomNumber(gameSettings.getMaximumNumber());
		for (int i = 1; i <= gameSettings.getNumberOfGuesses(); i++) {
			System.out.print("Guess " + i + "/" + gameSettings.getNumberOfGuesses() + ": ");
			int guess = input.nextInt();
			input.nextLine();
			if (guess > number.getNumber()) {
				System.out.println("Too high!");
			}
			else if (guess < number.getNumber()) {
				System.out.println("Too low!");
			}
			else {
				return true;
			}
		}
		return false;
	}

}
