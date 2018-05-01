package game;

import java.util.List;

public class CategoryQuestionsList extends InGameQuestionList {
	
	public CategoryQuestionsList(GameMode gameMode, QuestionCategory category, List<Question> allQuestions) {
		super(gameMode, allQuestions);
		
		for (int i = 0; i < allQuestions.size(); i++) {
			if (currentGameQuestions.size() == 10) {
				break;
			}
			
			Question currentQuestion = allQuestions.get(i);
			
			if (gameMode == GameMode.SINGLE) {
				if (currentQuestion instanceof ClosedQuestion &&
					currentQuestion.getCategory().equals(category)) {
						currentGameQuestions.add(currentQuestion);
				}
			} else {
				if (currentQuestion instanceof OpenQuestion &&
					currentQuestion.getCategory().equals(category)) {
						currentGameQuestions.add(currentQuestion);
					}
			}
		}
	}
}
