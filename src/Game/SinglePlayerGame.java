package Game;

import Users.Badge;
import Users.Player;


public class SinglePlayerGame extends Game {
    private static final int START_HINTS_REGULAR = 3;
    private static final int START_HINTS_VETERAN = 5;
    private QuestionList questionList;
    private Player player;
    private int gamePointsPlayer;
    private int availableHints;


    public SinglePlayerGame(QuestionCategory questionCategory, String playerName) {
        super(GameMode.SINGLE, questionCategory);
        if (questionCategory.equals(QuestionCategory.RANDOM)){
            questionList = new RandomQuestionList(QuestionType.CLOSED);
        } else {
            questionList = new CategoryQuestionsList(QuestionType.CLOSED, questionCategory);
        }

        player = new Player(playerName);
        gamePointsPlayer = 0;
        availableHints = START_HINTS_REGULAR;
    }

    @Override
    QuestionList initializeQuestionList() {
        return null;
    }

    public void playGame(){
        System.out.println("Play game now");
    }

    private Badge checkForBadge(Player player){
        return null;
    }

    private void addBadge(Player player, Badge badge){
    }

    private void addPointsToPlayer(int gamePointsPlayer){
        player.increasePoints(gamePointsPlayer);
    }

    @Override
    public void endGame() {

    }
}
