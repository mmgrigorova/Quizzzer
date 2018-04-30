package Game;

public class DoublePlayerGame extends Game {
	
    protected DoublePlayerGame(QuestionCategory questionCategory, String playerName) {
        super(GameMode.DOUBLE, questionCategory);
    }

    @Override
    QuestionList initializeQuestionList() {
        return null;
    }

    @Override
    public void endGame() {

    }
}
