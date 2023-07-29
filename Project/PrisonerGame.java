import java.util.Scanner;

public class PrisonerGame {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int choice = -1;
		
		// Read from the user choice of game
		while ((choice != 1) && (choice != 2)) {
			System.out.print("\nDo you want to play 1. Human vs Computer, or 2. Computer vs Computer? ");
			choice = scanner.nextInt();
		}
		System.out.println();
		
		Player players[] = createPlayers(choice);
		
		GameRounds gameRounds = new GameRounds(players);
		
		// here we player the rounds as long as the user wants
		do {
			gameRounds.playRound();
			
			System.out.println("Round Ended!");
			gameRounds.printScore();
		} while (userWantsAnotherRound());
		
		// The rounds are over!
		// Here we declare the winner
		Player winner = players[0].declareWinner(players[1]);
		
		if (winner == null) {
			System.out.println("No winner! Draw!");
		} else {
			System.out.println("We have a winner! The winner is: " + winner);
		}
	}
	
	private static boolean userWantsAnotherRound() {
		Scanner scanner = new Scanner(System.in);
		String input = "a";
		
		System.out.print("\n\n");
		while ((!input.equalsIgnoreCase("y")) && !input.equalsIgnoreCase("n")) {
			System.out.print("Do you want to play another round [y,n]? ");
			input = scanner.next();
		}
		System.out.print("\n\n");
		
		return input.equalsIgnoreCase("y");
	}
	
	private static Player[] createPlayers(int choice) {
		Player players [] = new Player[2];
		
		if (choice == 1) {
			players[0] = new HumanPlayer("HUMAN");
			players[1] = new ComputerPlayer("COMPUTER");
		} else if (choice == 2) {
			players[0] = new ComputerPlayer("COMPUTER_1");
			players[1] = new ComputerPlayer("COMPUTER_2");
		} else {
			throw new IllegalArgumentException("Invalid choice!");
		}
		
		return players;
	}
}
