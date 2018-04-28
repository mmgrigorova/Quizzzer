package Game;

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
    private void showGameName() {
        for (int i = 0; i < 40; i++) {
            System.out.printf("-");
        }
        System.out.println();
        System.out.println("QUIZZZER GAME");
        for (int i = 0; i < 40; i++) {
            System.out.printf("-");
        }
        System.out.println();
    }
    private void startGame() {
        clearScreen();
        System.out.println("Please select game mode:");
        Menu gameModes = new Menu("Single Player", "Double Player");
        gameModes.displayMenu();
        int selectedGameMode = selectMenuOption(gameModes);
        if (selectedGameMode == 1){
            Game singlePlayer = new SinglePlayerGame();
        } else {
            Game doublePlayer = new DoublePlayerGame();
        }
    }

    private int selectMenuOption(Menu menu) {
        for (int i = 0; i < 40; i++) {
            System.out.printf("-");
        }
        System.out.println();
        System.out.println("Please select an option and enter it: ");
        int selected = Integer.parseInt(in.nextLine());
        while (selected > menu.getMenuSize()) {
            System.out.printf("The valid options are from %d to %d. Please make a new entry:", 1, menu.getMenuSize());
            System.out.println();
            selected = Integer.parseInt(in.nextLine());
        }
        return selected;
    }

    //TODO Try clear Screen methods
    private static void clearScreen() {

//        System.out.print('\u000C');
//        for (int i = 0; i < 25; i++) {
//            System.out.println();
//        }
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

}
