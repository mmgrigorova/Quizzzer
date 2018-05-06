package game;

import utilities.Display;
import utilities.AppendingObjectOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import users.*;

public class GameLauncher {
    private Scanner in;
    private Game game;

    public GameLauncher() {
        in = new Scanner(System.in);
    }

    public void start() {
        Display.showGameName();
        Game.loadData();

        Menu welcomeMenu = new Menu("New Game", "Ranklist", "How to Play", "Add New Question", "List All Questions",
                					"Admin Panel", "Save and Exit Game");
        int selectedMenuOption;
        
        do {
            welcomeMenu.displayMenu();
            selectedMenuOption = selectMenuOption(welcomeMenu);
            switch (selectedMenuOption) {
                case 1:
                    startGame();
                    break;
                case 2:
                    Ranklist.showRanklist(Game.players);
                    break;
                case 3:
                    Instruction.showInstructions();
                    break;
                case 4:
                	String playerName = getPlayerName(); 
                	if (playerName.equals("admin")) {
                		addNewQuestion();
                		break;
                	}
                	for (Player p : Game.players) {
                		if (p.getUserName().equals(playerName) &&
                			p instanceof VeteranPlayer) {
                			addNewQuestion();
                			break;
                		}
                	}
                    System.out.println("Sorry, you do not have the required privileges to add questions.");
                    break;
                case 5:
                    for (Question q : Game.questions) {
                        System.out.println(q.toString());
                    }
                    break;
                case 6:
                	String userName = getPlayerName();
                	if ("admin".equals(userName.toLowerCase())) {
                		Administrator admin = new Administrator(userName);
                		Menu adminPanel = new Menu("Punish Player", "Delete Player");
                		adminPanel.displayMenu();
                		int selectedGameMode = selectMenuOption(adminPanel);
                		
                		switch (selectedGameMode) {
                		case 1: 
                			System.out.print("> Player name: ");
                			String playerToPunish = in.nextLine();
                			System.out.print("> Points to deduct: ");
                			int pointsToDeduct = Integer.parseInt(in.nextLine());
                			
                			admin.punishPlayer(playerToPunish, pointsToDeduct, Game.players);
                			break;
                		case 2:
                			System.out.print("> Player name: ");
                			String playerToBan = in.nextLine();
                			
                			admin.deletePlayer(playerToBan, Game.players);
                			break;
                		}
                	} else {
                		System.out.println("You have to be Administrator to access the Admin Panel.");
                	}
                	break;
                case 7:
                    Game.saveGame();
            }
        } while (selectedMenuOption != 7);
    }

    private void startGame() {
        Display.printTitle("Please select game mode: ");
        Menu gameModes = new Menu("Single Player", "Double Player");
        gameModes.displayMenu();

        int selectedGameMode = selectMenuOption(gameModes);
        if (selectedGameMode == 1) {
            String playerName = getPlayerName();
            QuestionCategory category = getCategory();
            
            if (category.equals(QuestionCategory.BONUS)) {
            	if(!isVeteran(playerName)) {
            		System.out.println("You have to be a Veteran to play in this category."
    						+ "Obtain 300 points to unlock Bonus category.");
              		startGame();
            	}
            }
            
            game = new SinglePlayerGame(category, playerName);
            Game.welcomePlayer(playerName, ((SinglePlayerGame) game).getPlayer());
            game.playGame();
        } else {
            String playerName1 = getPlayerName();
            String playerName2 = getPlayerName();
            QuestionCategory category = getCategory();

            if (category.equals(QuestionCategory.BONUS)) {
            	boolean isVeteranPlayer1 = isVeteran(playerName1);
            	boolean isVeteranPlayer2 = isVeteran(playerName2);
            	
            	if (!isVeteranPlayer1 && !isVeteranPlayer2) {
            		System.out.println("None of the players is Veteran."
            						+ "You need at least 300 points to unlock Bonus category.");
              		startGame();
            	}
            }
            
            game = new DoublePlayerGame(category, playerName1, playerName2);
            game.playGame();
        }
    }
    
    private boolean isVeteran(String playerName) {
    	for (Player p : Game.players) {
    		if (p.getUserName().equals(playerName)) {
    			if (!(p instanceof VeteranPlayer)) {
            		return false;
            	} else 
            		return true;
    		}
    	}	
    	return false;
    }


    private void addNewQuestion() {
        Question newQuestion = null;

        QuestionCategory category = getCategory();

        Menu questionType = new Menu("Multi-answer question", "Open-answer question");
        questionType.displayMenu();
      
        int questionChoice = selectMenuOption(questionType);

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

//        // append the new question to file
//        FileOutputStream fout = null;
//        ObjectOutputStream oos = null;
//
//        try {
//            fout = new FileOutputStream("Questions.txt", true);
//            oos = new AppendingObjectOutputStream(fout);
//
//            oos.writeObject(newQuestion);
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        } catch (IOException e) {
//            System.out.println("Error initializing stream");
//        } finally {
//            if (fout != null) {
//                try {
//                    fout.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (oos != null) {
//                try {
//                    oos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    private QuestionCategory getCategory() {
        Display.printTitle("Please select category from the list below: ");
        Menu questionCategories = new Menu(QuestionCategory.toArray());
        questionCategories.displayMenu();
        int categoryKey = selectMenuOption(questionCategories);
        return QuestionCategory.getCategoryByKey(categoryKey);
    }

    private String getPlayerName() {
        System.out.print("> Please enter your name: ");
        return in.nextLine();
    }

    private int selectMenuOption(Menu menu) {
        Display.drawLine();
        System.out.print("> Please select an option and enter it: ");
        int selected = 0;
        while (selected < 1 || selected > menu.getMenuSize()) {
        	try {
        		selected = Integer.parseInt(in.nextLine());
        	} catch (NumberFormatException e) {
                System.out.printf("The valid options are from %d to %d. Please make a new entry: ", 1, menu.getMenuSize());
                continue;
        	}
        	if (selected < 1 || selected > menu.getMenuSize()) {
                System.out.printf("The valid options are from %d to %d. Please make a new entry: ", 1, menu.getMenuSize());
        	}
        }
        return selected;
    }


}
