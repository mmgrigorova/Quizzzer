package Game;

public class DoublePlayerGame extends Game {
    protected DoublePlayerGame(QuestionCategory questionCategory, GameMode gameMode) {
        super(gameMode, questionCategory);
    }

    @Override
    QuestionList initializeQuestionList() {
        return null;
    }

    @Override
    public void endGame() {

    }
}
