package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class InGameQuestionList {
	protected ArrayList<Question> currentGameQuestions;
	protected int indexInList;
	protected GameMode gameMode;
	
	public InGameQuestionList(GameMode gameMode, List<Question> allQuestions) {
		this.gameMode = gameMode;
		Collections.shuffle(allQuestions);
		currentGameQuestions = new ArrayList<>();
		indexInList = -1;
	}

	public ArrayList<Question> getQuestions() {
		return currentGameQuestions;
	}
}
