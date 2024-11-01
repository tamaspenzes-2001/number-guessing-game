package numberGuessingGame;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Utils.clearScreen();
		System.out.println("Welcome!");
		while (true) {
			Scanner input = new Scanner(System.in);
			int maximumNumber = Utils.promptUserForNumber(input, "Guess the correct number between 1 and ");
			int numberOfGuesses = Utils.promptUserForNumber(input, "How many guesses do you want to have? ", maximumNumber);
			GameSettings gameSettings = new GameSettings(maximumNumber, numberOfGuesses);
			round(input, gameSettings);
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

	private static void round(Scanner input, GameSettings gameSettings) {
		RandomNumber number = new RandomNumber(gameSettings.getMaximumNumber());
		for (int i = 1; i <= gameSettings.getNumberOfGuesses(); i++) {
			int guess = Utils.promptUserForNumber(input, "Guess " + i + "/" + gameSettings.getNumberOfGuesses() + ": ", gameSettings.getMaximumNumber());
			if (guess > number.getNumber()) {
				System.out.println("Too high!");
			}
			else if (guess < number.getNumber()) {
				System.out.println("Too low!");
			}
			else {
				System.out.println("Congrats! You got it!");
				return;
			}
		}
		System.out.println("You didn't get it. :(");
		System.out.println("Maybe next time.");	
	}

}
