package Game;


import utilities.Display;
import utilities.AppendingObjectOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class GameLauncher {
    private Scanner in;
    private Game game;

    public GameLauncher() {
        in = new Scanner(System.in);
    }

    public void start() {
        showGameName();
        Game.loadData();
        
        Menu welcomeMenu = new Menu("New Game", "Ranklist", "Add new question", "How to Play", "Save and Exit Game");
        int selectedMenuOption;
        
        do {
        	 welcomeMenu.displayMenu();
             selectedMenuOption = selectMenuOption(welcomeMenu);
             switch (selectedMenuOption) {
                 case 1:
                     startGame();
                     break;
                 case 2:
                 	 Game.showRanklist();
                 	 break;
                 case 3:
                	 addQuestion();
                	 
                	 break;
                 case 4:
                	 
                     //TODO  showInstructions();  
                	 for (Question q : Game.questions) {
                		 System.out.println(q.toString());
                	 }
                     break;
                 case 5:
                 	 Game.saveGame();
                     //System.exit(0);
             }
        } while (selectedMenuOption != 5);   
    }
    private void startGame() {
        //clearScreen();
        showGameName()
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

            System.out.println("Game mode: " + GameMode.SINGLE);
            // Hello, [playerName], you have ... points
            
            game = new SinglePlayerGame(category, playerName);
            game.playGame();
        } else {
        	String playerName1 = getPlayerName();
        	String playerName2 = getPlayerName();
        	QuestionCategory category = getCategory();
        	System.out.println("Selected category: " + category);
            System.out.println("Game mode: " + GameMode.DOUBLE);
            
        	game = new DoublePlayerGame(category, playerName1, playerName2);
        	game.playGame();

        }
    }
    
    public void addQuestion() {
    	Question newQuestion = null;
    	
    	//get user input
		//System.out.print("Enter question category: ");
		QuestionCategory category = getCategory();
		
		System.out.println("1. Multi-answer question");
		System.out.println("2. Open-answer question");
		System.out.print("Select question type: ");
		int questionChoice = Integer.parseInt(in.nextLine());
		
		System.out.print("Enter question: ");
		String question = in.nextLine();
		
		if (questionChoice == 1) {
			System.out.print("A.: ");
			String a = in.nextLine();
			System.out.print("B.: ");
			String b = in.nextLine();
			System.out.print("C.: ");
			String c = in.nextLine();
			System.out.print("D.: ");
			String d = in.nextLine();
			
			System.out.print("Set correct answer: ");
			String answer = in.nextLine();
			int correctAnswer = 1;
			switch (answer.toLowerCase()) {
			case "a":
				correctAnswer = 1;
				break;
			case "b":
				correctAnswer = 2;
				break;
			case "c":
				correctAnswer = 3;
				break;
			case "d":
				correctAnswer = 4;
				break;
			}

			newQuestion = new ClosedQuestion(question, category, a, b, c, d, correctAnswer);
		} else {
			System.out.print("Set correct answer: ");
			int correctAnswer = Integer.parseInt(in.nextLine());
			newQuestion = new OpenQuestion(question, correctAnswer, category);
		}
		
		//add question to list
		Game.addQuestion(newQuestion);
		
		// append the new question to file
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		
		try {
			fout = new FileOutputStream("Questions.txt", true);
			oos = new AppendingObjectOutputStream(fout);	
			
			oos.writeObject(newQuestion);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

    private QuestionCategory getCategory() {
        System.out.print("\nPlease select category from the list below: \n\n");
        Menu questionCategories = new Menu(QuestionCategory.toArray());
        questionCategories.displayMenu();
        int categoryKey = selectMenuOption(questionCategories);
        return QuestionCategory.getCategoryByKey(categoryKey);
    }

    private String getPlayerName() {
        System.out.print("Please enter your name: ");
        return in.nextLine();
    }

    private int selectMenuOption(Menu menu) {
        Display.drawLine();
        System.out.println("\nPlease select an option and enter it: ");
        int selected = Integer.parseInt(in.nextLine());
        while (selected > menu.getMenuSize()) {
            System.out.printf("The valid options are from %d to %d. Please make a new entry: ", 1, menu.getMenuSize());
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

}
