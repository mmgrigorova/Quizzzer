package users;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

import game.QuestionCategory;
import utilities.Display;

public class Player extends User implements Punishable {
	private int points;
	private List<Badge> badges;
	private HashMap<QuestionCategory, Integer> answeredQuestions;


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

	
	public List<Badge> getBadges() {
		return badges;
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
	
	public void checkForBadges(int pointsWonInGame) {
		if (pointsWonInGame == 100) {
			// check for Perfect Game badge
			boolean hasPerfectGameBadge = false;
			for (Badge badge : badges) {
				if (badge.getBadgeName().equals("Perfect Game")) {
					hasPerfectGameBadge = true;
					break;
				}
			}
			if (!hasPerfectGameBadge) {
				Display.printFormatted("You've scored 100 points in a single game! "
									+ "You've been awarded the 'Perfect Game' badge.");
				Badge perfectGame = new Badge("Perfect Game", "Score 100 points in a single game.");
				badges.add(perfectGame);
			}
		}
		
		// check for master badge
		for (QuestionCategory category : answeredQuestions.keySet()) {
			if (answeredQuestions.get(category) >= 15) {
				boolean hasMasterBadge = false;
				String categoryName = category.toString() + " Master";
				for (Badge badge : badges) {
					if (badge.getBadgeName().equals(categoryName)) {
						hasMasterBadge = true;
						break;
					}
				}
				if (!hasMasterBadge) {
					System.out.println("Congratulations, " + userName + "! "
										+ "You've answered 15 " + category.toString() + " questions!"
										+ "You've been awarded the '" + category.toString() + " Master' badge.");
					Badge master = new Badge(categoryName,
											"Answered 15 or more " + category.toString() + " questions.");
					badges.add(master);
				}
			}
		}
	}

	@Override
	public String toString() {
		String str = userName + " " + points;
		return str;
	}
}
