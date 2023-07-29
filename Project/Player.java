public abstract class Player {
	private String name;
	private int numRoundsWon;
	
	public Player(String name) {
		this.name = name;
		numRoundsWon = 0;
	}
	
	/**
	 * Return the player with the most winning rounds or null if we have draw.
	 */
	public Player declareWinner(Player other) {
		if (other == null) {
			throw new IllegalArgumentException("Null other player");
		}
		
		if (this.numRoundsWon < other.numRoundsWon) {
			return other;
		} else if (this.numRoundsWon == other.numRoundsWon) {
			return null; // DRAW!
		} else {
			return this;
		}
	}
	
	/**
	 * Play against the other player and return the points of this player.
	 */
	public int play(Player other) {
		if (other == null) {
			throw new IllegalArgumentException("Null other player!");
		}
		
		int points = 0;
		Player currentPlayer = this;
		
		while (points < 26) {
			int selectedNumber = currentPlayer.selectNumber();
			points += selectedNumber;
			System.out.println("Player " + currentPlayer + " selected number: " + selectedNumber + ". Number of points: " + points);
			currentPlayer = currentPlayer == this ? other : this;
		}
		
		return points;
	}
	
	public int getNumRoundsWon() {
		return this.numRoundsWon;
	}
	
	/**
	 * Return the number that was chosen by the player for a round.
	 */
	public abstract int selectNumber();
	
	/**
	 * The string representation contains only the name of the player.
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * Add 1 more win to this player.
	 */
	public void addWin() {
		numRoundsWon = numRoundsWon + 1;
	}
}
