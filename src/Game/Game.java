package Game;

import Users.Player;
import java.util.List;

public abstract class Game implements Finishable, Playable {
    private List<Player> players;
    private QuestionList questionList;
    private GameMode gameMode;

    abstract QuestionList initializeQuestionList();
}
