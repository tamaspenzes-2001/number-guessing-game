package numberGuessingGame;

public class GameState {
	private int score = 0;
	private String rank = "Guessing Apprentice";
	private String nextRankUp = "50";

	public int getScore() {
		return score;
	}

	public void increaseScore(int amount) {
		score += amount;
		modifyRank();
	}
	
	private void modifyRank() {
		int[] ranks = {1000, 500, 100, 50};
		String[] rankNames = {"Unbeatable Guessing Expert", "Guessing Expert", "Guessing Master", "Guessing Pro"};
		String[] nextRankUps = {"You already reached the highest rank!", "1000", "500", "100"};
		for (int i = 0; i < ranks.length; i++) {
		    if (score >= ranks[i]) {
		        rank = rankNames[i];
		        nextRankUp = nextRankUps[i];
		        break;
		    }
		}
	}

	public String getRank() {
		return rank;
	}

	public String getNextRankUp() {
		return nextRankUp;
	}
}
