package game;

public class OpenQuestion extends Question {

	public OpenQuestion() {
		super();
	}
	
	public OpenQuestion(String questionTitle, int correctAnswer, QuestionCategory category) {
		super(questionTitle, correctAnswer, category);
	}

	@Override
	public int validateAnswer(int playerAnswer) {
		return Math.abs(correctAnswer - playerAnswer);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
