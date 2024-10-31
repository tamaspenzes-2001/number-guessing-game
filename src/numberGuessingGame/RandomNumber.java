package numberGuessingGame;

import java.util.Random;

public class RandomNumber {
	private int number;

	public RandomNumber(int maximumNumber) {
		Random random = new Random();
		number = random.nextInt(maximumNumber+1);
	}

	public int getNumber() {
		return number;
	}
}
