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
		GameState gameState = new GameState();
		while (true) {
			Utils.clearScreen();
			round(input, gameSettings, gameState);
			Utils.pressEnterToContinue(input);
			if (gameSettings.isCasinoMode() && gameState.getScore() == 0) { // score never goes below zero (see GameState)
				Utils.clearScreen();
				System.out.println("You lost all your score! You got kicked off!");
				System.exit(0);
			}
			menu(input, gameSettings, gameState);
		}
	}

	private static void menu(Scanner input, GameSettings gameSettings, GameState gameState) {
		while (true) {				
			Utils.clearScreen();
			System.out.println("Your score: " + gameState.getScore());
			System.out.println("Your rank: " + gameState.getRank());
			System.out.println("Score for next rank up: " + gameState.getNextRankUp());
			int menuOption = Utils.promptUserForNumber(input, "\nWhat to do now?"
					+ "\n1. Guess another number"
					+ "\n2. Modify settings (maximum number, number of guesses, casino mode)"
					+ "\n3. Quit\n", 3);
			switch (menuOption) {
				case 1: return;
				case 2: modifySettings(input, gameSettings);
				break;
				case 3: {
					if (Utils.promptUserForYesOrNo(input, "Are you sure you want to quit? ")) {
						System.out.println("Bye then!");
						System.exit(0);
					}
				}
			}
		}
	}

	private static void modifySettings(Scanner input, GameSettings gameSettings) {
		while (true) {
			Utils.clearScreen();
			int setting = Utils.promptUserForNumber(input, "Settings (with current value). Choose one to modify!"
					+ "\n1. Maximum number (" + gameSettings.getMaximumNumber() + ")"
					+ "\n2. Number of guesses (" + gameSettings.getNumberOfGuesses() + ")"
					+ "\n3. Casino mode - lose score if run out of guesses, get kicked off if lost all score (" + (gameSettings.isCasinoMode() ? "on" : "off") + ")"
					+ "\n4. Back to main menu\n", 4);
			switch (setting) {
			case 1: {
				int newMaximumNumber = Utils.promptUserForNumber(input, "Provide new maximum number: ");
				gameSettings.setMaximumNumber(newMaximumNumber);
			}
			break;
			case 2: {
				int newNumberOfGuesses = Utils.promptUserForNumber(input, "Modify number of guesses: ", gameSettings.getMaximumNumber());
				gameSettings.setNumberOfGuesses(newNumberOfGuesses);
			}
			break;
			case 3: {
				if (Utils.promptUserForYesOrNo(input, "Do you want to turn casino mode " + (gameSettings.isCasinoMode() ? "off" : "on") + "? ")) {
					gameSettings.toggleCasinoMode();
				}
			}
			break;
			case 4: return;
			}
		}
	}

	private static void round(Scanner input, GameSettings gameSettings, GameState gameState) {
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
				System.out.println("\nCongrats! You got it!");
				int scoreWon = i <= gameSettings.getNumberOfGuesses() / 2 ? 10 : 5;
				gameState.increaseScore(scoreWon);
				System.out.println("You got " + scoreWon + " score!");
				return;
			}
		}
		System.out.println("\nYou didn't get it. :(");
		System.out.println("Maybe next time.");
		if (gameSettings.isCasinoMode()) {
			gameState.decreaseScore();
			System.out.println("You lost 10 score!");
		}
	}

}
