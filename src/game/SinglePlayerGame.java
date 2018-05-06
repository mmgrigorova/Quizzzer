package game;

import users.Badge;
import users.Player;
import users.VeteranPlayer;
import utilities.Display;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class SinglePlayerGame extends Game {
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
        		}
				break;
			}
		}   
        if (player == null) {
        	player = new Player(playerName);
        	Game.players.add(player);
        }
    }

    public void playGame() {
    	for (Question currentQuestion : questionList.getQuestions()) {
			displayGameInformation(player.getUserName(), gamePointsPlayer);
            Display.printFormatted("Question " + String.valueOf(currentQuestionNumber));
            Display.skipLine();
			Display.printFormatted(currentQuestion.toString());
			Display.skipLine();

			int playerAnswer = getPlayersAnswer();
			while (playerAnswer == 5) {
				if (currentQuestion instanceof Rateable) {
					((Rateable)currentQuestion).rate();
					Display.printFormatted("Question rating increased!");
					playerAnswer = getPlayersAnswer();
				}
			} 
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
        System.out.print("> Your answer(press \'l\' to rate question): ");
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
			case "l":
				answer = 5;
				break;
			default:
				System.out.printf("'%s' is not a valid option. Please make a new entry.\n", playerInput);
	            getPlayersAnswer();
		}
        return answer;
    }

    private void addPointsToGame(int questionPoints) {
        gamePointsPlayer += questionPoints;
    }

    @Override
    public void endGame() {
        Display.drawLine("*");
        String finalMessage = String.format("Congratulations, %s! You have answered correctly to %d questions and " +
                "have won %d points!\n", player.getUserName(), correctAnswers, gamePointsPlayer);
        addPointsToPlayer(player, gamePointsPlayer);
        Display.printFormatted(finalMessage);
        player.checkForBadges(gamePointsPlayer);
        Display.skipLine();
        Display.drawLine("*");
    }
}