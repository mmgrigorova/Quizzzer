package Game;

import Users.Badge;
import Users.Player;
import utilities.Display;
import java.util.Scanner;


public class SinglePlayerGame extends Game {
    private static final int MINIMUM_CORRECT_ANSWERS_FOR_WIN = 2;
    private InGameQuestionList questionList;
    private Player player;
    private int gamePointsPlayer;
    private int correctAnswers;
    private Scanner in;

    public SinglePlayerGame(QuestionCategory questionCategory, String playerName) {
        super(questionCategory);
        
        gamePointsPlayer = 0;
        correctAnswers = 0;
        in = new Scanner(System.in);

        if (questionCategory.equals(QuestionCategory.RANDOM)){
            questionList = new RandomQuestionList(GameMode.SINGLE, Game.questions);
        } else {
            questionList = new CategoryQuestionsList(GameMode.SINGLE, questionCategory, Game.questions);
        }

        player = null;
        
        for (Player p : Game.players) {
        	if (p.getUserName().equals(playerName)) {
        		player = p;
        		break;
        	}
        }       
        if (player == null) {
        	player = new Player(playerName);
        	Game.players.add(player);
        }
        
        System.out.println("Hello " + playerName + ", you have " + player.getPoints() + " points.");
        System.out.println();

    }

    public void playGame() {
    	for (Question currentQuestion : questionList.getQuestions()) {
			displayGameInformation(player.getUserName(), gamePointsPlayer);
			
			System.out.println(currentQuestion.toString());
			
			int playerAnswer = getPlayersAnswer();
			int pointsWon = currentQuestion.validateAnswer(playerAnswer);
			
			if (pointsWon > 0) {
				addPointsToGame(pointsWon);
				correctAnswers++;
			}
    	}
    	endGame();
    }
    
     protected int getPlayersAnswer() {
        
        String playerInput = in.nextLine();
        
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

    public void playGame() {
        for (String question : questionList) {
            displayGameInformation(gamePointsPlayer);
            //display question - questionList TODO
            System.out.println(question);
            getPlayersAnswer();
            // TODO replace with Question's method
            //boolean isAnswerCorrect = question.validateAnswer();
            //TODO Methods in Question:
//            isAnswerCorrect ? showCorrectAnswer() : showIncorrectAnswer();
            boolean isAnswerCorrect = true;

//            TODO addPointsToPlayer(question.points);
            if (isAnswerCorrect) {
                addPointsToGame(100);
                correctAnswers += 1;
            }
        }
        endGame();
    }

    private void displayGameInformation(int gamePointsPlayer) {
        Display.drawPlayerHeader(gamePointsPlayer);
    }

    private char getPlayersAnswer() {
        System.out.println("Your answer: ");
        char answer = in.nextLine().charAt(0);
        if (answer < 97 || answer > 100) {
            System.out.printf("'%c' is not a valid option. Please make a new entry.\n", answer);
            getPlayersAnswer();
        }
        return answer;
    }

    private Badge checkForBadge(Player player) {
        return null;
    }

    private void addBadge(Player player, Badge badge) {
    }

    private void addPointsToPlayer(int gamePointsPlayer) {
        player.increasePoints(gamePointsPlayer);
    }

    private void addPointsToGame(int questionPoints) {
        gamePointsPlayer += questionPoints;
    }

    @Override
    public void endGame() {
        addPointsToPlayer(player, gamePointsPlayer);

        Display.drawLine();
        if (correctAnswers >= MINIMUM_CORRECT_ANSWERS_FOR_WIN) {
            System.out.printf("Congratulations! You have answered correctly to %d questions and have won %d " +
                            "points!\n",
                    correctAnswers,
                    gamePointsPlayer);
        }
        Display.drawLine();
    }
}