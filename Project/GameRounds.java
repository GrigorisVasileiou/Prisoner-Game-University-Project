public class GameRounds {
	private Player [] players = new Player[2];
	private int playerIndexNow = 0;
	
	public GameRounds(Player [] players) {
		if (players == null) {
			throw new IllegalArgumentException("Null players array!");
		} else if (players.length != 2) {
			throw new IllegalArgumentException("Expected 2 players!");
		}
		
		// check if we have players
		for (int i = 0; i < players.length; ++i) {
			if (players[i] == null) {
				throw new IllegalArgumentException("Null player in players array!");
			}
		}
		
		this.players = players;
	}
	
	public void playRound() {
		int firstPlayerIndex = firstPlayerIndexForThisRound();
		int secondPlayerIndex = secondPlayerIndexForThisRound();
		
		Player firstPlayer = players[firstPlayerIndex];
		Player secondPlayer = players[secondPlayerIndex];
		
		advancePlayerIndexForNextRound();
		
		// First player plays!
		System.out.println("Player " + firstPlayer + " turn.");
		int firstPlayerPoints = firstPlayer.play(secondPlayer);
		
		// check if the first player was burnt!
		if (firstPlayerPoints > 31) {
			System.out.println("Player " + firstPlayer + " was burned witn " + firstPlayerPoints + " points. Player " + secondPlayer + "wins.");
			secondPlayer.addWin();
			return ;
		}
		
		// Second player plays!
		System.out.println("Player " + secondPlayer + " turn.");
		int secondPlayerPoints = secondPlayer.play(firstPlayer);
		
		if (secondPlayerPoints > 31) {
			System.out.println("Player " + secondPlayer + " was burned witn " + secondPlayerPoints + " points. Player " + firstPlayer + "wins.");
			firstPlayer.addWin();
			return ;
		}
		
		System.out.println("Player " + firstPlayer + " has " + firstPlayerPoints + " points.");
		System.out.println("Player " + secondPlayer + " has " + secondPlayerPoints + " points.");
		
		// check who won based on number of points!
		if (firstPlayerPoints < secondPlayerPoints) {
			System.out.println("Player " + secondPlayer + " wins!");
			secondPlayer.addWin();
		} else {
			System.out.println("Player " + firstPlayer + " wins!");
			firstPlayer.addWin();
		}
	}
	
	/**
	 * Print the score of each player.
	 */
	public void printScore() {
		for (int i = 0; i < players.length; ++i) {
			System.out.println(players[i] + " has won " + players[i].getNumRoundsWon() + " rounds.");
		}
	}
	
	/**
	 * Calculate for the next round who plays first
	 */
	private void advancePlayerIndexForNextRound() {
		playerIndexNow = (playerIndexNow + 1)%2;
	}
	
	
	private int firstPlayerIndexForThisRound() {
		return playerIndexNow;
	}
	private int secondPlayerIndexForThisRound() {
		return (playerIndexNow + 1)%2;
	}
}
