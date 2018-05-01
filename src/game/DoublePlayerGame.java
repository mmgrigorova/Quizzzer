package game;

import java.util.Scanner;

import users.Player;

public class DoublePlayerGame extends Game {
	private InGameQuestionList questionList;
    private Player player1, player2;
    private int gamePointsPlayer1, gamePointsPlayer2;
    private Scanner in;
	

	protected DoublePlayerGame(QuestionCategory questionCategory, String playerName1, String playerName2) {
		super(questionCategory);
		
		gamePointsPlayer1 = gamePointsPlayer2 = 0;
		in = new Scanner(System.in);
		
		if (questionCategory.equals(QuestionCategory.RANDOM)){
            questionList = new RandomQuestionList(GameMode.DOUBLE, Game.questions);
        } else {
            questionList = new CategoryQuestionsList(GameMode.DOUBLE, questionCategory, Game.questions);
        }
		
		player1 = player2 = null;
        
        for (Player p : Game.players) {
        	if (p.getUserName().equals(playerName1)) {
        		player1 = p;
        	}
        	if (p.getUserName().equals(playerName2)) {
        		player2 = p;
        	}
        }   
        
        if (player1 == null) {
        	player1 = new Player(playerName1);
        	Game.players.add(player1);
        }
        if (player2 == null) {
        	player2 = new Player(playerName2);
        	Game.players.add(player2);
        }
        
        System.out.println("Hello " + playerName1 + ", you have " + player1.getPoints() + " points.");
        System.out.println("Hello " + playerName2 + ", you have " + player2.getPoints() + " points.");
        System.out.println();
	}
	
	@Override
	public void playGame() {
		for (Question currentQuestion : questionList.getQuestions()) {
			displayGameInformation(player1.getUserName(), gamePointsPlayer1);
			displayGameInformation(player2.getUserName(),gamePointsPlayer2);
			
			System.out.println(currentQuestion.toString());
			
			System.out.print(player1.getUserName() + ": ");
			int player1answer = getPlayersAnswer();
			System.out.print(player2.getUserName() + ": ");
			int player2answer = getPlayersAnswer();
			
			int player1score = currentQuestion.validateAnswer(player1answer);
			int player2score = currentQuestion.validateAnswer(player2answer);
			
			System.out.println("Correct answer is: " + currentQuestion.getCorrectAnswer());
			
			if (player1score > player2score) {
				System.out.println(player2.getUserName() + " was closer to the answer.");
				gamePointsPlayer2 += 10;
			} 
			else if (player1score < player2score) {
				System.out.println(player1.getUserName() + " was closer to the answer.");
				gamePointsPlayer1 += 10;
			} 
			else {
				System.out.println("Both players are correct.");
				gamePointsPlayer1 += 10;				
				gamePointsPlayer2 += 10;
			}
		}
		endGame();
	}

	@Override
	public void endGame() {
		addPointsToPlayer(player1, gamePointsPlayer1);
		addPointsToPlayer(player2, gamePointsPlayer2);
		
		if (gamePointsPlayer1 > gamePointsPlayer2) {
			System.out.printf("%s has won!\n%s has earned %d points, while %s has earned %d points.\n",
								player1.getUserName(), player1.getUserName(), gamePointsPlayer1,
								player2.getUserName(), gamePointsPlayer2);
		} 
		else if (gamePointsPlayer1 < gamePointsPlayer2) {
			System.out.printf("%s has won!\n%s has earned %d points, while %s has earned %d points.\n",
					player2.getUserName(), player2.getUserName(), gamePointsPlayer2,
					player1.getUserName(), gamePointsPlayer1);
		}
		else {
			System.out.println("The game ends as a draw. Both players have earned " + gamePointsPlayer1 + " points.");
		}
		
	}

	@Override
	protected int getPlayersAnswer() {
		 String playerInput = in.nextLine();
		 
		 try {
			 int answer = Integer.parseInt(playerInput);
			 return answer;
		 } catch (NumberFormatException e) {
			 System.out.println("Invalid input, try again");
			 return getPlayersAnswer();
		 }
	}

	
}
