package Game;

import Utilities.Display;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class GameLauncher {
    private Scanner in;

    public GameLauncher() {
        in = new Scanner(System.in);
    }

    public void start() {
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
//              TODO  showInstructions();
                break;
            case 3:
                System.exit(0);
        }
    }

    private void startGame() {
        clearScreen();
        System.out.println("Please select game mode:\n");
        Menu gameModes = new Menu("Single Player", "Double Player");
        gameModes.displayMenu();

        int selectedGameMode = selectMenuOption(gameModes);
        if (selectedGameMode == 1){
            String playerName = getPlayerName();
            // TODO Upgraded players
//            isVeteran(playerName);
            QuestionCategory category = getCategory();
            //testing only TODO to remove the souts
            System.out.println("Selected category: " + category);
            System.out.println("Selected game mode: " + GameMode.SINGLE);
            System.out.println("Player name: " + playerName);

            SinglePlayerGame game = new SinglePlayerGame(category, playerName);
            game.playGame();
        } else {
            //TODO see taking this logic into a method
            QuestionCategory category = getCategory();
            Game game = new DoublePlayerGame(category, GameMode.DOUBLE);
        }
    }

    private QuestionCategory getCategory() {
        System.out.print("You can answer questions from certain category or answer questions from random categories. " +
                        "\nPlease select Questions Category from the list below: \n\n");
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
        Display.drawLine();
        System.out.println("\nPlease select an option and enter it: ");
        int selected = Integer.parseInt(in.nextLine());
        while (selected > menu.getMenuSize()) {
            System.out.printf("The valid options are from %d to %d. Please make a new entry:\n", 1, menu.getMenuSize());
            selected = Integer.parseInt(in.nextLine());
        }
        return selected;
    }

    //TODO Try clear Screen methods
    private static void clearScreen() {

//        System.out.print('\u000C');
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
//        System.out.print("\033[H\033[2J");
//        System.out.flush();

//        try
//        {
//            final String os = System.getProperty("os.name");
//
//            if (os.contains("Windows"))
//            {
//                Runtime.getRuntime().exec("cls");
//            }
//            else
//            {
//                Runtime.getRuntime().exec("clear");
//            }
//        }
//        catch (final Exception e)
//        {
//            //  Handle any exceptions.
//        }
    }
    private void showGameName() {
        System.out.printf("   _    _    _    _    _    _    _    _  \n" +
                "  / \\  / \\  / \\  / \\  / \\  / \\  / \\  / \\ \n" +
                " ( Q )( U )( I )( Z )( Z )( Z )( E )( R )\n" +
                "  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/ \n");


        Display.drawLine();
        System.out.println("QUIZZZER GAME");
        Display.drawLine();
    }

    //TODO Check rendering in a table: https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console

    public static void main(String[] args) {
        GameLauncher launcher = new GameLauncher();
        launcher.start();

    }

}
