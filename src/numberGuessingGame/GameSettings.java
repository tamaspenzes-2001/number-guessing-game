package numberGuessingGame;

public class GameSettings {
	private int maximumNumber;
	private int numberOfGuesses;

	public GameSettings(int maximumNumber, int numberOfGuesses) {
		this.maximumNumber = maximumNumber;
		this.numberOfGuesses = numberOfGuesses;
	}
	
	public int getMaximumNumber() {
		return maximumNumber;
	}
	
	public void setMaximumNumber(int maximumNumber) {
		this.maximumNumber = maximumNumber;
	}

	public int getNumberOfGuesses() {
		return numberOfGuesses;
	}

	public void setNumberOfGuesses(int numberOfGuesses) {
		this.numberOfGuesses = numberOfGuesses;
	}
}
