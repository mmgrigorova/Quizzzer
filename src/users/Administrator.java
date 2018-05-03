package users;

import java.util.ArrayList;
import java.util.List;

public class Administrator extends User {

	public Administrator(String userName) {
		super(userName);
	}
	
	public void punishPlayer(String playerName, int pointsToDeduct, List<Player> players) {
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
	
	public void deletePlayer(String playerName, List<Player> players) {
		boolean operationDone = false;
		for (Player p : players) {
			if (p.getUserName().equals(playerName)) {
				players.remove(p);
				operationDone = true;
			}
		}
		if (!operationDone) {
			System.out.println("There is no such player");
		}
	}
}
