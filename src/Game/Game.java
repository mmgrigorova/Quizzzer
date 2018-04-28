package Game;

import Users.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Game implements Finishable, Playable {
    private List<Player> players;
    private GameMode gameMode;
    private QuestionCategory questionCategory;

    protected Game(GameMode gameMode, QuestionCategory questionCategory){
        players = new ArrayList<>();
        this.questionCategory = questionCategory;
        this.gameMode = gameMode;
    }

    abstract QuestionList initializeQuestionList();
    public abstract void endGame();

    private void addPointsToPlayer(Player player, int points){
        player.increasePoints(points);
    }
}
