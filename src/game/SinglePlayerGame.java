package game;

import users.Badge;
import users.Player;
import users.VeteranPlayer;
import utilities.Display;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class SinglePlayerGame extends Game {
    private static final int MINIMUM_CORRECT_ANSWERS_FOR_WIN = 5;
    private InGameQuestionList questionList;
    private Player player;
    private int gamePointsPlayer;
    private int correctAnswers;
    private int currentQuestionNumber;
    private Scanner in;

    public SinglePlayerGame(QuestionCategory questionCategory, String playerName) {
        super(questionCategory);
        
        gamePointsPlayer = 0;
        correctAnswers = 0;
        currentQuestionNumber = 1;
        in = new Scanner(System.in);
        
        if (questionCategory.equals(QuestionCategory.RANDOM)){
            questionList = new RandomQuestionList(GameMode.SINGLE, Game.questions);
        } else {
            questionList = new CategoryQuestionsList(GameMode.SINGLE, questionCategory, Game.questions);
        }
        

        player = null;
        
        for (Iterator<Player> it = players.iterator(); it.hasNext(); ) {
        	Player p = it.next();
			if (p.getUserName().equals(playerName)) {
				player = p;
				if (p.getPoints() > 300) {
        			List<Badge> badges = p.getBadges();
        			int points = p.getPoints();
        			player = new VeteranPlayer(playerName, points, badges);
        			it.remove();
        			Game.players.add(player);
        			//System.out.println(player.getClass().getName());
        		}
				break;
			}
		}   
        if (player == null) {
        	player = new Player(playerName);
        	Game.players.add(player);
        }
     
        welcomePlayer(playerName,player);
    }

    public void playGame() {
    	for (Question currentQuestion : questionList.getQuestions()) {
			displayGameInformation(player.getUserName(), gamePointsPlayer);
            Display.printFormatted("Question " + String.valueOf(currentQuestionNumber));
            Display.skipLine();
			Display.printFormatted(currentQuestion.toString());
			Display.skipLine();

			int playerAnswer = getPlayersAnswer();
			int pointsWon = currentQuestion.validateAnswer(playerAnswer);
			
			if (pointsWon > 0) {
				addPointsToGame(pointsWon);
				correctAnswers++;
				player.increaseAnsweredQuestions(currentQuestion.getCategory());
			}
			currentQuestionNumber += 1;
    	}
    	endGame();
    }

    public Player getPlayer(){
        return player;
    }
    
     protected int getPlayersAnswer() {
        System.out.print("> Your answer: ");
        String playerInput = in.nextLine();
        Display.skipLine();

		int answer = 1;
		switch (playerInput.toLowerCase()) {
			case "a":
				answer = 1;
				break;
			case "b":
				answer = 2;
				break;
			case "c":
				answer = 3;
				break;
			case "d":
				answer = 4;
				break;
			default:
				System.out.printf("'%s' is not a valid option. Please make a new entry.\n", playerInput);
	            getPlayersAnswer();
		}
        return answer;
    }

//    private Badge checkForBadge(Player player) {
//        return null;
//    }

//    private void addBadge(Player player, Badge badge) {
//    }

    private void addPointsToGame(int questionPoints) {
        gamePointsPlayer += questionPoints;
    }

    @Override
    public void endGame() {
        Display.drawLine("*");
        String finalMessage;
        if (correctAnswers >= MINIMUM_CORRECT_ANSWERS_FOR_WIN) {
            addPointsToPlayer(player, gamePointsPlayer);
            finalMessage = String.format("Congratulations! You have answered correctly to %d questions and have won %d " +
                            "points!\n", correctAnswers, gamePointsPlayer);
        } else {
            finalMessage = String.format("Oops! You need %d correct answers in order to win and you have only" +
                    " %d. Try again!",MINIMUM_CORRECT_ANSWERS_FOR_WIN, correctAnswers);
        }
        Display.printFormatted(finalMessage);
        Display.skipLine();
        Display.drawLine("*");
    }
}