package Game;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;

public class GameLauncher {
	private Scanner in;

	public GameLauncher() {
		in = new Scanner(System.in);
	}

	public void start() throws LineUnavailableException, InterruptedException {
		showGameName();
		Menu welcomeMenu = new Menu("New Game", "How to Play", "Exit Game");
		welcomeMenu.displayMenu();
		int selectedMenuOption = selectMenuOption(welcomeMenu);
		clearScreen();
		switch (selectedMenuOption) {
		case 1:
			startGame();
			break;
		case 2:
			// TODO showInstructions();
			break;
		case 3:
			System.exit(0);
		}
	}

	private void showGameName() throws LineUnavailableException {
		GameSound sound = new GameSound();
		System.out.printf("   _    _    _    _    _    _    _    _  \n"
				+ "  / \\  / \\  / \\  / \\  / \\  / \\  / \\  / \\ \n" + " ( Q )( U )( I )( Z )( Z )( Z )( E )( R )\n"
				+ "  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/ \n");

		for (int i = 0; i < 40; i++) {
			System.out.printf("-");
		}
		System.out.println();
		//System.out.println("QUIZZZER GAME");
		char [] name = {'Q','U','I','Z','Z','Z','E','R',' ','G','A','M','E'};
		int hz = 500;
		int msec = 150;
		for (int i = 0; i < 8; i++, hz += 100, msec += 50) {
			System.out.print(name[i]);
			sound.tone(hz, msec);
		}
		System.out.print(' ');
		for (int i = 9; i < name.length; i++, hz -= 100, msec -= 100) {
			System.out.print(name[i]);
			sound.tone(hz, 250);
		}
		System.out.println();
		for (int i = 0; i < 40; i++) {
			System.out.printf("-");
		}
		System.out.println();
	}

	private void startGame() throws InterruptedException, LineUnavailableException {
		clearScreen();
		System.out.println("Please select game mode:\n");
		Menu gameModes = new Menu("Single Player", "Double Player");
		gameModes.displayMenu();

		int selectedGameMode = selectMenuOption(gameModes);
		if (selectedGameMode == 1) {
			String playerName = getPlayerName();
			// TODO Upgraded players
			// isVeteran(playerName);
			QuestionCategory category = getCategory();
			// testing only TODO to remove the souts
			System.out.println("Selected category: " + category);
			System.out.println(GameMode.SINGLE);

			Game game = new SinglePlayerGame(category, playerName);
		} else {
			String playerName = getPlayerName();
			QuestionCategory category = getCategory();
			Game game = new DoublePlayerGame(category, playerName);
		}
	}

	private QuestionCategory getCategory() throws InterruptedException, LineUnavailableException {
		System.out.print("You can answer questions from certain category or answer questions from random categories. "
				+ "\nPlease select Questions Category from the list below: \n\n");
		Menu questionCategories = new Menu(QuestionCategory.toArray());
		questionCategories.displayMenu();
		int categoryKey = selectMenuOption(questionCategories);
		return QuestionCategory.getCategoryByKey(categoryKey);
	}

	private String getPlayerName() {
		System.out.println("Please enter your name: ");
		return in.nextLine();
	}

	private int selectMenuOption(Menu menu) {
		for (int i = 0; i < 40; i++) {
			System.out.printf("-");
		}
		System.out.println("\nPlease select an option and enter it: ");
		int selected = Integer.parseInt(in.nextLine());
		while (selected > menu.getMenuSize() || selected <= 0) {
			System.out.printf("The valid options are from %d to %d. Please make a new entry:\n", 1, menu.getMenuSize());

			selected = Integer.parseInt(in.nextLine());
		}
		return selected;
	}

	// TODO Try clear Screen methods
	private static void clearScreen() {

		for (int i = 0; i < 5; i++) {
			System.out.println();
		}

	}

	public static void main(String[] args) throws LineUnavailableException, InterruptedException {
		/*
		 * GameSound sound = new GameSound(); sound.tone(1000, 100); sound.tone(1000,
		 * 1000); sound.tone(5000, 1000); sound.tone(400, 500); sound.tone(400, 500,
		 * 0.5); // sound.tone(1000,100);
		 */
		GameLauncher launcher = new GameLauncher();
		launcher.start();

	}

}
