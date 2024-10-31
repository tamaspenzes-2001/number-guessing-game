package numberGuessingGame;

import java.util.Random;

public class RandomNumber {
	private int number;

	public RandomNumber() {
		Random random = new Random();
		number = random.nextInt(11);
	}

	public int getNumber() {
		return number;
	}
}
