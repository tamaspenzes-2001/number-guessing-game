package numberGuessingGame;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Utils.clearScreen();
		System.out.println("Welcome!");
		Scanner input = new Scanner(System.in);
		int maximumNumber = Utils.promptUserForNumber(input, "I want to guess numbers between 1 and ");
		int numberOfGuesses = Utils.promptUserForNumber(input, "I want to have ... number of guesses. ", maximumNumber);
		GameSettings gameSettings = new GameSettings(maximumNumber, numberOfGuesses);
		while (true) {
			Utils.clearScreen();
			round(input, gameSettings);
			Utils.pressEnterToContinue(input);
			Utils.clearScreen();
			int menuOption = Utils.promptUserForNumber(input, "What to do now?"
					+ "\n1. Guess another number"
					+ "\n2. Modify settings (maximum number, number of guesses etc.)"
					+ "\n3. Quit\n", 3);
			switch (menuOption) {
				case 1: continue;
				case 2: modifySettings(gameSettings);
				case 3: return;
			}
		}
	}

	private static void modifySettings(GameSettings gameSettings) {
		// TODO implement
	}

	private static void round(Scanner input, GameSettings gameSettings) {
		RandomNumber number = new RandomNumber(gameSettings.getMaximumNumber());
		System.out.println("Guess the correct number between 1 and " + gameSettings.getMaximumNumber());
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
