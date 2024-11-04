package numberGuessingGame;

public class GameState {
	private int score = 0;

	public int getScore() {
		return score;
	}

	public void increaseScore(int amount) {
		score += amount;
	}
}
