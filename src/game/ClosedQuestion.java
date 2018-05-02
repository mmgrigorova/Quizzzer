package game;

import utilities.Display;

import java.util.HashMap;

public class ClosedQuestion extends Question implements Validateable{
	
	private HashMap<Integer, String> possibleAnswers;
	
	public ClosedQuestion() {
		super();
	}

	public ClosedQuestion(String questionTitle, QuestionCategory category,
							String a, String b, String c, String d, int correctAnswer) {
		super(questionTitle, correctAnswer, category);
		possibleAnswers = new HashMap<>();
		possibleAnswers.put(1, a);
		possibleAnswers.put(2, b);
		possibleAnswers.put(3, c);
		possibleAnswers.put(4, d);
	}
	
	@Override 
	public String toString() {
		String spaces = "    ";
		return super.toString() + String.format("A. %s" + spaces + "B. %s" + spaces + "C. %s" + spaces + "D. %s",
												possibleAnswers.get(1),
												possibleAnswers.get(2),
												possibleAnswers.get(3),
												possibleAnswers.get(4));
	}

	@Override
	public int validateAnswer(int playerAnswer) {
		if (playerAnswer == correctAnswer) {
			Display.printFormatted("** Correct! You've won 10 points. **");
			Display.skipLine();
			return 10;
		} else {
			Display.printFormatted("** Wrong! The correct answer was " + possibleAnswers.get(correctAnswer) + " **");
			Display.skipLine();
			return 0;
		}
	}
	
}
