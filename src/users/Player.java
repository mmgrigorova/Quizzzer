package users;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

import game.QuestionCategory;

public class Player extends User implements Punishable {
	private int points;
	private List<Badge> badges;
	private HashMap<QuestionCategory, Integer> answeredQuestions;
	
	public List<Badge> getBadges() {
		return badges;
	}

	// if there's no such player, create a new player
	public Player(String userName) {
		this(userName, 0, new ArrayList<>());
	}
	
	// if player exists, get his data from ranklist
	public Player(String userName, int points, List<Badge> badges) {
		super(userName);
		this.points = points;
		this.badges = badges;
		answeredQuestions = new HashMap<>();
		
		EnumSet.allOf(QuestionCategory.class)
		  .forEach(category -> answeredQuestions.put(category, 0));
	}
	
	public HashMap<QuestionCategory, Integer> getAnsweredQuestions() {
		return answeredQuestions;
	}

	public void setAnsweredQuestions(HashMap<QuestionCategory, Integer> answeredQuestions) {
		this.answeredQuestions = answeredQuestions;
	}

	public void increasePoints(int pointsToAdd){
		points += pointsToAdd;
	}

	@Override
	public void decreasePoints(int pointsToDeduct) {
		if (points <= pointsToDeduct) {
			points = 0;
		} else {
			points -= pointsToDeduct;
		}
	}
	
	public int getPoints() {
		return points;
	}
	
	public void increaseAnsweredQuestions(QuestionCategory category) {
		int answeredCount = answeredQuestions.get(category);
		answeredCount++;
		answeredQuestions.put(category, answeredCount);
	}

	@Override
	public String toString() {
		String str = userName + " " + points;
		return str;
	}
}
