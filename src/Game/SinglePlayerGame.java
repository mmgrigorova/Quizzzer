package Game;

public class SinglePlayerGame extends Game {
    private QuestionList questionList;

    public SinglePlayerGame(QuestionCategory questionCategory, GameMode single, String playerName) {
        super(GameMode.SINGLE, questionCategory);
        if (questionCategory.equals(QuestionCategory.RANDOM)){
            questionList = new RandomQuestionList(QuestionType.CLOSED);
        } else {
            questionList = new CategoryQuestionsList(QuestionType.CLOSED, questionCategory);
        }
    }

    @Override
    QuestionList initializeQuestionList() {
        return null;
    }

    @Override
    public void endGame() {

    }
}
