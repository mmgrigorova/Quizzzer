package game;

import java.io.Serializable;

public abstract class Question implements Serializable, Validateable {
	private String questionTitle;
	protected int correctAnswer;
	private QuestionCategory category;
	
	public Question() {
		
	}
	
	public Question(String questionTitle, int correctAnswer, QuestionCategory category) {
		this.questionTitle = questionTitle;
		this.correctAnswer = correctAnswer;
		this.category = category;
	}
	
	@Override
	public String toString() {
		return String.format("%s\n", questionTitle);
	}

	public QuestionCategory getCategory() {
		return category;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	
}
