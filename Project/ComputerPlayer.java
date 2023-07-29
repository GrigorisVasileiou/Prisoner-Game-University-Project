import java.util.Random;

public class ComputerPlayer extends Player {
	private static int RANDOM_NUMBER_MIN = 1;
	private static int RANDOM_NUMBER_MAX = 5;
	
	private Random random = new Random();
	
	public ComputerPlayer(String name) {
		super(name);
	}

	/**
	 * The number selected is a random number between 1 and 5
	 */
	@Override
	public int selectNumber() {
		// Return a random number in range [min, max).
		return random.nextInt(RANDOM_NUMBER_MAX + 1 - RANDOM_NUMBER_MIN) + RANDOM_NUMBER_MIN;
	}
}
