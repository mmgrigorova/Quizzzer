package users;

import java.util.ArrayList;

public class Administrator extends User {

	public Administrator(String userName) {
		super(userName);
	}
	
	public void punishPlayer(String playerName, int pointsToDeduct, ArrayList<Player> players) {
		boolean operationDone = false;
		for (Player p : players) {
			if (p.getUserName().equals(playerName)) {
				p.decreasePoints(pointsToDeduct);
				operationDone = true;
			}
		}
		if (!operationDone) {
			System.out.println("There is no such player");
		}
	}
}
