package numberGuessingGame;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		System.out.println("Welcome!");
		System.out.println("Guess the correct number between 0 and 10!");
		Scanner input = new Scanner(System.in);
		boolean guessedSuccessfully = round(input);
		input.close();
		if (guessedSuccessfully) {
			System.out.println("Congrats! You got it!");
		}
		else {
			System.out.println("You didn't get it. :(");
			System.out.println("Maybe next time.");			
		}
	}

	private static boolean round(Scanner input) {
		for (int i = 1; i <= 5; i++) {
			System.out.print("Guess " + i + "/5: ");
			int guess = input.nextInt();
			if (guess > 6) {
				System.out.println("Too high!");
			}
			else if (guess < 6) {
				System.out.println("Too low!");
			}
			else {
				return true;
			}
		}
		return false;
	}

}
