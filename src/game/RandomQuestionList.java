package game;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class RandomQuestionList extends InGameQuestionList{
	
	private Random rnd;
	private HashSet<Integer> addedQuestions;

	public RandomQuestionList(GameMode gameMode, List<Question> allQuestions) {
		super(gameMode, allQuestions);
		addedQuestions = new HashSet<>();
		rnd = new Random();
		
		while (currentGameQuestions.size() < 10) {
			int questionIndex = rnd.nextInt(allQuestions.size());
			
			if (addedQuestions.contains(questionIndex)) {
				continue;
			}
			
			
			addedQuestions.add(questionIndex);
			
			if (gameMode == GameMode.SINGLE) {
				if (allQuestions.get(questionIndex) instanceof ClosedQuestion
					&& !allQuestions.get(questionIndex).getCategory().equals(QuestionCategory.BONUS)) {
					currentGameQuestions.add(allQuestions.get(questionIndex));
				}
			} else {
				if (allQuestions.get(questionIndex) instanceof OpenQuestion
					&& !allQuestions.get(questionIndex).getCategory().equals(QuestionCategory.BONUS)) {
					currentGameQuestions.add(allQuestions.get(questionIndex));
				}
			}
		}
	}
}
