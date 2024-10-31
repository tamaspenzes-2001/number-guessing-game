package numberGuessingGame;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		System.out.println("Welcome!");
		Scanner input = new Scanner(System.in);
		System.out.print("Guess the correct number between 0 and ");
		int maximumNumber = input.nextInt();
		boolean guessedSuccessfully = round(input, maximumNumber);
		input.close();
		if (guessedSuccessfully) {
			System.out.println("Congrats! You got it!");
		}
		else {
			System.out.println("You didn't get it. :(");
			System.out.println("Maybe next time.");			
		}
	}

	private static boolean round(Scanner input, int maximumNumber) {
		RandomNumber number = new RandomNumber(maximumNumber);
		for (int i = 1; i <= 5; i++) {
			System.out.print("Guess " + i + "/5: ");
			int guess = input.nextInt();
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
