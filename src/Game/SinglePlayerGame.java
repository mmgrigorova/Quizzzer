package Game;

import Users.Badge;
import Users.Player;
import Utilities.Display;

import java.util.ArrayList;
import java.util.Scanner;


public class SinglePlayerGame extends Game {
    private static final int START_HINTS_REGULAR = 3;
    private static final int START_HINTS_VETERAN = 5;
    private static final int MINIMUM_CORRECT_ANSWERS_FOR_WIN = 2;
    //    private QuestionList questionList;
    private ArrayList<String> questionList;
    private Player player;
    private int gamePointsPlayer;
    private int availableHints;
    private int correctAnswers;
    private Scanner in;

    public SinglePlayerGame(QuestionCategory questionCategory, String playerName) {
        super(GameMode.SINGLE, questionCategory);

//        TODO Uncomment once the question list is available. Use Question List's toString() function when available.
//        if (questionCategory.equals(QuestionCategory.RANDOM)){
//            questionList = new RandomQuestionList(QuestionType.CLOSED);
//        } else {
//            questionList = new CategoryQuestionsList(QuestionType.CLOSED, questionCategory);
//        }
        questionList = new ArrayList<>();
        questionList.add("Who plays the main role in Sherlock Holmes? " +
                "\n a. Benedict Cumberbatch" +
                "\n b. Bruce Willis");
        questionList.add("Where do Outlander's first episodes start?" +
                "\n a. Scotland" +
                "\n b. Bulgaria");


        player = new Player(playerName);
        gamePointsPlayer = 0;
        availableHints = START_HINTS_REGULAR;
        in = new Scanner(System.in);
    }

    @Override
    QuestionList initializeQuestionList() {
        return null;
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
        addPointsToPlayer(gamePointsPlayer);
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
