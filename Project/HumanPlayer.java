import java.util.Scanner;

public class HumanPlayer extends Player{

	public HumanPlayer(String name) {
		super(name);
	}

	/**
	 * Ask the user for a number between 1 and 5
	 */
	@Override
	public int selectNumber() {
		Scanner scanner = new Scanner(System.in);
		int number = -1;
		
		while (true) {
			System.out.print("Give a number between 1 and 5: ");
			number = scanner.nextInt();
			
			if (!isInputNumberValid(number)) {
				System.out.println("\nThis number is not correct! The number must be in range [1,5]");
			} else {
				break;
			}
		}
		
		return number;
	}

	// Check if the number input by the user is correct
	private boolean isInputNumberValid(int number) {
		return (number >= 1) && (number <= 5);
	}
}
